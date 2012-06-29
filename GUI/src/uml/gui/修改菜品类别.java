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

public class 修改菜品类别 {

	protected Shell shell;
	private Text text_1;
	private String originalcategory;
	
	public 修改菜品类别(String originalcategory){
		setOriginalcategory(originalcategory);
	}
	/**
	 * 
	 * @return originalcategory
	 */
	public String getOriginalcategory() {
		return originalcategory;
	}
	/**
	 * 
	 * @param originalcategory
	 */
	public void setOriginalcategory(String originalcategory) {
		this.originalcategory = originalcategory;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			修改菜品类别 window = new 修改菜品类别("凉菜");
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
		shell.setImage(SWTResourceManager.getImage(修改菜品类别.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(修改菜品类别.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(267, 216);
		shell.setText("菜品类别");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_1.setBounds(40, 48, 80, 27);
		label_1.setText("\u7C7B\u522B\u540D\u79F0\uFF1A");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		text_1.setBounds(135, 45, 86, 23);

		text_1.setText(getOriginalcategory());
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DishGroup.update(getOriginalcategory(), text_1.getText());
				shell.close();
			}
		});
		button.setBounds(40, 117, 80, 27);
		button.setText("\u786E\u8BA4");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(141, 117, 80, 27);
		button_1.setText("\u53D6\u6D88");

	}

}
