package View;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;

import Controller.Kontroler;
import View.UnosView;
import View.IspisView;
import View.BrisanjeView;
import View.PretragaView;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GlavnaView {

	protected Shell shell;
	private Kontroler kontroler = new Kontroler();

	/*
	 * private UnosView unosView = new UnosView(shell, SWT.DIALOG_TRIM); private
	 * IspisView ispisView = new IspisView(shell, SWT.DIALOG_TRIM); private
	 * BrisanjeView brisanjeView = new BrisanjeView(shell, SWT.DIALOG_TRIM);
	 */

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GlavnaView window = new GlavnaView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(191, 232);
		shell.setText("Evidencija putovanja");

		Label labelNaslov = new Label(shell, SWT.NONE);
		labelNaslov.setAlignment(SWT.CENTER);
		labelNaslov.setFont(SWTResourceManager.getFont("Segoe UI Light", 15, SWT.NORMAL));
		labelNaslov.setBounds(21, 10, 126, 24);
		labelNaslov.setText("PUTOVANJA");

		Button UnosView = new Button(shell, SWT.NONE);
		UnosView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				UnosView unosView = new UnosView(shell, SWT.DIALOG_TRIM);
				unosView.setKontroler(kontroler);
				unosView.open();
			}
		});
		UnosView.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		UnosView.setBounds(10, 62, 75, 25);
		UnosView.setText("Unos");

		Button PrikazView = new Button(shell, SWT.NONE);
		PrikazView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				IspisView ispisView = new IspisView(shell, SWT.DIALOG_TRIM);
				ispisView.setKontroler(kontroler);
				ispisView.open();

			}
		});
		PrikazView.setBounds(91, 62, 75, 25);
		PrikazView.setText("Prikaz");

		Button BrisanjeView = new Button(shell, SWT.NONE);
		BrisanjeView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				BrisanjeView brisanjeView = new BrisanjeView(shell, SWT.DIALOG_TRIM);
				brisanjeView.setKontroler(kontroler);
				brisanjeView.open();
			}
		});
		BrisanjeView.setBounds(10, 93, 75, 25);
		BrisanjeView.setText("Brisanje");

		Button PretraziView = new Button(shell, SWT.NONE);
		PretraziView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				PretragaView pretraziView = new PretragaView(shell, SWT.DIALOG_TRIM);
				pretraziView.setKontroler(kontroler);
				pretraziView.open();
			}
		});
		PretraziView.setBounds(91, 93, 75, 25);
		PretraziView.setText("Pretra\u017Ei");

		Button SpremiUDatotekuView = new Button(shell, SWT.NONE);
		SpremiUDatotekuView.addSelectionListener(new SelectionAdapter() {

			@Override

			public void widgetSelected(SelectionEvent arg0) {

				MessageBox msgObavijest1 = new MessageBox(shell, SWT.OK);

				try {
					kontroler.spremiUDatoteku();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				msgObavijest1.setMessage("Putovanje spremljeno u Rezervacije.txt!");
				msgObavijest1.open();
			}
		});
		SpremiUDatotekuView.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		SpremiUDatotekuView.setBounds(10, 124, 156, 25);
		SpremiUDatotekuView.setText("Spremi u datoteku");

		Button UcitajIzDatotekeView = new Button(shell, SWT.NONE);
		UcitajIzDatotekeView.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					kontroler.citanjeIzDatoteke();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MessageBox msgObavijest1 = new MessageBox(shell, SWT.OK);
				msgObavijest1.setMessage("Putovanja su uèitana!");
				msgObavijest1.open();
			}
		});
		UcitajIzDatotekeView.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		UcitajIzDatotekeView.setBounds(10, 155, 156, 25);
		UcitajIzDatotekeView.setText("U\u010Ditaj iz datoteke");

	}
}
