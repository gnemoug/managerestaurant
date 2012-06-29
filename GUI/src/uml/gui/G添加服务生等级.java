package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import uml.middleclass.WaiterGroup;


public class G添加服务生等级 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private int waitergroupid = 0;
	private String category;
	
	public G添加服务生等级(int waitergroupid,String category){
		setCategory(category);
		setWaitergroupid(waitergroupid);
	}
	
	public G添加服务生等级(){
		
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getWaitergroupid() {
		return waitergroupid;
	}
	public void setWaitergroupid(int waitergroupid) {
		this.waitergroupid = waitergroupid;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			G添加服务生等级 window = new G添加服务生等级();
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
		shell.setImage(SWTResourceManager.getImage(G添加服务生等级.class, "/pic/zhuozi4.png"));
		shell.setSize(336, 212);
		shell.setText("服务生等级");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(G添加服务生等级.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 330, 184);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel.setBounds(67, 10, 75, 27);
		lblNewLabel.setText("\u7B49\u7EA7\u7F16\u53F7\uFF1A");
		
		final Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_3.setBounds(148, 92, 124, 17);
		lblNewLabel_3.setText("\u8BE5\u670D\u52A1\u751F\u7B49\u7EA7\u5DF2\u5B58\u5728\uFF01");
		lblNewLabel_3.setVisible(false);
		

		
		if (getWaitergroupid() != 0) {
			text = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
			text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text.setBounds(148, 11, 112, 23);
		}else{
			text = new Text(composite, SWT.BORDER);
			text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text.setBounds(148, 11, 112, 23);
		}
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(52, 62, 90, 27);
		lblNewLabel_1.setText("\u670D\u52A1\u751F\u7B49\u7EA7\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(151, 63, 109, 23);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				uml.middleclass.WaiterGroup waiterGroup = new uml.middleclass.WaiterGroup(Integer.parseInt(text.getText()), text_1.getText());
				if (getWaitergroupid() != 0) {
					if(WaiterGroup.update(waiterGroup)){
						shell.close();
					}else{
						lblNewLabel_3.setVisible(true);
					}
				}else{
					if(waiterGroup.save()){
						shell.close();
					}else{
						lblNewLabel_3.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		btnNewButton.setBounds(62, 128, 80, 27);
		btnNewButton.setText("\u4FDD\u5B58");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(180, 128, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");
		if (getWaitergroupid() != 0) {
			text.setText(String.valueOf(getWaitergroupid()));
			text_1.setText(getCategory());
		}
	}
}
