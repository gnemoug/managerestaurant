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

import uml.middleclass.WalkinBill;


public class Child_GUI4 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private int tableid;
	private String peoplenumber = "";
	private String feedback;
	
	public Child_GUI4(int tableid,String peoplenumber,String feedback){
		setTableid(tableid);
		setFeedback(feedback);
		setPeoplenumber(peoplenumber);
	}
	
	public Child_GUI4(){
		
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getPeoplenumber() {
		return peoplenumber;
	}
	public void setPeoplenumber(String peoplenumber) {
		this.peoplenumber = peoplenumber;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	/**
	 * 
	 * @return tableid
	 */
	public int getTableid() {
		return tableid;
	}
	/**
	 * 
	 * @param tableid
	 */
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	
	public Child_GUI4(int tableid){
		setTableid(tableid);
		setFeedback("");
		setPeoplenumber("");
	}
	public static void main(String[] args) {
		try {
			Child_GUI4 window = new Child_GUI4(28);
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
		shell.setImage(SWTResourceManager.getImage(Child_GUI4.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Child_GUI4.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(295, 246);
		shell.setText("开单");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setBounds(28, 22, 90, 25);
		lblNewLabel_2.setText("\u7528\u9910\u4EBA\u6570:");

		text_1 = new Text(shell, SWT.BORDER | SWT.MULTI);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(124, 52, 116, 77);		
		
		text = new Text(shell, SWT.BORDER);
		if(getPeoplenumber().equals("")){
			;
		}else{
			text_1.setText(getFeedback());
			text.setText(getPeoplenumber());
		}
		text.addVerifyListener(new VerifyListener() {
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
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(124, 23, 116, 23);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		btnNewButton.setBounds(28, 166, 80, 27);
		btnNewButton.setText("\u786E\u5B9A");

		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		button_2.setBounds(153, 166, 80, 27);
		button_2.setText("\u53D6\u6D88");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel.setBounds(61, 53, 49, 25);
		lblNewLabel.setText("\u5907\u6CE8\uFF1A");
		
		final Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.NORMAL));
		lblNewLabel_1.setBounds(124, 135, 90, 17);
		lblNewLabel_1.setText("用餐人数过多！");
		lblNewLabel_1.setVisible(false);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(Integer.parseInt(text.getText()) > uml.middleclass.Table.search(tableid).getTableGroup().getContain_number()){
					lblNewLabel_1.setVisible(true);
				}
				else{
					if (getPeoplenumber().equals("")) {
						if(text_1.getText() == null){
							WalkinBill walkinBill = new WalkinBill(uml.middleclass.Table.search(tableid), Integer.parseInt(text.getText()),"EATING");
							walkinBill.save();
						}else{
							System.out.println("shit!");
							String feedback = new String(text_1.getTextChars());
							WalkinBill walkinBill = new WalkinBill(uml.middleclass.Table.search(tableid), Integer.parseInt(text.getText()),feedback,"EATING");
							walkinBill.save();
							/**
							 * 
							 * 此处改成了用触发器实现
							 */
//							uml.middleclass.Table.update(tableid, "WALK_IN");
						}
					}else{
						if(text_1.getText().equals("")){
							String feedback = "";
							uml.middleclass.WalkinBill.update(getTableid(), Integer.parseInt(text.getText()), feedback);
						}else{
							String feedback = text_1.getText();
							uml.middleclass.WalkinBill.update(getTableid(), Integer.parseInt(text.getText()), feedback);
						}
					}
					shell.close();
				}
			}
		});
	}
}
