package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;


public class Gª·‘±Ω·’À {

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
			Gª·‘±Ω·’À window = new Gª·‘±Ω·’À();
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
		shell = new Shell();
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		shell.setBackgroundImage(SWTResourceManager.getImage(Gª·‘±Ω·’À.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(576, 521);
		shell.setText("\u4F1A\u5458\u7ED3\u8D26");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel.setBounds(22, 20, 96, 27);
		lblNewLabel.setText("\u7ED3\u8D26\u5355\u53F7\uFF1A");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(124, 18, 129, 27);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_2.setBounds(326, 20, 96, 27);
		lblNewLabel_2.setText("\u6D88\u8D39\u91D1\u989D\uFF1A");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBounds(428, 22, 106, 25);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_4.setBounds(22, 78, 96, 27);
		lblNewLabel_4.setText("\u4F1A\u5458\u540D\u79F0\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(124, 78, 129, 23);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_5.setBounds(326, 78, 95, 27);
		lblNewLabel_5.setText("\u4F1A\u5458\u5BC6\u7801\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 9, SWT.NORMAL));
		text_1.setBounds(428, 83, 106, 23);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_6.setBounds(22, 131, 96, 27);
		lblNewLabel_6.setText("\u4F1A\u5458\u7B49\u7EA7\uFF1A");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_7.setBounds(124, 131, 129, 25);
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_8.setBounds(326, 131, 95, 27);
		lblNewLabel_8.setText("\u6298\u6263\u7387\uFF1A");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(428, 131, 106, 25);
		
		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_9.setBounds(101, 193, 129, 27);
		lblNewLabel_9.setText("\u987E\u5BA2\u6D88\u8D39\u6E05\u5355");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(Gª·‘±Ω·’À.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(10, 229, 305, 217);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("      \u540D\u79F0");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("\u4EF7\u683C");
		
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(100);
		tableColumn.setText("\u6570\u91CF");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(337, 419, 80, 27);
		btnNewButton.setText("\u7ED3\u8D26");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(454, 421, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");
		
		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		lblNewLabel_10.setBounds(340, 386, 96, 27);
		lblNewLabel_10.setText("\u5E94\u6536\u91D1\u989D\uFF1A");
		
		Label lblNewLabel_11 = new Label(shell, SWT.NONE);
		lblNewLabel_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_11.setBounds(442, 386, 96, 23);

	}
}
