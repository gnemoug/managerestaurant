package uml.gui;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.Dish;
import uml.middleclass.DishGroup;
import uml.middleclass.TableGroup;
import uml.middleclass.Waiter;
import uml.middleclass.WaiterGroup;

public class Child_GUI3 {

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Text text;
	private Table table_2;
	private Table table_3;
	private Table table_4;
	private Table table_5;
	private Table table_6;
	private Table table_7;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Child_GUI3 window = new Child_GUI3();
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
		shell.setImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/zhuozi4.png"));
		shell.setSize(745, 553);
		shell.setText("系统设置");

		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setBackgroundMode(SWT.INHERIT_FORCE);
		tabFolder.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F0.jpg"));
		tabFolder.setBounds(0, 0, 737, 525);

		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("\u623F\u95F4\u53CA\u9910\u684C\u8BBE\u7F6E");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F0.jpg"));
		tabItem.setControl(composite);

		table = new Table(composite, SWT.BORDER);
		table.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(10, 52, 304, 196);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(100);
		tableColumn.setText("     \u623F\u95F4\u7C7B\u578B");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u6700\u4F4E\u6D88\u8D39");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5BB9\u7EB3\u4EBA\u6570");

		List<TableGroup> tablegroups = TableGroup.getTablegroups();
		for(int i=0;i<tablegroups.size();i++){
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String[]{tablegroups.get(i).getCategory(),String.valueOf(tablegroups.get(i).getLowest_consumption()),String.valueOf(tablegroups.get(i).getContain_number())});
		}
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(361, 91, 80, 27);
		button.setText("\u589E\u52A0\u623F\u95F4\u7C7B\u578B");

		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setBounds(361, 144, 80, 27);
		button_1.setText("\u4FEE\u6539\u623F\u95F4\u7C7B\u578B");

		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setBounds(361, 195, 80, 27);
		button_2.setText("\u5220\u9664\u623F\u95F4\u7C7B\u578B");

		Label label = new Label(composite, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label.setBounds(10, 275, 80, 27);
		label.setText("\u623F\u95F4\u7C7B\u578B\uFF1A");

		final Combo combo = new Combo(composite, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count = table_1.getItemCount();
				for(int i = 0; i < count;i++){
					table_1.getItem(0).dispose();
				}
				List<TableGroup> tablegroups_1 = TableGroup.getTablegroups();
				for (int i = 0; i < tablegroups_1.size(); i++) {
					if(tablegroups_1.get(i).getCategory().equals(combo.getText())){
						List< uml.middleclass.Table> tables = tablegroups_1.get(i).getTables();
						for(int j=0;j < tables.size();j++){
							String tablestate;
							if(tables.get(j).getState().equals("EMPTY")){
								tablestate = "空闲";
							}else if(tables.get(j).getState().equals("WALK_IN")){
								tablestate = "开单";
							}else{
								tablestate = "预订";
							}
							TableItem tableItem = new TableItem(table_1, SWT.NONE);
							tableItem.setText(new String[]{String.valueOf(tables.get(j).getTableid()),String.valueOf(tablegroups_1.get(i).getContain_number()),tablestate,combo.getText()});				
						}
					}
				}
			}
		});
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(103, 275, 88, 25);
		String []content = new String[tablegroups.size()];
		for(int i=0;i<tablegroups.size();i++){
			content[i] = tablegroups.get(i).getCategory();
		}
		combo.setItems(content);
		combo.select(0);
		
		table_1 = new Table(composite, SWT.BORDER);
		table_1.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_1.setBounds(10, 308, 405, 177);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("     \u9910\u684C\u53F7");

		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u53EF\u5750\u4EBA\u6570");

		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("\u9910\u684C\u72B6\u6001");

		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.NONE);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("\u6240\u5728\u533A\u57DF");
		
		for (int i = 0; i < tablegroups.size(); i++) {
			if(tablegroups.get(i).getCategory().equals(combo.getText())){
				List< uml.middleclass.Table> tables = tablegroups.get(i).getTables();
				for(int j=0;j < tables.size();j++){
					TableItem tableItem = new TableItem(table_1, SWT.NONE);
					String tablestate;
					if(tables.get(j).getState().equals("EMPTY")){
						tablestate = "空闲";
					}else if(tables.get(j).getState().equals("WALK_IN")){
						tablestate = "开单";
					}else{
						tablestate = "预订";
					}
					tableItem.setText(new String[]{String.valueOf(tables.get(j).getTableid()),String.valueOf(tablegroups.get(i).getContain_number()),tablestate,combo.getText()});				
				}
			}
		}

		Button button_3 = new Button(composite, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				增加桌子 window = new 增加桌子();
				window.open();
				int count = table_1.getItemCount();
				for(int i = 0; i < count;i++){
					table_1.getItem(0).dispose();
				}
				List<TableGroup> tablegroups_1 = TableGroup.getTablegroups();
				for (int i = 0; i < tablegroups_1.size(); i++) {
					if(tablegroups_1.get(i).getCategory().equals(combo.getText())){
						List< uml.middleclass.Table> tables = tablegroups_1.get(i).getTables();
						for(int j=0;j < tables.size();j++){
							String tablestate;
							if(tables.get(j).getState().equals("EMPTY")){
								tablestate = "空闲";
							}else if(tables.get(j).getState().equals("WALK_IN")){
								tablestate = "开单";
							}else{
								tablestate = "预订";
							}
							TableItem tableItem = new TableItem(table_1, SWT.NONE);
							tableItem.setText(new String[]{String.valueOf(tables.get(j).getTableid()),String.valueOf(tablegroups_1.get(i).getContain_number()),tablestate,combo.getText()});				
						}
					}
				}
			}
		});
		button_3.setBounds(446, 444, 80, 27);
		button_3.setText("\u589E\u52A0\u9910\u684C");

		Button button_4 = new Button(composite, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_1.getSelectionCount() != 0){
					uml.middleclass.Table.deleteTable(Integer.parseInt(table_1.getSelection()[0].getText(0)));
					table_1.getSelection()[0].dispose();
				}				
			}
		});
		button_4.setBounds(545, 444, 80, 27);
		button_4.setText("\u5220\u9664\u9910\u684C");

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_4.setBounds(10, 22, 112, 27);
		label_4.setText("\u623F\u95F4\u7C7B\u578B\u8BBE\u7F6E\uFF1A");

		TabItem tbtmNewItem_2 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_2.setText("\u83DC\u5355\u8BBE\u7F6E");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_2.setControl(composite_1);

		final Combo combo_1 = new Combo(composite_1, SWT.NONE);
		combo_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count = table_2.getItemCount();
				for(int i = 0; i < count;i++){
					table_2.getItem(0).dispose();
				}
				List<Dish> dishs = Dish.getAllDishs();
				for (int i = 0; i < dishs.size(); i++) {
					if(dishs.get(i).getDishGroup().getCategory().equals(combo_1.getText())){
						TableItem tableItem = new TableItem(table_2, SWT.NONE);
						tableItem.setText(new String[]{dishs.get(i).getName(),dishs.get(i).getDishGroup().getCategory(),dishs.get(i).getJinpin(),String.valueOf(dishs.get(i).getUnitPrice()),dishs.get(i).getUnitgroup(),String.valueOf(dishs.get(i).getCurrentInventory())});				
					}
				}
			}
		});
		combo_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_1.setBounds(84, 197, 88, 25);
		List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
		String []contents_1 = new String[dishgroups_1.size()];
		for(int i=0;i<dishgroups_1.size();i++){
			contents_1[i] = dishgroups_1.get(i).getCategory();
		}
		combo_1.setItems(contents_1);
		combo_1.select(0);
		
		text = new Text(composite_1, SWT.BORDER);
		text.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("[a-z]"); 
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
		text.setBounds(354, 197, 96, 23);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int count = table_2.getItemCount();
				for(int i = 0; i < count;i++){
					table_2.getItem(0).dispose();
				}
				List<Dish> dishs = Dish.getAllDishs();
				for (int j = 0; j < dishs.size(); j++) {
					if(dishs.get(j).getJinpin().startsWith(text.getText())&&dishs.get(j).getDishGroup().getCategory().equals(combo_1.getText())){
						TableItem tableItem = new TableItem(table_2, SWT.NONE);
						tableItem.setText(new String[]{dishs.get(j).getName(),dishs.get(j).getDishGroup().getCategory(),dishs.get(j).getJinpin(),String.valueOf(dishs.get(j).getUnitPrice()),dishs.get(j).getUnitgroup(),String.valueOf(dishs.get(j).getCurrentInventory())});	
					}
				}
			}
		});
		
		Label label_1 = new Label(composite_1, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_1.setBounds(29, 196, 63, 22);
		label_1.setText("\u7C7B\u522B\uFF1A");

		Label label_2 = new Label(composite_1, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_2.setBounds(236, 196, 112, 22);
		label_2.setText("\u67E5\u627E\uFF08\u7B80\u62FC\uFF09\uFF1A");

		table_2 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_2.setBounds(10, 234, 580, 251);
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tableColumn_10 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_10.setWidth(100);
		tableColumn_10.setText("\u540D\u79F0");

		TableColumn tableColumn_11 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_11.setWidth(100);
		tableColumn_11.setText("\u7C7B\u522B");
		
		TableColumn tableColumn_9 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("\u7B80\u62FC");

		TableColumn tableColumn_12 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_12.setWidth(84);
		tableColumn_12.setText("\u552E\u4EF7");

		TableColumn tableColumn_13 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_13.setWidth(100);
		tableColumn_13.setText("\u5355\u4F4D");

		TableColumn tableColumn_14 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_14.setWidth(91);
		tableColumn_14.setText("\u5E93\u5B58");
		
		table_3 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_3.setBounds(10, 38, 253, 135);
		table_3.setHeaderVisible(true);
		table_3.setLinesVisible(true);

		TableColumn tableColumn_7 = new TableColumn(table_3, SWT.CENTER);
		tableColumn_7.setWidth(122);
		tableColumn_7.setText("       \u7C7B\u522B\u7F16\u53F7");

		TableColumn tableColumn_8 = new TableColumn(table_3, SWT.CENTER);
		tableColumn_8.setWidth(125);
		tableColumn_8.setText("\u7C7B\u522B\u540D\u79F0");

		Button button_5 = new Button(composite_1, SWT.NONE);
		button_5.setBounds(347, 64, 80, 27);
		button_5.setText("\u589E\u52A0\u7C7B\u522B");

		Button button_6 = new Button(composite_1, SWT.NONE);
		button_6.setBounds(347, 105, 80, 27);
		button_6.setText("\u4FEE\u6539\u7C7B\u522B");

		Button button_7 = new Button(composite_1, SWT.NONE);
		button_7.setBounds(347, 146, 80, 27);
		button_7.setText("\u5220\u9664\u7C7B\u522B");

		Label label_3 = new Label(composite_1, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		label_3.setBounds(10, 10, 96, 22);
		label_3.setText("\u83DC\u54C1\u7C7B\u522B\u8BBE\u7F6E");

		Button button_8 = new Button(composite_1, SWT.NONE);
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				增加菜 window = new 增加菜();
				window.open();
				int count = table_2.getItemCount();
				for(int i = 0; i < count;i++){
					table_2.getItem(0).dispose();
				}
				List<Dish> dishs = Dish.getAllDishs();
				for (int i = 0; i < dishs.size(); i++) {
					if(dishs.get(i).getDishGroup().getCategory().equals(combo_1.getText())){
						TableItem tableItem = new TableItem(table_2, SWT.NONE);
						tableItem.setText(new String[]{dishs.get(i).getName(),dishs.get(i).getDishGroup().getCategory(),dishs.get(i).getJinpin(),String.valueOf(dishs.get(i).getUnitPrice()),dishs.get(i).getUnitgroup(),String.valueOf(dishs.get(i).getCurrentInventory())});				
					}
				}
			}
		});
		button_8.setBounds(628, 385, 80, 27);
		button_8.setText("\u589E\u52A0\u83DC");

		Button button_9 = new Button(composite_1, SWT.NONE);
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_2.getSelectionCount() != 0){
					修改菜 window = new 修改菜(table_2.getSelection()[0].getText(1),table_2.getSelection()[0].getText(0),table_2.getSelection()[0].getText(3),table_2.getSelection()[0].getText(2),table_2.getSelection()[0].getText(5),table_2.getSelection()[0].getText(4));
					window.open();
					int count = table_2.getItemCount();
					for(int i = 0; i < count;i++){
						table_2.getItem(0).dispose();
					}
					List<Dish> dishs = Dish.getAllDishs();
					for (int i = 0; i < dishs.size(); i++) {
						if(dishs.get(i).getDishGroup().getCategory().equals(combo_1.getText())){
							TableItem tableItem = new TableItem(table_2, SWT.NONE);
							tableItem.setText(new String[]{dishs.get(i).getName(),dishs.get(i).getDishGroup().getCategory(),dishs.get(i).getJinpin(),String.valueOf(dishs.get(i).getUnitPrice()),dishs.get(i).getUnitgroup(),String.valueOf(dishs.get(i).getCurrentInventory())});				
						}
					}
				}				
			}
		});
		button_9.setBounds(628, 418, 80, 27);
		button_9.setText("\u4FEE\u6539\u83DC");

		Button button_10 = new Button(composite_1, SWT.NONE);
		button_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_2.getSelectionCount() != 0){
					Dish.delete(table_2.getSelection()[0].getText(0));
					table_2.getSelection()[0].dispose();	
				}				
			}
		});
		button_10.setBounds(628, 451, 80, 27);
		button_10.setText("\u5220\u9664\u83DC");
		
		List<DishGroup> dishgroups = uml.middleclass.DishGroup.getAllDishGroups();
		for(int i=0;i < dishgroups.size();i++){
			TableItem tableItem = new TableItem(table_3, SWT.NONE);
			tableItem.setText(new String[]{String.valueOf(i),dishgroups.get(i).getCategory()});				
		}
		List<Dish> dishs = Dish.getAllDishs();
		for (int i = 0; i < dishs.size(); i++) {
			if(dishs.get(i).getDishGroup().getCategory().equals(combo_1.getText())){
				TableItem tableItem = new TableItem(table_2, SWT.NONE);
				tableItem.setText(new String[]{dishs.get(i).getName(),dishs.get(i).getDishGroup().getCategory(),dishs.get(i).getJinpin(),String.valueOf(dishs.get(i).getUnitPrice()),dishs.get(i).getUnitgroup(),String.valueOf(dishs.get(i).getCurrentInventory())});				
			}
		}
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				增加房间类型 window = new 增加房间类型();
				window.open();
				int count = table.getItemCount();
				for(int i = 0; i < count;i++){
					table.getItem(0).dispose();
				}
				List<TableGroup> tablegroups = TableGroup.getTablegroups();
				for(int i=0;i < tablegroups.size();i++){
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String[]{tablegroups.get(i).getCategory(),String.valueOf(tablegroups.get(i).getLowest_consumption()),String.valueOf(tablegroups.get(i).getContain_number())});
				}
				String []content = new String[tablegroups.size()];
				for(int i=0;i<tablegroups.size();i++){
					content[i] = tablegroups.get(i).getCategory();
				}
				combo.setItems(content);
				combo.select(0);
			}
		});
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					修改房间类型 window = new 修改房间类型(table.getSelection()[0].getText(0),table.getSelection()[0].getText(1),table.getSelection()[0].getText(2));
					window.open();
					int count = table.getItemCount();
					for(int i = 0; i < count;i++){
						table.getItem(0).dispose();
					}
					List<TableGroup> tablegroups = TableGroup.getTablegroups();
					for(int i=0;i < tablegroups.size();i++){
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String[]{tablegroups.get(i).getCategory(),String.valueOf(tablegroups.get(i).getLowest_consumption()),String.valueOf(tablegroups.get(i).getContain_number())});				
					}
					String []content = new String[tablegroups.size()];
					for(int i=0;i<tablegroups.size();i++){
						content[i] = tablegroups.get(i).getCategory();
					}
					combo.setItems(content);
					combo.select(0);
				}			
			}
		});
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					TableGroup.deleteTableGroup(table.getSelection()[0].getText(0));
					table.getSelection()[0].dispose();
					List<TableGroup> tablegroups = TableGroup.getTablegroups();
					String []content = new String[tablegroups.size()];
					for(int i=0;i<tablegroups.size();i++){
						content[i] = tablegroups.get(i).getCategory();
					}
					combo.setItems(content);
					combo.select(0);
				}				
			}
		});
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				增加菜品类别 window = new 增加菜品类别();
				window.open();
				int count = table_3.getItemCount();
				for(int i = 0; i < count;i++){
					table_3.getItem(0).dispose();
				}
				List<DishGroup> dishgroups = uml.middleclass.DishGroup.getAllDishGroups();
				for(int i=0;i < dishgroups.size();i++){
					TableItem tableItem = new TableItem(table_3, SWT.NONE);
					tableItem.setText(new String[]{String.valueOf(i),dishgroups.get(i).getCategory()});				
				}
				List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
				String []contents_1 = new String[dishgroups_1.size()];
				for(int i=0;i<dishgroups_1.size();i++){
					contents_1[i] = dishgroups_1.get(i).getCategory();
				}
				combo_1.setItems(contents_1);
				combo_1.select(0);
			}
		});
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_3.getSelectionCount() != 0){
					修改菜品类别  window = new 修改菜品类别(table_3.getSelection()[0].getText(1));
					window.open();
					int count = table_3.getItemCount();
					for(int i = 0; i < count;i++){
						table_3.getItem(0).dispose();
					}
					List<DishGroup> dishgroups = uml.middleclass.DishGroup.getAllDishGroups();
					for(int i=0;i < dishgroups.size();i++){
						TableItem tableItem = new TableItem(table_3, SWT.NONE);
						tableItem.setText(new String[]{String.valueOf(i),dishgroups.get(i).getCategory()});				
					}
					List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
					String []contents_1 = new String[dishgroups_1.size()];
					for(int i=0;i<dishgroups_1.size();i++){
						contents_1[i] = dishgroups_1.get(i).getCategory();
					}
					combo_1.setItems(contents_1);
					combo_1.select(0);
				}
			}
		});
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_3.getSelectionCount() != 0){
					uml.middleclass.DishGroup.delete(table_3.getSelection()[0].getText(1));
					table_3.getSelection()[0].dispose();
					List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
					String []contents_1 = new String[dishgroups_1.size()];
					for(int i=0;i<dishgroups_1.size();i++){
						contents_1[i] = dishgroups_1.get(i).getCategory();
					}
					combo_1.setItems(contents_1);
					combo_1.select(0);
				}				
			}
		});
	
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("\u4F1A\u5458\u8BBE\u7F6E");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite_2);
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel.setBounds(25, 32, 104, 22);
		lblNewLabel.setText("\u4F1A\u5458\u7C7B\u578B\u8BBE\u7F6E");
		
		table_4 = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_4.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_4.setBounds(25, 60, 297, 154);
		table_4.setHeaderVisible(true);
		table_4.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table_4, SWT.NONE);
		tblclmnNewColumn.setWidth(91);
		tblclmnNewColumn.setText("    \u4F1A\u5458\u7C7B\u578B");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table_4, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(98);
		tblclmnNewColumn_1.setText("\u6700\u4F4E\u79EF\u5206");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table_4, SWT.CENTER);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("\u6298\u6263\u7387");
		
		Button btnNewButton = new Button(composite_2, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G会员等级  window = new G会员等级();
				window.open();
			}
		});
		btnNewButton.setBounds(359, 60, 80, 27);
		btnNewButton.setText("\u589E\u52A0\u4F1A\u5458\u7C7B\u578B");
		
		Button btnNewButton_1 = new Button(composite_2, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G会员等级  window = new G会员等级();
				window.open();
			}
		});
		btnNewButton_1.setBounds(359, 126, 80, 27);
		btnNewButton_1.setText("\u4FEE\u6539\u4F1A\u5458\u7C7B\u578B");
		
		Button btnNewButton_2 = new Button(composite_2, SWT.NONE);
		btnNewButton_2.setBounds(359, 193, 80, 27);
		btnNewButton_2.setText("\u5220\u9664\u4F1A\u5458\u7C7B\u578B");
		
		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 247, 41, 27);
		lblNewLabel_1.setText("\u7C7B\u578B");
		
		Combo combo_2 = new Combo(composite_2, SWT.NONE);
		combo_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_2.setBounds(57, 247, 88, 25);
		
		table_5 = new Table(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_5.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_5.setBounds(10, 290, 406, 195);
		table_5.setHeaderVisible(true);
		table_5.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table_5, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("      \u4F1A\u5458\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table_5, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("    \u4F1A\u5458\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table_5, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("\u6027\u522B");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table_5, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("\u8054\u7CFB\u65B9\u5F0F");
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("\u670D\u52A1\u751F\u8BBE\u7F6E");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(composite_3);
		
		Label lblNewLabel_2 = new Label(composite_3, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(10, 10, 140, 31);
		lblNewLabel_2.setText("\u670D\u52A1\u751F\u7C7B\u578B\u8BBE\u7F6E");
		
		table_6 = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_6.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_6.setBounds(20, 50, 292, 167);
		table_6.setHeaderVisible(true);
		table_6.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table_6, SWT.CENTER);
		tblclmnNewColumn_7.setWidth(138);
		tblclmnNewColumn_7.setText("      \u7B49\u7EA7\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table_6, SWT.CENTER);
		tblclmnNewColumn_8.setWidth(147);
		tblclmnNewColumn_8.setText("\u670D\u52A1\u751F\u7B49\u7EA7");
		
		List<WaiterGroup> waiterGroups = WaiterGroup.getAllWaiterGroups(); 
		for(int i=0;i<waiterGroups.size();i++){
			TableItem tableItem = new TableItem(table_6, SWT.NONE);
			tableItem.setText(new String[]{String.valueOf(waiterGroups.get(i).getWaitergroupid()),waiterGroups.get(i).getCategory()});
		}
		
		Button btnNewButton_3 = new Button(composite_3, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G添加服务生等级 window = new G添加服务生等级();
				window.open();
				int count = table_6.getItemCount();
				for(int i = 0; i < count;i++){
					table_6.getItem(0).dispose();
				}
				List<WaiterGroup> waiterGroups = WaiterGroup.getAllWaiterGroups(); 
				for(int i=0;i<waiterGroups.size();i++){
					TableItem tableItem = new TableItem(table_6, SWT.NONE);
					tableItem.setText(new String[]{String.valueOf(waiterGroups.get(i).getWaitergroupid()),waiterGroups.get(i).getCategory()});
				}
			}
		});
		btnNewButton_3.setBounds(367, 54, 80, 27);
		btnNewButton_3.setText("\u6DFB\u52A0\u670D\u52A1\u7B49\u7EA7");
		
		Button btnNewButton_4 = new Button(composite_3, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_6.getSelectionCount() != 0){
					G添加服务生等级 window = new G添加服务生等级(Integer.parseInt(table_6.getSelection()[0].getText(0)),table_6.getSelection()[0].getText(1));
					window.open();

					int count = table_6.getItemCount();
					for(int i = 0; i < count;i++){
						table_6.getItem(0).dispose();
					}
					List<WaiterGroup> waiterGroups = WaiterGroup.getAllWaiterGroups(); 
					for(int i=0;i<waiterGroups.size();i++){
						TableItem tableItem = new TableItem(table_6, SWT.NONE);
						tableItem.setText(new String[]{String.valueOf(waiterGroups.get(i).getWaitergroupid()),waiterGroups.get(i).getCategory()});
					}
				}
			}
		});
		btnNewButton_4.setBounds(367, 114, 80, 27);
		btnNewButton_4.setText("\u4FEE\u6539\u670D\u52A1\u7B49\u7EA7");
		
		Button btnNewButton_5 = new Button(composite_3, SWT.NONE);
		btnNewButton_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_6.getSelectionCount() != 0){
					WaiterGroup.delete(Integer.parseInt(table_6.getSelection()[0].getText(0)));
					table_6.getSelection()[0].dispose();
					int count = table_6.getItemCount();
					for(int i = 0; i < count;i++){
						table_6.getItem(0).dispose();
					}
					List<WaiterGroup> waiterGroups = WaiterGroup.getAllWaiterGroups(); 
					for(int i=0;i<waiterGroups.size();i++){
						TableItem tableItem = new TableItem(table_6, SWT.NONE);
						tableItem.setText(new String[]{String.valueOf(waiterGroups.get(i).getWaitergroupid()),waiterGroups.get(i).getCategory()});
					}
				}
			}
		});
		btnNewButton_5.setBounds(367, 172, 80, 27);
		btnNewButton_5.setText("\u5220\u9664\u670D\u52A1\u7B49\u7EA7");
		
		Label lblNewLabel_3 = new Label(composite_3, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(10, 241, 61, 27);
		lblNewLabel_3.setText("\u7C7B\u578B");
		
		final Combo combo_3 = new Combo(composite_3, SWT.NONE);
		combo_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count = table_7.getItemCount();
				for(int i = 0; i < count;i++){
					table_7.getItem(0).dispose();
				}
				List<Waiter> waiters = Waiter.getAllWaiters(); 	
				for(int i=0;i<waiters.size();i++){
					if (waiters.get(i).getWaitergroup().getCategory().equals(combo_3.getText())) {
						TableItem tableItem = new TableItem(table_7, SWT.NONE);
						if (waiters.get(i).getSex().equals("MEN")) {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"男",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}else {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"女",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}
					}
				}
			}
		});
		combo_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo_3.setBounds(77, 242, 97, 25);
		
		String []contents = new String[waiterGroups.size()];
		for(int i=0;i<waiterGroups.size();i++){
			contents[i] = waiterGroups.get(i).getCategory();
		}
		combo_3.setItems(contents);
		combo_3.select(0);
		
		table_7 = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_7.setBackgroundImage(SWTResourceManager.getImage(Child_GUI3.class, "/pic/\u80CC\u666F1.jpg"));
		table_7.setBounds(20, 274, 613, 211);
		table_7.setHeaderVisible(true);
		table_7.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table_7, SWT.NONE);
		tblclmnNewColumn_9.setWidth(41);
		tblclmnNewColumn_9.setText("\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_10 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_10.setWidth(60);
		tblclmnNewColumn_10.setText("\u59D3\u540D");
				
		TableColumn tblclmnNewColumn_12 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_12.setWidth(40);
		tblclmnNewColumn_12.setText("\u6027\u522B");
		
		TableColumn tblclmnNewColumn_13 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_13.setText("\u670D\u52A1\u751F\u7EA7\u522B");
		tblclmnNewColumn_13.setWidth(80);
		
		TableColumn tblclmnNewColumn_14 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_14.setWidth(99);
		tblclmnNewColumn_14.setText("\u8054\u7CFB\u65B9\u5F0F");
		
		TableColumn tblclmnNewColumn_15 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_15.setWidth(157);
		tblclmnNewColumn_15.setText("\u8EAB\u4EFD\u8BC1\u53F7\u7801");
		
		TableColumn tblclmnNewColumn_16 = new TableColumn(table_7, SWT.CENTER);
		tblclmnNewColumn_16.setWidth(160);
		tblclmnNewColumn_16.setText("\u8BA1\u85AA\u65E5\u671F");
		
		List<Waiter> waiters = Waiter.getAllWaiters(); 	
		for(int i=0;i<waiters.size();i++){
			TableItem tableItem = new TableItem(table_7, SWT.NONE);
			if (waiters.get(i).getSex().equals("MEN")) {
				tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"男",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
			}else {
				tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"女",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
			}
		}
		
		Button btnNewButton_6 = new Button(composite_3, SWT.NONE);
		btnNewButton_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G添加服务生 window = new G添加服务生();
				window.open();
				int count = table_7.getItemCount();
				for(int i = 0; i < count;i++){
					table_7.getItem(0).dispose();
				}
				List<Waiter> waiters = Waiter.getAllWaiters(); 	
				for(int i=0;i<waiters.size();i++){
					TableItem tableItem = new TableItem(table_7, SWT.NONE);
					if (waiters.get(i).getSex().equals("MEN")) {
						tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"男",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
					}else {
						tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"女",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
					}
				}
			}
		});
		btnNewButton_6.setBounds(639, 302, 80, 27);
		btnNewButton_6.setText("\u6DFB\u52A0\u670D\u52A1\u751F");
		
		Button btnNewButton_7 = new Button(composite_3, SWT.NONE);
		btnNewButton_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_7.getSelectionCount() != 0){
					G添加服务生 window = new G添加服务生(Integer.parseInt(table_7.getSelection()[0].getText(0)),WaiterGroup.getWaiterGroup(table_7.getSelection()[0].getText(3)),table_7.getSelection()[0].getText(1),table_7.getSelection()[0].getText(2),table_7.getSelection()[0].getText(4),table_7.getSelection()[0].getText(5),new Date(Integer.parseInt(table_7.getSelection()[0].getText(6).substring(0, 4)), Integer.parseInt(table_7.getSelection()[0].getText(6).substring(5, 7)), Integer.parseInt(table_7.getSelection()[0].getText(6).substring(8, 10))));
					window.open();
					int count = table_7.getItemCount();
					for(int i = 0; i < count;i++){
						table_7.getItem(0).dispose();
					}
					List<Waiter> waiters = Waiter.getAllWaiters(); 	
					for(int i=0;i<waiters.size();i++){
						TableItem tableItem = new TableItem(table_7, SWT.NONE);
						if (waiters.get(i).getSex().equals("MEN")) {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"男",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}else {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"女",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}
					}
				}
			}
		});
		btnNewButton_7.setBounds(639, 358, 80, 27);
		btnNewButton_7.setText("\u4FEE\u6539\u670D\u52A1\u751F");
		
		Button btnNewButton_8 = new Button(composite_3, SWT.NONE);
		btnNewButton_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_7.getSelectionCount() != 0){
					Waiter.delete(Integer.parseInt(table_7.getSelection()[0].getText(0)));
					table_7.getSelection()[0].dispose();
					int count = table_7.getItemCount();
					for(int i = 0; i < count;i++){
						table_7.getItem(0).dispose();
					}
					List<Waiter> waiters = Waiter.getAllWaiters(); 	
					for(int i=0;i<waiters.size();i++){
						TableItem tableItem = new TableItem(table_7, SWT.NONE);
						if (waiters.get(i).getSex().equals("MEN")) {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"男",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}else {
							tableItem.setText(new String[]{String.valueOf(waiters.get(i).getWaiterid()),waiters.get(i).getName(),"女",waiters.get(i).getWaitergroup().getCategory(),waiters.get(i).getCellphone(),waiters.get(i).getCid(),waiters.get(i).getSalarydate().toString()});
						}
					}
				}
			}
		});
		btnNewButton_8.setBounds(639, 412, 80, 27);
		btnNewButton_8.setText("\u5220\u9664\u670D\u52A1\u751F");
	
	}
}
