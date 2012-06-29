package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;


public class G会员管理 {

	protected Shell shell;
	private Text text;
	private Table table;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			G会员管理 window = new G会员管理();
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
		shell.setImage(SWTResourceManager.getImage(G会员管理.class, "/pic/zhuozi4.png"));
		shell.setSize(741, 535);
		shell.setText("会员管理");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(G会员管理.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(10, 10, 731, 477);
		
		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setBounds(0, 0, 721, 477);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("\u4F1A\u5458\u57FA\u672C\u4FE1\u606F\u7EF4\u62A4");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(G会员管理.class, "/pic/\u80CC\u666F0.jpg"));
		tbtmNewItem.setControl(composite_1);
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		lblNewLabel.setBounds(394, 10, 80, 25);
		lblNewLabel.setText("\u7F16\u53F7/\u59D3\u540D");
		
		final Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setBounds(545, 286, 73, 17);
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(479, 11, 73, 23);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(G会员管理.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(0, 41, 713, 193);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(83);
		tableColumn.setText("    \u4F1A\u5458\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(89);
		tblclmnNewColumn.setText("    \u4F1A\u5458\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(53);
		tblclmnNewColumn_1.setText("\u6027\u522B");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(71);
		tblclmnNewColumn_2.setText("\u4F1A\u5458\u7B49\u7EA7");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(59);
		tblclmnNewColumn_3.setText("\u6298\u6263\u7387");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(63);
		tblclmnNewColumn_4.setText("\u5F53\u524D\u79EF\u5206");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(75);
		tblclmnNewColumn_5.setText("\u751F\u65E5");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_6.setWidth(78);
		tblclmnNewColumn_6.setText("\u8054\u7CFB\u65B9\u5F0F");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_7.setWidth(64);
		tblclmnNewColumn_7.setText("\u767B\u8BB0\u65E5\u671F");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_8.setWidth(71);
		tblclmnNewColumn_8.setText("\u5F53\u524D\u72B6\u6001");
		
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					lblNewLabel_4.setText(table.getSelection()[0].getText());
				}
			}
		});
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(283, 10, 73, 25);
		lblNewLabel_1.setText("\u4F1A\u5458\u4FE1\u606F");
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(283, 282, 101, 25);
		lblNewLabel_2.setText("\u4F1A\u5458\u6D88\u8D39\u660E\u7EC6");
		
		table_1 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBackgroundImage(SWTResourceManager.getImage(G会员管理.class, "/pic/\u80CC\u666F1.jpg"));
		table_1.setBounds(0, 313, 713, 134);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_9.setWidth(94);
		tblclmnNewColumn_9.setText("     \u6D88\u8D39\u65E5\u671F");
		
		TableColumn tblclmnNewColumn_11 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_11.setWidth(92);
		tblclmnNewColumn_11.setText("\u4F1A\u5458\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_12 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_12.setWidth(97);
		tblclmnNewColumn_12.setText("\u8D26\u5355\u53F7");
		
		TableColumn tblclmnNewColumn_14 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_14.setWidth(100);
		tblclmnNewColumn_14.setText("\u5E94\u6536\u91D1\u989D");
		
		TableColumn tblclmnNewColumn_15 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_15.setWidth(100);
		tblclmnNewColumn_15.setText("\u5B9E\u6536\u91D1\u989D");
		
		TableColumn tblclmnNewColumn_16 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_16.setWidth(96);
		tblclmnNewColumn_16.setText("\u7ED3\u7B97\u72B6\u6001");
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table_1, SWT.CENTER);
		tblclmnNewColumn_10.setWidth(128);
		tblclmnNewColumn_10.setText("\u5907\u6CE8\u4FE1\u606F");
		
		Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		lblNewLabel_3.setBounds(480, 286, 61, 17);
		lblNewLabel_3.setText("\u4F1A\u5458\u59D3\u540D\uFF1A");
		
		Button button = new Button(composite_1, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G增加会员 window = new G增加会员();
				window.open();
			}
		});
		button.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button.setBounds(283, 237, 80, 27);
		button.setText("\u589E\u52A0\u4F1A\u5458");
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G增加会员 window = new G增加会员();
				window.open();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button_1.setBounds(394, 237, 90, 27);
		button_1.setText("\u4FEE\u6539\u4F1A\u5458\u4FE1\u606F");
		
		Button button_2 = new Button(composite_1, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					table.getSelection()[0].dispose();
				}
			}
		});
		button_2.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button_2.setBounds(516, 237, 80, 27);
		button_2.setText("\u5220\u9664\u4F1A\u5458");
		
		Button button_3 = new Button(composite_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G会员修改密码 window = new G会员修改密码();
				window.open();
			}
		});
		button_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button_3.setBounds(623, 237, 80, 27);
		button_3.setText("\u4FEE\u6539\u5BC6\u7801");
		
		

	}
}
