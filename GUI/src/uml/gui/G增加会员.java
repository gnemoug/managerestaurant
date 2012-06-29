package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class G‘ˆº”ª·‘± {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			G‘ˆº”ª·‘± window = new G‘ˆº”ª·‘±();
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
		shell.setImage(SWTResourceManager.getImage(G‘ˆº”ª·‘±.class, "/pic/zhuozi4.png"));
		shell.setSize(417, 400);
		shell.setText("ª·‘±–≈œ¢");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(G‘ˆº”ª·‘±.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 407, 373);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(158, 10, 75, 23);
		lblNewLabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 13, SWT.BOLD));
		lblNewLabel.setText("\u4F1A\u5458\u4FE1\u606F");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 46, 61, 23);
		lblNewLabel_1.setText("\u4F1A\u5458\u59D3\u540D\uFF1A");
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(77, 45, 88, 23);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(32, 92, 39, 17);
		lblNewLabel_2.setText("\u6027\u522B\uFF1A");
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(77, 91, 88, 25);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_3.setBounds(10, 145, 61, 17);
		lblNewLabel_3.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(77, 138, 88, 24);
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_4.setBounds(10, 206, 61, 17);
		lblNewLabel_4.setText("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(77, 206, 88, 23);
		
		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_5.setBounds(210, 46, 61, 17);
		lblNewLabel_5.setText("\u4F1A\u5458\u7B49\u7EA7\uFF1A");
		
		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_1.setBounds(287, 45, 88, 25);
		
		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_6.setBounds(210, 91, 61, 17);
		lblNewLabel_6.setText("\u5F53\u524D\u79EF\u5206\uFF1A");
		
		Label lblNewLabel_7 = new Label(composite, SWT.NONE);
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_7.setBounds(287, 91, 88, 25);
		
		Label lblNewLabel_8 = new Label(composite, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_8.setBounds(210, 145, 61, 17);
		lblNewLabel_8.setText("\u5F53\u524D\u72B6\u6001\uFF1A");
		
		Combo combo_2 = new Combo(composite, SWT.NONE);
		combo_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_2.setBounds(287, 145, 88, 25);
		
		Label lblNewLabel_9 = new Label(composite, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_9.setBounds(196, 206, 75, 17);
		lblNewLabel_9.setText("\u8BBE\u7F6E\u5361\u5BC6\u7801\uFF1A");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(287, 205, 87, 23);
		
		Label lblNewLabel_10 = new Label(composite, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_10.setBounds(194, 257, 77, 17);
		lblNewLabel_10.setText("\u786E\u8BA4\u5361\u5BC6\u7801\uFF1A");
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setBounds(287, 251, 88, 23);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		btnNewButton.setBounds(85, 306, 80, 27);
		btnNewButton.setText("\u4FDD\u5B58");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(226, 306, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");

	}
}
