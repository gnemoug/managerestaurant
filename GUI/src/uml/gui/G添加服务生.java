package uml.gui;

import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.handlers.WizardHandler.New;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.WaiterGroup;


public class GÌí¼Ó·þÎñÉú {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private int waiterid = 0;
	private WaiterGroup waitergroup;
	private String name;
	private String sex;
	private String cellphone;
	private String cid;
	private Date salarydate;
	
	public int getWaiterid() {
		return this.waiterid;
	}

	public void setWaiterid(int waiterid) {
		this.waiterid = waiterid;
	}

	public WaiterGroup getWaitergroup() {
		return this.waitergroup;
	}

	public void setWaitergroup(WaiterGroup waitergroup) {
		this.waitergroup = waitergroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Date getSalarydate() {
		return this.salarydate;
	}

	public void setSalarydate(Date salarydate) {
		this.salarydate = salarydate;
	}
	
	public GÌí¼Ó·þÎñÉú(int waiterid, WaiterGroup waitergroup, String name,
			String sex, String cellphone, String cid, Date salarydate){
		this.waiterid = waiterid;
		this.waitergroup = waitergroup;
		this.name = name;
		this.sex = sex;
		this.cellphone = cellphone;
		this.cid = cid;
		this.salarydate = salarydate;
	}
	
	public GÌí¼Ó·þÎñÉú(){
		
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GÌí¼Ó·þÎñÉú window = new GÌí¼Ó·þÎñÉú();
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
		shell.setImage(SWTResourceManager.getImage(GÌí¼Ó·þÎñÉú.class, "/pic/zhuozi4.png"));
		shell.setSize(430, 380);
		shell.setText("Ìí¼Ó·þÎñÉú");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(GÌí¼Ó·þÎñÉú.class, "/pic/\u80CC\u666F0.jpg"));
		composite.setBounds(0, 0, 421, 355);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.BOLD));
		lblNewLabel.setBounds(159, 10, 98, 37);
		lblNewLabel.setText("\u57FA\u672C\u60C5\u51B5");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(36, 52, 61, 23);
		lblNewLabel_1.setText("   \u7F16\u53F7\uFF1A");
		
		

		if (getWaiterid() != 0) {
			text = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
			text.setText(String.valueOf(getWaiterid()));
		}else{
			text = new Text(composite, SWT.BORDER);
		}
		
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(103, 53, 98, 23);
		
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(233, 53, 45, 23);
		lblNewLabel_2.setText("\u6027\u522B\uFF1A");
		
		final Combo combo = new Combo(composite, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(289, 52, 98, 25);
		
		String []content = new String[2];
		content[0] = "ÄÐ";
		content[1] = "Å®";
		combo.setItems(content);
		combo.select(0);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(52, 109, 45, 23);
		lblNewLabel_3.setText("\u59D3\u540D\uFF1A");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(103, 110, 98, 23);
		
		if (getWaiterid() != 0) {
			text_1.setText(getName());
		}
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_4.setBounds(205, 109, 80, 22);
		lblNewLabel_4.setText("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(289, 110, 98, 23);
		
		if (getWaiterid() != 0) {
			text_2.setText(getCellphone());
		}
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setBounds(103, 165, 175, 23);
		
		if (getWaiterid() != 0) {
			text_3.setText(getCid());
		}
		
		Label lblNewLabel_8 = new Label(composite, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.BOLD));
		lblNewLabel_8.setBounds(172, 194, 85, 22);
		lblNewLabel_8.setText("\u5C97\u4F4D\u63CF\u8FF0");
		
		Label lblNewLabel_9 = new Label(composite, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_9.setBounds(11, 244, 110, 24);
		lblNewLabel_9.setText("\u8BA1\u85AA\u5F00\u59CB\u65E5\u671F\uFF1A");
		
		final DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(127, 244, 88, 24);
		
		Label lblNewLabel_10 = new Label(composite, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel_10.setBounds(221, 244, 92, 24);
		lblNewLabel_10.setText("\u670D\u52A1\u751F\u7B49\u7EA7\uFF1A");
		
		final Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_1.setBounds(310, 245, 88, 25);
		
		List<WaiterGroup> waiterGroups = WaiterGroup.getAllWaiterGroups(); 
		String []contents = new String[waiterGroups.size()];
		for(int i=0;i<waiterGroups.size();i++){
			contents[i] = waiterGroups.get(i).getCategory();
		}
		combo_1.setItems(contents);
		combo_1.select(0);
		
		final Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		lblNewLabel_5.setBounds(221, 274, 131, 17);
		lblNewLabel_5.setText("\u8BE5\u670D\u52A1\u751F\u5DF2\u7ECF\u5B58\u5728\uFF01");
		lblNewLabel_5.setVisible(false);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (getWaiterid() == 0) {
					WaiterGroup waiterGroup = WaiterGroup.getWaiterGroup(combo_1.getText());
					int a = dateTime.getYear();
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					Date date = new Date(a - 1900,b - 1,c);
					if (combo.getText().equals("ÄÐ")) {
						uml.middleclass.Waiter waiter = new uml.middleclass.Waiter(Integer.parseInt(text.getText()),waiterGroup, text_1.getText(), "MEN", text_2.getText(), text_3.getText(), date);
						if(waiter.save()){
							shell.close();
						}else{
							lblNewLabel_5.setVisible(true);
						}
					}else{
						uml.middleclass.Waiter waiter = new uml.middleclass.Waiter(Integer.parseInt(text.getText()),waiterGroup, text_1.getText(), "WOMEN", text_2.getText(), text_3.getText(), date);
						if(waiter.save()){
							shell.close();
						}else{
							lblNewLabel_5.setVisible(true);
						}
					}
				}else{
					WaiterGroup waiterGroup = WaiterGroup.getWaiterGroup(combo_1.getText());
					int a = dateTime.getYear();
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					Date date = new Date(a - 1900,b - 1,c);
					if (combo.getText().equals("ÄÐ")) {
						uml.middleclass.Waiter waiter = new uml.middleclass.Waiter(Integer.parseInt(text.getText()),waiterGroup, text_1.getText(), "MEN", text_2.getText(), text_3.getText(), date);
						if(waiter.update(waiter)){
							shell.close();
						}else{
							lblNewLabel_5.setVisible(true);
						}
					}else{
						uml.middleclass.Waiter waiter = new uml.middleclass.Waiter(Integer.parseInt(text.getText()),waiterGroup, text_1.getText(), "WOMEN", text_2.getText(), text_3.getText(), date);
						if(waiter.update(waiter)){
							shell.close();
						}else{
							lblNewLabel_5.setVisible(true);
						}
					}
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		btnNewButton.setBounds(121, 301, 80, 27);
		btnNewButton.setText("\u4FDD\u5B58");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(246, 301, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label.setBounds(19, 164, 78, 22);
	}
}
