package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;


public class Child_GUI6 {

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
			Child_GUI6 window = new Child_GUI6();
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
		shell.setImage(SWTResourceManager.getImage(Child_GUI6.class, "/pic/zhuozi4.png"));
		shell.setSize(736, 290);
		shell.setText("·ÑÓÃÀàÐÍ");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Child_GUI6.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 730, 262);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setBounds(10, 26, 74, 25);
		lblNewLabel.setText("\u8D39\u7528\u7C7B\u578B\uFF1A");
		
		text = new Text(composite, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(86, 27, 112, 23);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 72, 74, 25);
		lblNewLabel_1.setText("\u5907\u6CE8\u4FE1\u606F\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER | SWT.MULTI);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(86, 73, 165, 79);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(Child_GUI6.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(385, 26, 345, 193);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(174);
		tblclmnNewColumn.setText("            \u8D39\u7528\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setText("\u5907\u6CE8\u4FE1\u606F");
		tblclmnNewColumn_1.setWidth(165);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_2.setBounds(204, 28, 112, 23);
		lblNewLabel_2.setText("\u8D39\u7528\u7C7B\u578B\u4E0D\u80FD\u4E3A\u7A7A");
		
		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[]{text.getText(),text_1.getText()});
			}
		});
		button.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		button.setOrientation(SWT.RIGHT_TO_LEFT);
		button.setImage(SWTResourceManager.getImage(Child_GUI6.class, "/pic/\u7BAD\u59342.png"));
		button.setBounds(275, 96, 80, 27);
		button.setText("\u6DFB\u52A0");
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					table.getSelection()[0].dispose();
				}
			}
		});
		button_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		button_1.setBounds(620, 225, 80, 27);
		button_1.setText("\u5220\u9664");

	}
}
