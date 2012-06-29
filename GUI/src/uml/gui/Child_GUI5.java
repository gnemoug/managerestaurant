package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Child_GUI5 {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Child_GUI5 window = new Child_GUI5();
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
		shell.setImage(SWTResourceManager.getImage(Child_GUI5.class, "/pic/zhuozi4.png"));
		shell.setSize(450, 268);
		shell.setText("Ìí¼Ó·ÑÓÃ");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Child_GUI5.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 444, 240);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(106, 34, 88, 25);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(252, 33, 77, 22);
		lblNewLabel_1.setText("\u8D39\u7528\u91D1\u989D\uFF1A");
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setBounds(23, 33, 77, 26);
		lblNewLabel.setText("\u8D39\u7528\u540D\u79F0\uFF1A");
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		text.setBounds(335, 34, 73, 23);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(23, 116, 77, 25);
		lblNewLabel_2.setText("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(102, 117, 306, 55);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		btnNewButton.setBounds(114, 193, 80, 27);
		btnNewButton.setText("\u786E\u5B9A");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(252, 193, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");
		
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Child_GUI6 window = new Child_GUI6();
				window.open();
			}
		});
		btnNewButton_2.setImage(SWTResourceManager.getImage(Child_GUI5.class, "/pic/add1.png"));
		btnNewButton_2.setBounds(200, 32, 39, 27);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		lblNewLabel_3.setBounds(252, 72, 156, 17);
		lblNewLabel_3.setText("\u8D39\u7528\u91D1\u989D\u65E0\u6548");
	
		}
}
