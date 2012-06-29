package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import uml.middleclass.DishGroup;

public class 增加菜品类别 {

	protected Shell shell;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			增加菜品类别 window = new 增加菜品类别();
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
		shell.setImage(SWTResourceManager.getImage(增加菜品类别.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(增加菜品类别.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(267, 216);
		shell.setText("菜品类别");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_1.setBounds(40, 39, 80, 27);
		label_1.setText("\u7C7B\u522B\u540D\u79F0\uFF1A");

		final Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label.setBounds(135, 75, 116, 17);
		label.setText("\u8BE5\u7C7B\u522B\u5DF2\u7ECF\u5B58\u5728\uFF01");
		label.setVisible(false);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_1.setBounds(135, 36, 86, 23);

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(DishGroup.search(text_1.getText()) == null){
					DishGroup dishGroup = new DishGroup(text_1.getText());
					dishGroup.save();
					shell.close();
				}else{
					label.setVisible(true);
				}
			}
		});
		button.setBounds(40, 110, 80, 27);
		button.setText("\u786E\u8BA4");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(141, 110, 80, 27);
		button_1.setText("\u53D6\u6D88");
	}

}
