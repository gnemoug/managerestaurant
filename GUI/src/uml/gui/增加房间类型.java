package uml.gui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.TableGroup;

public class 增加房间类型 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			增加房间类型 window = new 增加房间类型();
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
		shell.setImage(SWTResourceManager.getImage(增加房间类型.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(增加房间类型.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(330, 241);
		shell.setText("增加房间类型");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label.setBounds(49, 24, 80, 22);
		label.setText("\u623F\u95F4\u7C7B\u578B\uFF1A");

		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text.setBounds(154, 23, 103, 23);

		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		lblNewLabel.setBounds(263, 52, 30, 22);
		lblNewLabel.setText("\u5143");		
		
		final Label label_3 = new Label(shell, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		label_3.setBounds(154, 110, 113, 17);
		label_3.setText("\u8BE5\u623F\u95F4\u7C7B\u578B\u5DF2\u5B58\u5728\uFF01");
		label_3.setVisible(false);		
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(TableGroup.search(text.getText()) != null){
					label_3.setVisible(true);
				}else{
					if(text.getText().equals("")||text_1.getText().equals("")||text_2.getText().equals("")){
						label_3.setVisible(false);
					}else{
						TableGroup tableGroup = new TableGroup(text.getText(),Integer.parseInt(text_2.getText()),Float.valueOf(text_1.getText()));
						tableGroup.save();
						shell.close();
					}
				}
			}
		});
		button.setBounds(49, 150, 80, 27);
		button.setText("\u786E\u5B9A");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(174, 150, 80, 27);
		button_1.setText("\u53D6\u6D88");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_1.setBounds(49, 52, 80, 22);
		label_1.setText("\u6700\u4F4E\u6D88\u8D39\uFF1A");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("[.\\d]"); 
				Matcher matcher = pattern.matcher(arg0.text);
				if (matcher.matches()){
					if(text_1.getText().indexOf('.') != -1&&arg0.text.equals(".")){
						arg0.doit = false;
					}else{
						arg0.doit = true;
					}
				}else if(arg0.text.length() > 0){
					arg0.doit = false;
				}else{
					arg0.doit = true;
				}
			}
		});
		text_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_1.setBounds(154, 52, 103, 23);

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_2.setBounds(49, 85, 80, 22);
		label_2.setText("\u5BB9\u7EB3\u4EBA\u6570\uFF1A");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("\\d"); 
				Matcher matcher = pattern.matcher(arg0.text);
				if (matcher.matches()){
					arg0.doit = true;
				}else if(arg0.text.length() > 0){
					arg0.doit = false;
				}else{
					arg0.doit = true;
				}
			}
		});
		text_2.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		text_2.setBounds(154, 81, 103, 23);		
	}
}
