package View;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.Kontroler;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;

public class BrisanjeView extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text textBroj;
	private Kontroler kontroler = new Kontroler();
	//private MessageBox messageBox= new MessageBox(shell);


	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public BrisanjeView(Shell parent, int style) {
		super(parent, style);
		setText("Brisanje putovanja");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(311, 345);
		shell.setText(getText());
		
		Label lblNaslov = new Label(shell, SWT.NONE);
		lblNaslov.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblNaslov.setBounds(10, 10, 75, 24);
		lblNaslov.setText("Brisanje");
		
		Label lblUnesiRedniBroj = new Label(shell, SWT.NONE);
		lblUnesiRedniBroj.setBounds(10, 59, 123, 15);
		lblUnesiRedniBroj.setText("Redni broj rezervacije:");
		
		textBroj = new Text(shell, SWT.BORDER);
		textBroj.setBounds(139, 53, 76, 21);
		
		StyledText styledText = new StyledText(shell, SWT.BORDER);
		styledText.setBounds(10, 99, 286, 176);
		styledText.setText(kontroler.ispisPutovanja());
		
		Button btnObriši = new Button(shell, SWT.NONE);
		btnObriši.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				int i;
				try {
					if(textBroj.getText().isEmpty()){
						MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
						 msgObavijest1.setMessage("Niste unijeli redni broj!");
						 msgObavijest1.open();
					}
					else{
						i = Integer.parseInt(textBroj.getText());
						String poruka = kontroler.izbrisiPutovanje(i);
						if(poruka != ""){
							MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
							 msgObavijest1.setMessage(poruka);
							 msgObavijest1.open();
						}
						else{
							styledText.setText(kontroler.ispisPutovanja());
						}
					}
				} 
				catch (NumberFormatException e) {
					MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
					 msgObavijest1.setMessage("Niste unijeli broj!");
					 msgObavijest1.open();
					textBroj.setText("");
				}
			}
				
				/*try{
					int rednibroj = Integer.valueOf(textBroj.getText());
				    
					kontroler.izbrisiPutovanje(rednibroj);
					
					//textBroj.setText(kontroler.izbrisiPutovanje(Integer.parseInt(textBroj.getText())));					
					styledText.setText(kontroler.ispisPutovanja()); 
					
					kontroler.spremiUDatoteku();
					
					//int i = rednibroj;
					
					if(i <0 || i>kontroler.listaPutovanja.size()-1){
						MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
						 msgObavijest1.setMessage("Putovanje je izbrisano!");
						 msgObavijest1.open();
					}else{
						MessageBox msgObavijest2 = new MessageBox(shell,SWT.OK);
						 msgObavijest2.setMessage("Nije dobar broj");
						 msgObavijest2.open();
					}
					 
					 MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
					 msgObavijest1.setMessage("");
					 msgObavijest1.open();
					
				}
				catch(NumberFormatException e){
					MessageBox msgObavijest1 = new MessageBox(shell,SWT.OK);
					 msgObavijest1.setMessage("Redni broj putovanja niste unijeli!");
					 msgObavijest1.open();
				}*/
		});
		btnObriši.setBounds(221, 49, 75, 25);
		btnObriši.setText("Obri\u0161i");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
		});
		btnNewButton.setBounds(112, 281, 75, 25);
		btnNewButton.setText("OK");
		

	}
	public void setKontroler (Kontroler kontroler){
		this.kontroler = kontroler;
	}
}
