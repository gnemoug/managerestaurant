package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;


public class 添加收入类型 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			添加收入类型 window = new 添加收入类型();
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
		shell.setImage(SWTResourceManager.getImage(添加收入类型.class, "/pic/zhuozi4.png"));
		shell.setSize(742, 262);
		shell.setText("收入类型");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(添加收入类型.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 732, 236);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 32, 80, 25);
		lblNewLabel.setText("\u6536\u5165\u7C7B\u578B\uFF1A");
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(96, 33, 100, 23);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		lblNewLabel_1.setBounds(175, 34, 159, 17);
		lblNewLabel_1.setText("\u6536\u5165\u7C7B\u578B\u4E0D\u80FD\u4E3A\u7A7A");
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 80, 80, 25);
		lblNewLabel_2.setText("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER | SWT.MULTI);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		text_1.setBounds(96, 81, 173, 80);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(添加收入类型.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(375, 32, 357, 148);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(177);
		tblclmnNewColumn.setText("        \u6536\u5165\u7C7B\u578B\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(176);
		tblclmnNewColumn_1.setText("\u5907\u6CE8\u4FE1\u606F");
		
		Button button = new Button(composite, SWT.NONE);
		button.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					table.getSelection()[0].dispose();
				}
			}
		});
		button.setBounds(642, 199, 80, 27);
		button.setText("\u5220\u9664");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[]{text.getText(),text_1.getText()});
			}
		});
		btnNewButton.setOrientation(SWT.RIGHT_TO_LEFT);
		btnNewButton.setImage(SWTResourceManager.getImage(添加收入类型.class, "/pic/\u7BAD\u59342.png"));
		btnNewButton.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		btnNewButton.setBounds(285, 93, 80, 27);
		btnNewButton.setText("\u589E\u52A0");

	}

}
