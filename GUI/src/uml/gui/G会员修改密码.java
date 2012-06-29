package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Gª·‘±–ﬁ∏ƒ√‹¬Î {

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
			Gª·‘±–ﬁ∏ƒ√‹¬Î window = new Gª·‘±–ﬁ∏ƒ√‹¬Î();
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
		shell.setImage(SWTResourceManager.getImage(Gª·‘±–ﬁ∏ƒ√‹¬Î.class, "/pic/zhuozi4.png"));
		shell.setSize(317, 300);
		shell.setText("ª·‘±–ﬁ∏ƒ√‹¬Î");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Gª·‘±–ﬁ∏ƒ√‹¬Î.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 311, 272);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel.setBounds(51, 21, 61, 19);
		lblNewLabel.setText("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(118, 20, 93, 23);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(51, 68, 61, 17);
		lblNewLabel_1.setText("\u65E7\u5BC6\u7801\uFF1A");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_2.setBounds(51, 107, 61, 17);
		lblNewLabel_2.setText("\u65B0\u5BC6\u7801\uFF1A");
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		lblNewLabel_3.setBounds(34, 150, 78, 17);
		lblNewLabel_3.setText("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(118, 68, 93, 23);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(118, 106, 93, 23);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setBounds(118, 149, 93, 23);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		btnNewButton.setBounds(68, 210, 80, 27);
		btnNewButton.setText("\u786E\u5B9A");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(165, 210, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");

	}
}
