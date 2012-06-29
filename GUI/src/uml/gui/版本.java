package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;


public class 版本 {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			版本 window = new 版本();
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
		shell.setImage(SWTResourceManager.getImage(版本.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(版本.class, "/pic/\u80CC\u666F1.jpg"));
		shell.setSize(450, 539);
		shell.setText("SWT Application");

		text = new Text(shell, SWT.READ_ONLY);
		text.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		text.setBounds(0, 0, 434, 501);
		text.setText("该系统为第一版！");
	}

}
