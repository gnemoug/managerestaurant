package uml.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import java.lang.Thread;

import uml.middleclass.Book;
import uml.middleclass.Staff;

public class 登录 {

	protected Shell shell;
	private Text text_2;
	private Text text_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			threadd thread1 = new threadd();
//			thread1.start();
			登录 window = new 登录();
			window.open();
//			thread1.stop();
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
		shell.setImage(SWTResourceManager.getImage(登录.class,
				"/pic/\u7BA1\u7406\u5458_32.ico"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(登录.class,
				"/pic/\u767B\u5F551.jpg"));
		shell.setSize(479, 337);
		shell.setText("登录");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("华文行楷", 17, SWT.BOLD));
		label.setBounds(156, 136, 88, 25);
		label.setText("\u7528\u6237\u540D\uFF1A");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("华文行楷", 17, SWT.BOLD));
		label_1.setBounds(179, 169, 65, 25);
		label_1.setText("\u5BC6\u7801\uFF1A");

		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(245, 170, 127, 23);

		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setVisible(false);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.BOLD));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(244, 199, 127, 17);
		lblNewLabel
				.setText("\u7528\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF01");

		Button button = new Button(shell, SWT.FLAT | SWT.CENTER);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Staff staff = new Staff(text_1.getText(), text_2.getText());
				if (staff.authentication()) {
					shell.close();
					GUI window = new GUI();
					window.open();
				} else {
					lblNewLabel.setVisible(true);
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("华文行楷", 14, SWT.BOLD));
		button.setBounds(168, 225, 80, 27);
		button.setText("\u767B\u5F55");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("华文行楷", 14, SWT.BOLD));
		button_1.setBounds(292, 225, 80, 27);
		button_1.setText("\u53D6\u6D88");

		Link link = new Link(shell, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setEnabled(false);
				增加用户 window = new 增加用户();
				window.open();
				shell.setEnabled(true);
			}
		});
		link.setBounds(378, 145, 65, 17);
		link.setText("<a>\u7BA1\u7406\u5458\u5165\u53E3</a>");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(245, 138, 127, 23);

		Link link_1 = new Link(shell, SWT.NONE);
		link_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setEnabled(false);
				修改密码 window = new 修改密码();
				window.open();
				shell.setEnabled(true);
			}
		});
		link_1.setBounds(378, 177, 53, 17);
		link_1.setText("<a>\u4FEE\u6539\u5BC6\u7801</a>");

	}
}

class threadd extends Thread {
	private int i;

	public threadd() {

	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(5 * 1000);
				Book.updatetablestate();
			} catch (Exception e) {

			}
		}
	}
}
