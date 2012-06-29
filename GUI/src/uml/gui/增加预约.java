package uml.gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.Book;
import uml.middleclass.Dish;
import uml.middleclass.DishGroup;
import uml.middleclass.TableGroup;

public class Ôö¼ÓÔ¤Ô¼ {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_3;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Text text_2;
	private int pbookbillid = 0;
	private Book book;
	
	
	public Ôö¼ÓÔ¤Ô¼(int pbookbillid){
		setPbookbillid(pbookbillid);
		setBook(Book.getBook(pbookbillid));
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}
	
	
	public int getPbookbillid() {
		return pbookbillid;
	}
	
	public void setPbookbillid(int pbookbillid) {
		this.pbookbillid = pbookbillid;
	}
	
	public Ôö¼ÓÔ¤Ô¼(){
		
	}
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ôö¼ÓÔ¤Ô¼ window = new Ôö¼ÓÔ¤Ô¼();
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
		shell.setImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F0.jpg"));
		shell.setSize(731, 564);
		shell.setText("Ôö¼ÓÔ¤Ô¼");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label.setAlignment(SWT.RIGHT);
		label.setBounds(27, 26, 61, 23);
		label.setText("\u59D3\u540D\uFF1A");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_1.setAlignment(SWT.CENTER);
		label_1.setBounds(8, 96, 80, 23);
		label_1.setText("\u9884\u8BA2\u65F6\u95F4\uFF1A");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_2.setAlignment(SWT.RIGHT);
		label_2.setBounds(32, 164, 56, 23);
		label_2.setText("\u7559\u8A00\uFF1A");

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_3.setAlignment(SWT.RIGHT);
		label_3.setBounds(0, 63, 88, 27);
		label_3.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");

		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text.setBounds(94, 23, 113, 23);
		if(getPbookbillid() != 0){
			text.setText(getBook().getName());
		}
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_1.setBounds(94, 64, 113, 23);
		if(getPbookbillid() != 0){
			text_1.setText(getBook().getCellphone());
		}
		text_1.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("[-\\d]"); 
				Matcher matcher = pattern.matcher(arg0.text);
				if (matcher.matches()){
					if(text_1.getText().indexOf('-') != -1&&arg0.text.equals("-")){
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
		
		
		final DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		dateTime.setBounds(94, 96, 98, 24);
		if(getPbookbillid() != 0){
			dateTime.setMonth(getBook().getBookTime().getMonth());
			SimpleDateFormat f_day = new SimpleDateFormat("dd"); 
			int day1 = Integer.parseInt(f_day.format(getBook().getBookTime()).toString());
			dateTime.setDay(day1);
		}
		
		text_3 = new Text(shell, SWT.BORDER | SWT.MULTI);
		text_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setBounds(95, 163, 155, 76);
		if(getPbookbillid() != 0){
			text_3.setText(getBook().getFeedback());
		}
		
		
		final Tree tree = new Tree(shell, SWT.BORDER);
		tree.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F1.jpg"));
		tree.setBounds(278, 10, 180, 213);
		
		List<TableGroup> tablegroups_1 = TableGroup.getTablegroups();
		for (int i = 0; i < tablegroups_1.size(); i++) {
			TreeItem treeItem_n = new TreeItem(tree, 0);
			treeItem_n.setText(tablegroups_1.get(i).getCategory());
			treeItem_n.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
			List< uml.middleclass.Table> tables = tablegroups_1.get(i).getTables();
			for(int j=0;j < tables.size();j++){
				if(tables.get(j).getState().equals("EMPTY")){
					TreeItem treeItem_m = new TreeItem(treeItem_n, SWT.NONE);
					treeItem_m.setText(String.valueOf(tables.get(j).getTableid()));
					treeItem_m.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10,
							SWT.NORMAL));						
				}			
			}
		}
		
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem[] treeItems = tree.getSelection();
				if (treeItems.length != 0
						&& treeItems[0].getParentItem() != null) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String[] {
							treeItems[0].getParentItem().getText(),
							treeItems[0].getText() });
					treeItems[0].dispose();
				}
			}
		});
		button.setImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u7BAD\u59342.png"));
		button.setBounds(464, 75, 56, 27);

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				TableItem[] tableItems = table.getSelection();
				TreeItem[] treeItems = tree.getItems();
				
				for(int i = 0; i < treeItems.length;i++){
					if (tableItems.length != 0
							&& treeItems[i].getText().equals(tableItems[0].getText())) {
						TreeItem tempTreeItem = new TreeItem(treeItems[i], 0);
						tempTreeItem.setText(tableItems[0].getText(1));
						tempTreeItem.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10,
								SWT.NORMAL));
						tableItems[0].dispose();
						break;
					}
				}
			}
		});
		button_1.setImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u7BAD\u59341.png"));
		button_1.setBounds(464, 130, 56, 27);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F1.jpg"));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(526, 10, 180, 213);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(76);
		tableColumn.setText("    \u623F\u95F4");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u9910\u684C\u53F7");

		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(196, 94, 80, 27);

		
		String []contents_1 = new String[4];
		contents_1[0] = "Ôç²Í";
		contents_1[1] = "Îç²Í";
		contents_1[2] = "Íí²Í";
		contents_1[3] = "Ò¹Ïü";
		combo.setItems(contents_1);
		combo.select(0);
		if(getPbookbillid() != 0){
			if(getBook().getBookingPeriod().equals("BREAKFAST")){
				combo.select(0);
			}else if (getBook().getBookingPeriod().equals("LUNCH")) {
				combo.select(1);
			}else if (getBook().getBookingPeriod().equals("DINNER")) {
				combo.select(2);
			}else {
				combo.select(3);
			}
		}
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(getPbookbillid() == 0){
					List<uml.middleclass.Table> tables = new ArrayList<uml.middleclass.Table>();
					 
					int count = table.getItemCount();
					for (int i = 0; i < count; i++) {
						tables.add(uml.middleclass.Table.search(Integer.valueOf(table.getItem(i).getText(1))));
					}
					int a = dateTime.getYear();
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					Date date = new Date(a - 1900,b - 1,c);
					int bookid;
					if(combo.getText().equals("Ôç²Í")){
						Book book = new Book(text_1.getText(), text.getText(), date, "BREAKFAST", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						bookid = book.save();
					}else if (combo.getText().equals("Îç²Í")) {
						Book book = new Book(text_1.getText(), text.getText(), date, "LUNCH", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						bookid = book.save();
					}else if (combo.getText().equals("Íí²Í")) {
						Book book = new Book(text_1.getText(), text.getText(), date, "DINNER", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						bookid = book.save();
					}else {
						Book book = new Book(text_1.getText(), text.getText(), date, "SUPER", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						bookid = book.save();
					}
					
					for (int i = 0; i < tables.size(); i++) {
						int counts = table_2.getItemCount();
						for (int j = 0; j < counts; j++) {
							uml.middleclass.Table.addDishs(tables.get(i).getTableid(), table_2
									.getItem(j).getText(0), Integer.parseInt(table_2
									.getItem(j).getText(2)), "description",
									bookid, 0);
						}
					}
					shell.close();
				}else{
					List<uml.middleclass.Table> tables = new ArrayList<uml.middleclass.Table>();
					 
					int count = table.getItemCount();
					for (int i = 0; i < count; i++) {
						tables.add(uml.middleclass.Table.search(Integer.valueOf(table.getItem(i).getText(1))));
					}
					int a = dateTime.getYear();
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					Date date = new Date(a - 1900,b - 1,c);
					int bookid;
					if(combo.getText().equals("Ôç²Í")){
						Book book = new Book(text_1.getText(), text.getText(), date, "BREAKFAST", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						uml.middleclass.Book.update(getPbookbillid(), book);
					}else if (combo.getText().equals("Îç²Í")) {
						Book book = new Book(text_1.getText(), text.getText(), date, "LUNCH", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						uml.middleclass.Book.update(getPbookbillid(), book);
					}else if (combo.getText().equals("Íí²Í")) {
						Book book = new Book(text_1.getText(), text.getText(), date, "DINNER", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						uml.middleclass.Book.update(getPbookbillid(), book);
					}else {
						Book book = new Book(text_1.getText(), text.getText(), date, "SUPER", "NOTARRIVAL",tables);
						if(text_2.getText().equals("")){
							;
						}else{
							book.setProDeposit(Float.valueOf(text_2.getText()));
						}
						if(text_3.getText().equals("")){
							;
						}else {
							book.setFeedback(text_3.getText());
						}
						uml.middleclass.Book.update(getPbookbillid(), book);
					}
					for (int i = 0; i < tables.size(); i++) {
						int counts = table_2.getItemCount();
						for (int j = 0; j < counts; j++) {
							uml.middleclass.Table.addDishs(tables.get(i).getTableid(), table_2
									.getItem(j).getText(0), Integer.parseInt(table_2
									.getItem(j).getText(2)), "description",
									getPbookbillid(), 0);
						}
					}
					shell.close();
				}

			}
		});
		btnNewButton.setText("\u786E\u5B9A");
		btnNewButton.setBounds(446, 496, 80, 27);

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(573, 496, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");

		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.BOLD));
		tabFolder.setBounds(8, 267, 333, 236);

		final TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("\u83DC\u5355");

		table_1 = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F1.jpg"));
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		tabItem_1.setControl(table_1);

		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_3.setWidth(87);
		tableColumn_3.setText("\u540D\u79F0");

		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_2.setWidth(62);
		tableColumn_2.setText("\u7C7B\u522B");

		TableColumn tableColumn_7 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_7.setWidth(44);
		tableColumn_7.setText("\u7B80\u62FC");

		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_5.setWidth(46);
		tableColumn_5.setText("\u4EF7\u683C");

		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_4.setWidth(38);
		tableColumn_4.setText("\u5355\u4F4D");

		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_6.setWidth(43);
		tableColumn_6.setText("\u5E93\u5B58");

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("\u5206\u7C7B\u83DC\u5355");

		final Tree tree_1 = new Tree(tabFolder, SWT.BORDER);
		tree_1.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F1.jpg"));
		tabItem.setControl(tree_1);

		List<DishGroup> dishGroups = DishGroup.getAllDishGroups();
		List<Dish> dishs1 = Dish.getAllDishs();

		for (int i = 0; i < dishGroups.size(); i++) {
			TreeItem treeItem_n = new TreeItem(tree_1, 0);
			treeItem_n.setText(dishGroups.get(i).getCategory());
			treeItem_n
					.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
			for (int j = 0; j < dishs1.size(); j++) {
				if (dishs1.get(j).getDishGroup().getCategory()
						.equals(dishGroups.get(i).getCategory())) {
					TreeItem treeItem_m = new TreeItem(treeItem_n, SWT.NONE);
					treeItem_m.setText(dishs1.get(j).getName());
					treeItem_m.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10,
							SWT.NORMAL));
				}
			}
		}

		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem[] tabItems = tabFolder.getSelection();
				if (tabItems[0] == tabItem) {
					TreeItem[] treeItems = tree_1.getSelection();
					if (treeItems.length != 0 && treeItems[0].getParentItem() != null) {
						int i = 0;
						int count = table_2.getItemCount();
						for (i = 0; i < count; i++) {
							if (table_2.getItem(i).getText(0).equals(treeItems[0].getText())) {
								table_2.getItem(i).setText(2,String.valueOf(Integer.parseInt(table_2.getItem(i).getText(2)) + 1));
								for (int j = 0; j < table_1.getItemCount(); j++) {
									if(table_1.getItem(j).getText(0).equals(treeItems[0].getText())){
										table_1.getItem(j).setText(5, String.valueOf(Integer.parseInt(table_1.getItem(j).getText(5)) - 1));
									}
								}
								break;
							}
						}
						if (i == count) {
							for (int j = 0; j < table_1.getItemCount(); j++) {
								if(table_1.getItem(j).getText(0).equals(treeItems[0].getText())){
									table_1.getItem(j).setText(5, String.valueOf(Integer.parseInt(table_1.getItem(j).getText(5)) - 1));
									TableItem tableItem = new TableItem(table_2,SWT.NONE);
									tableItem.setText(new String[] {table_1.getItem(j).getText(0),table_1.getItem(j).getText(3), "1" });
								}
							}
						}
					}
				} else if (tabItems[0] == tabItem_1) {
					TableItem[] tableItems = table_1.getSelection();
					// System.out.println(tableItems[0].getText(5));
					tableItems[0].setText(5, String.valueOf(Integer
							.parseInt(tableItems[0].getText(5)) - 1));
					if (tableItems.length != 0) {
						int i = 0;
						int count = table_2.getItemCount();
						for (i = 0; i < count; i++) {
							if (table_2.getItem(i).getText(0).equals(tableItems[0].getText(0))) {
								table_2.getItem(i).setText(2,String.valueOf(Integer.parseInt(table_2.getItem(i).getText(2)) + 1));
								break;
							}
						}

						if (i == count) {
							TableItem tableItem = new TableItem(table_2,
									SWT.NONE);
							tableItem.setText(new String[] {
									tableItems[0].getText(0),
									tableItems[0].getText(3), "1" });
						}
					}
				}
			}
		});
		button_2.setImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u7BAD\u59342.png"));
		button_2.setBounds(347, 387, 42, 27);

		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBackgroundImage(SWTResourceManager.getImage(Ôö¼ÓÔ¤Ô¼.class,
				"/pic/\u80CC\u666F1.jpg"));
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(395, 287, 300, 203);

		TableColumn tableColumn_9 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_9.setWidth(142);
		tableColumn_9.setText("            \u540D\u79F0");

		TableColumn tableColumn_10 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_10.setWidth(77);
		tableColumn_10.setText("\u4EF7\u683C");

		TableColumn tableColumn_11 = new TableColumn(table_2, SWT.CENTER);
		tableColumn_11.setWidth(75);
		tableColumn_11.setText("\u6570\u91CF");

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_2.getSelectionCount() != 0){
					TableItem[] tableItems = table_2.getSelection();
					if (tableItems.length != 0) {
						int count = table_1.getItemCount();
						for (int i = 0; i < count; i++) {
							if (table_1.getItem(i).getText(0).equals(tableItems[0].getText())) {
								table_1.getItem(i).setText(5,String.valueOf(Integer.parseInt(tableItems[0].getText(2)) + Integer.parseInt(table_1.getItem(i).getText(5))));
								tableItems[0].dispose();
								break;
							}
						}
					}
				}
			}
		});
		button_3.setText("\u5220\u83DC");
		button_3.setBounds(446, 254, 80, 27);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_4.setBounds(40, 125, 48, 23);
		label_4.setText("\u62BC\u91D1\uFF1A");

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setBounds(94, 126, 73, 23);
		if(getPbookbillid() != 0){
			text_2.setText(String.valueOf(getBook().getProDeposit()));
		}
		text_2.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("[.\\d]"); 
				Matcher matcher = pattern.matcher(arg0.text);
				if (matcher.matches()){
					if(text_2.getText().indexOf('.') != -1&&arg0.text.equals(".")){
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
		
		List<Dish> dishs = Dish.getAllDishs();
		for (int i = 0; i < dishs.size(); i++) {
			TableItem tableItem2 = new TableItem(table_1, SWT.NONE);
			tableItem2.setText(new String[] { dishs.get(i).getName(),
					dishs.get(i).getDishGroup().getCategory(),
					dishs.get(i).getJinpin(),
					String.valueOf(dishs.get(i).getUnitPrice()),
					dishs.get(i).getUnitgroup(),
					String.valueOf(dishs.get(i).getCurrentInventory()) });
		}
	}
}
