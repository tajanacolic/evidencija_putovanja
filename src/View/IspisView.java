package View;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.Kontroler;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;

public class IspisView extends Dialog {

	protected Object result;
	protected Shell shell;
	private Kontroler kontroler = new Kontroler();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public IspisView(Shell parent, int style) {
		super(parent, style);
		setText("Prikaz putovanja");
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
		shell.setSize(414, 342);
		shell.setText(getText());
		
		Label lblNaslov = new Label(shell, SWT.NONE);
		lblNaslov.setFont(SWTResourceManager.getFont("Segoe UI Light", 12, SWT.NORMAL));
		lblNaslov.setBounds(10, 10, 83, 22);
		lblNaslov.setText("Ispis");
		
		Label lblDatum = new Label(shell, SWT.NONE);
		lblDatum.setAlignment(SWT.CENTER);
		lblDatum.setBounds(71, 49, 55, 15);
		lblDatum.setText("Datum");
		
		Label lblPrezime = new Label(shell, SWT.NONE);
		lblPrezime.setAlignment(SWT.CENTER);
		lblPrezime.setBounds(132, 49, 55, 15);
		lblPrezime.setText("Prezime");
		
		Label lblGradPolaska = new Label(shell, SWT.NONE);
		lblGradPolaska.setBounds(193, 49, 68, 15);
		lblGradPolaska.setText("Grad polaska");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(267, 49, 68, 15);
		lblNewLabel.setText("Destinacija");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(341, 49, 55, 15);
		lblNewLabel_1.setText("Cijena");
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
		});
		btnOk.setBounds(183, 278, 75, 25);
		btnOk.setText("OK");
		
		Label lblRedniBroj = new Label(shell, SWT.NONE);
		lblRedniBroj.setBounds(10, 49, 55, 15);
		lblRedniBroj.setText("Redni broj");
		
		StyledText styledText = new StyledText(shell, SWT.BORDER);
		styledText.setBounds(10, 70, 388, 201);
		styledText.setText(kontroler.ispisPutovanja());
		
		
		
		
	}
	
	public void setKontroler(Kontroler kontroler){
		this.kontroler = kontroler;
	}
}
