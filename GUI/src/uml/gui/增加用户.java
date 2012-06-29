package uml.gui;

import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import uml.middleclass.Administer;
import uml.middleclass.Receptionist;


public class 增加用户 {

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
			增加用户 window = new 增加用户();
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
		shell.setImage(SWTResourceManager.getImage(增加用户.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(增加用户.class, "/pic/\u80CC\u666F3-.jpg"));
		shell.setSize(421, 247);
		shell.setText("添加用户");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("华文行楷", 16, SWT.BOLD));
		label.setBounds(62, 100, 82, 23);
		label.setText("\u7528\u6237\u540D\uFF1A");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("华文行楷", 16, SWT.BOLD));
		label_1.setBounds(83, 140, 61, 23);
		label_1.setText("\u5BC6\u7801\uFF1A");
		
		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.BOLD));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(299, 143, 116, 17);
		lblNewLabel.setText("\u7528\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF01");
		lblNewLabel.setVisible(false);

		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("华文隶书", 16, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(157, 95, 141, 28);

		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(157, 135, 141, 28);

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Administer administer = new Administer(text.getText(),text_1.getText());
				if(administer.authentication()){
					List<Receptionist> receptionists = administer.showReceptionists();
					for(int i=0;i < receptionists.size();i++){
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[]{String.valueOf(i),receptionists.get(i).getName()});
					}
					shell.setSize(450,500);
				}else{
					lblNewLabel.setVisible(true);
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("华文行楷", 16, SWT.BOLD));
		button.setBounds(107, 180, 80, 27);
		button.setText("\u786E\u8BA4");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("华文行楷", 16, SWT.BOLD));
		button_1.setBounds(238, 180, 80, 27);
		button_1.setText("\u53D6\u6D88");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(增加用户.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(51, 233, 311, 160);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(100);
		tableColumn.setText("    \u7528\u6237\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(206);
		tableColumn_1.setText("\u7528\u6237\u540D");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setEnabled(false);
				用户信息 window = new 用户信息();
				window.open();
				shell.setEnabled(true);
				Administer administer = new Administer(text.getText(),text_1.getText());
				if(administer.authentication()){
					int count = table.getItemCount();
					for(int i = 0; i < count;i++){
						table.getItem(0).dispose();
					}
					List<Receptionist> receptionists = administer.showReceptionists();
					for(int i=0;i < receptionists.size();i++){
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[]{String.valueOf(i),receptionists.get(i).getName()});
					}
				}
			}
		});
		button_2.setFont(SWTResourceManager.getFont("华文行楷", 12, SWT.BOLD));
		button_2.setBounds(95, 413, 80, 27);
		button_2.setText("\u589E\u52A0\u7528\u6237");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Administer.deleteReceptionist(table.getSelection()[0].getText(1));
				table.getSelection()[0].dispose();
			}
		});
		button_3.setFont(SWTResourceManager.getFont("华文行楷", 13, SWT.BOLD));
		button_3.setBounds(238, 413, 80, 27);
		button_3.setText("\u5220\u9664\u7528\u6237");
		
		

	}
}
