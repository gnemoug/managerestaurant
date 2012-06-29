package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import uml.middleclass.Staff;

public class ÐÞ¸ÄÃÜÂë {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ÐÞ¸ÄÃÜÂë window = new ÐÞ¸ÄÃÜÂë();
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
		shell.setImage(SWTResourceManager.getImage(ÐÞ¸ÄÃÜÂë.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(ÐÞ¸ÄÃÜÂë.class, "/pic/\u80CC\u666F3-.jpg"));
		shell.setSize(450, 321);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		label.setBounds(111, 108, 61, 17);
		label.setText("\u7528\u6237\u540D\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		label_1.setBounds(111, 141, 61, 17);
		label_1.setText("\u539F\u5BC6\u7801\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		label_2.setBounds(92, 173, 80, 17);
		label_2.setText("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		label_3.setBounds(92, 206, 80, 17);
		label_3.setText("\u91CD\u65B0\u8F93\u5165\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(178, 104, 118, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(178, 135, 118, 23);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(178, 167, 118, 23);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setBounds(178, 200, 118, 23);
		
		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(299, 138, 135, 17);
		lblNewLabel.setText("\u7528\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF01");
		lblNewLabel.setVisible(false);		
		final Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setBounds(299, 205, 142, 17);
		lblNewLabel_1.setText("\u60A8\u4E24\u6B21\u8F93\u5165\u7684\u79D8\u5BC6\u4E0D\u4E00\u81F4\uFF01");
		lblNewLabel_1.setVisible(false);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Staff staff = new Staff(text.getText(),text_1.getText());
				if(staff.authentication()){
					if (!text_2.getText().equals(text_3.getText())) {
						lblNewLabel_1.setVisible(true);
					}else{
						staff.changePassword(text_2.getText());
						shell.close();
					}
				}else{
					lblNewLabel.setVisible(true);
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		button.setBounds(224, 246, 80, 27);
		button.setText("\u786E\u8BA4");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("»ªÎÄÐÐ¿¬", 12, SWT.BOLD));
		button_1.setBounds(326, 246, 80, 27);
		button_1.setText("\u53D6\u6D88");
	}
}
