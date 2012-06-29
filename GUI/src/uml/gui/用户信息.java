package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import uml.middleclass.Administer;
import uml.middleclass.Receptionist;

public class 用户信息 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Button button;
	private Button button_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			用户信息 window = new 用户信息();
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
		shell.setImage(SWTResourceManager.getImage(用户信息.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(用户信息.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(405, 208);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("华文行楷", 13, SWT.BOLD));
		label.setBounds(74, 32, 61, 17);
		label.setText("\u7528\u6237\u540D\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("华文行楷", 13, SWT.BOLD));
		label_1.setBounds(86, 77, 61, 17);
		label_1.setText("\u5BC6\u7801\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(162, 29, 129, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(162, 74, 129, 23);
		
		button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (Administer.addReceptionist(new Receptionist(text.getText(), text_1.getText()))) {
					shell.close();
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("华文行楷", 13, SWT.BOLD));
		button.setBounds(83, 129, 80, 27);
		button.setText("\u786E\u8BA4");
		
		button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("华文行楷", 13, SWT.BOLD));
		button_1.setBounds(221, 129, 80, 27);
		button_1.setText("\u53D6\u6D88");

	}

}
