package View;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.Kontroler;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UnosView extends Dialog {

	protected Object result;
	protected Shell shellUnosPutovanja;
	private Text textPrezime;
	private Text textGradPolaska;
	private Text textDestinacija;
	private Text textCijena;
	private Kontroler kontroler = new Kontroler();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UnosView(Shell parent, int style) {
		super(parent, style);
		setText("Unos putovanja");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shellUnosPutovanja.open();
		shellUnosPutovanja.layout();
		Display display = getParent().getDisplay();
		while (!shellUnosPutovanja.isDisposed()) {
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
		shellUnosPutovanja = new Shell(getParent(), getStyle());
		shellUnosPutovanja.setSize(256, 327);
		shellUnosPutovanja.setText(getText());
		
		Label lblNaslov = new Label(shellUnosPutovanja, SWT.NONE);
		lblNaslov.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblNaslov.setBounds(10, 10, 93, 25);
		lblNaslov.setText("Unos");
		
		Label lblDatum = new Label(shellUnosPutovanja, SWT.NONE);
		lblDatum.setBounds(10, 59, 55, 15);
		lblDatum.setText("Datum:");
		
		Label lblPrezime = new Label(shellUnosPutovanja, SWT.NONE);
		lblPrezime.setBounds(10, 98, 55, 15);
		lblPrezime.setText("Prezime:");
		
		Label lblGradPolaska = new Label(shellUnosPutovanja, SWT.NONE);
		lblGradPolaska.setBounds(10, 135, 80, 15);
		lblGradPolaska.setText("Grad polaska:");
		
		Label lblDestinacija = new Label(shellUnosPutovanja, SWT.NONE);
		lblDestinacija.setBounds(10, 171, 66, 15);
		lblDestinacija.setText("Destinacija:");
		
		Label lblCijena = new Label(shellUnosPutovanja, SWT.NONE);
		lblCijena.setBounds(10, 205, 55, 15);
		lblCijena.setText("Cijena:");
		
		DateTime dateTime = new DateTime(shellUnosPutovanja, SWT.BORDER);
		dateTime.setBounds(124, 59, 79, 24);
		
		textPrezime = new Text(shellUnosPutovanja, SWT.BORDER);
		textPrezime.setBounds(124, 98, 93, 21);
		
		textGradPolaska = new Text(shellUnosPutovanja, SWT.BORDER);
		textGradPolaska.setText("");
		textGradPolaska.setBounds(124, 135, 93, 21);
		
		textDestinacija = new Text(shellUnosPutovanja, SWT.BORDER);
		textDestinacija.setText("");
		textDestinacija.setBounds(124, 171, 93, 21);
		
		textCijena = new Text(shellUnosPutovanja, SWT.BORDER);
		textCijena.setText("");
		textCijena.setBounds(124, 205, 76, 21);
		
		Label lblKn = new Label(shellUnosPutovanja, SWT.NONE);
		lblKn.setBounds(202, 211, 55, 15);
		lblKn.setText("kn");
		
		Button btnOk = new Button(shellUnosPutovanja, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter(){
			
			
		public void widgetSelected(SelectionEvent arg0) {
			
			spremiUListu();
				//kontroler.spremiUListu();
			//kontroler.unesiPodatke(datum, grad_polazak,String grad_destinacija,String prezime,double cijena);
				
				//kontroler.spremiUDatoteku();
				 

		}
		private void spremiUListu(){
				if(textGradPolaska.getText().isEmpty()|| textPrezime.getText().isEmpty() || textDestinacija.getText().isEmpty()||
						textCijena.getText().isEmpty()){
					 MessageBox msgObavijest1 = new MessageBox(shellUnosPutovanja,SWT.OK);
					 msgObavijest1.setMessage("Niste popunili sva polja!");
					 msgObavijest1.open();
				}
				else{
				
				String datum,Gradpolaska,Destinacija,Prezime;
				double cijenaa;
				datum = dateTime.toString().substring(dateTime.toString().indexOf("{")+1, dateTime.toString().indexOf("}"));
				cijenaa = Double.parseDouble(textCijena.getText());
				
				Gradpolaska = textGradPolaska.getText();
				Destinacija = textDestinacija.getText();
				Prezime = textPrezime.getText();
				
				kontroler.unesiPodatke(datum, Gradpolaska, Destinacija, Prezime, cijenaa);
				
				MessageBox msgObavijest1 = new MessageBox(shellUnosPutovanja,SWT.OK);
				 msgObavijest1.setMessage("Putovanje kreirano i spremljeno!");
				 msgObavijest1.open();
				 
				 shellUnosPutovanja.close();
				}
			}
		});
		
		
		btnOk.setBounds(86, 263, 75, 25);
		btnOk.setText("OK");
		
	}
	public void setKontroler (Kontroler kontroler){
		this.kontroler = kontroler;
	}
	
}
