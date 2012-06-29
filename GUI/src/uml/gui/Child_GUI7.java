package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Child_GUI7 {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Child_GUI7 window = new Child_GUI7();
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
		shell = new Shell(SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(Child_GUI7.class, "/pic/zhuozi4.png"));
		shell.setSize(450, 300);
		shell.setText(" ’»Î");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		composite.setBackgroundImage(SWTResourceManager.getImage(Child_GUI7.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 444, 272);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		lblNewLabel.setBounds(22, 32, 80, 27);
		lblNewLabel.setText("\u6536\u5165\u540D\u79F0\uFF1A");
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(108, 34, 88, 25);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(Child_GUI7.class, "/pic/add1.png"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ÃÌº” ’»Î¿‡–Õ window = new ÃÌº” ’»Î¿‡–Õ();
				window.open();
			}
		});
		btnNewButton.setBounds(202, 32, 41, 27);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		lblNewLabel_1.setText("\u6536\u5165\u91D1\u989D\uFF1A");
		lblNewLabel_1.setBounds(249, 32, 80, 27);
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(335, 33, 86, 23);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_2.setBounds(310, 65, 124, 17);
		lblNewLabel_2.setText("\u6536\u5165\u91D1\u989D\u65E0\u6548");
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(22, 109, 80, 27);
		lblNewLabel_3.setText("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(108, 110, 313, 55);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
        @Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setBounds(116, 203, 80, 27);
		btnNewButton_1.setText("\u786E\u5B9A");
	
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_2.setBounds(262, 203, 80, 27);
		btnNewButton_2.setText("\u53D6\u6D88");

	}
}
