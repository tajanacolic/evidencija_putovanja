package View;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;


import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.Kontroler;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;

public class PretragaView extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text textDatum;
	private Text textPrezime;
	private Kontroler kontroler = new Kontroler();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public PretragaView(Shell parent, int style) {
		super(parent, style);
		setText("Pretraga putovanja");
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
		shell.setSize(420, 335);
		shell.setText(getText());
		
		Label labelNaslov = new Label(shell, SWT.NONE);
		labelNaslov.setText("Pretraga");
		labelNaslov.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		labelNaslov.setBounds(10, 10, 84, 24);
		
		Label lblDatum = new Label(shell, SWT.NONE);
		lblDatum.setBounds(10, 62, 55, 15);
		lblDatum.setText("Datum:");
		
		textDatum = new Text(shell, SWT.BORDER);
		textDatum.setBounds(72, 59, 76, 21);
		
		Label lblPrezime = new Label(shell, SWT.NONE);
		lblPrezime.setBounds(154, 62, 55, 15);
		lblPrezime.setText("Prezime:");
		
		textPrezime = new Text(shell, SWT.BORDER);
		textPrezime.setBounds(226, 59, 76, 21);
		
		StyledText styledText = new StyledText(shell, SWT.BORDER);
		styledText.setBounds(10, 95, 394, 170);
		
		Button btnPretrai = new Button(shell, SWT.NONE);
		btnPretrai.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				styledText.setText(kontroler.pretraziPutovanje(textDatum.getText(),textPrezime.getText()));
			}
		});
		btnPretrai.setBounds(329, 57, 75, 25);
		btnPretrai.setText("Pretra\u017Ei");
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
		});
		btnOk.setBounds(168, 271, 75, 25);
		btnOk.setText("OK");
	

	}
	public void setKontroler(Kontroler kontroler){
		this.kontroler = kontroler;
	}
}

