package uml.gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.Book;

public class Child_GUI2 {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Child_GUI2 window = new Child_GUI2();
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
		// List<String> allbooksList = uml.middleclass.Book.getbooks();
		// for (int i = 0; i < allbooksList.size(); i = i + 5) {
		// System.out.println(allbooksList.get(i));
		// System.out.println(allbooksList.get(i + 1));
		// System.out.println(allbooksList.get(i + 2));
		// System.out.println(allbooksList.get(i + 3));
		// System.out.println(allbooksList.get(i + 4));
		// }
		// uml.middleclass.Book.cancel(1);
		// uml.middleclass.Book.arrival(2);
		shell = new Shell(SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u80CC\u666F0.jpg"));
		shell.setSize(726, 487);
		shell.setText("Ô¤Ô¼");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setTouchEnabled(true);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(10, 92, 80, 24);
		lblNewLabel.setText("\u9009\u62E9\u65E5\u671F");

		final DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int count = table.getItemCount();
				for(int i = 0; i < count;i++){
					table.getItem(0).dispose();
				}
				int d = dateTime.getYear();
				int b = dateTime.getMonth() + 1;
				int c = dateTime.getDay();
				List<String> allbooksBooks = uml.middleclass.Book.getbooks();
				for (int i = 0; i < allbooksBooks.size(); i += 5) {
					Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
					SimpleDateFormat f_day=new SimpleDateFormat("dd"); 
					int day = Integer.parseInt(f_day.format(date).toString());
					if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
						TableItem tableItem2 = new TableItem(table, SWT.NONE);
						if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Ôç²Í",
									allbooksBooks.get(i + 4),});
						}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Îç²Í",
									allbooksBooks.get(i + 4),});
						}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Íí²Í",
									allbooksBooks.get(i + 4),});
						}else {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Ò¹Ïü",
									allbooksBooks.get(i + 4),});
						}
					}
				}
			}
		});
		dateTime.setBounds(96, 92, 88, 24);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u80CC\u666F1.jpg"));
		table.setToolTipText("");
		table.setBounds(10, 122, 705, 327);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(110);
		tableColumn_2.setText("     \u9884\u7EA6\u53F7");

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(120);
		tableColumn.setText("\u59D3\u540D");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(167);
		tableColumn_1.setText("\u8054\u7CFB\u7535\u8BDD");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(185);
		tblclmnNewColumn.setText("\u9884\u7EA6\u65F6\u95F4");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(117);
		tblclmnNewColumn_2.setText("\u9884\u7EA6\u9910\u684C\u53F7");

		ToolBar toolBar = new ToolBar(shell, SWT.FLAT);
		toolBar.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 9, SWT.BOLD));
		toolBar.setBounds(0, 0, 441, 74);

		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Ôö¼ÓÔ¤Ô¼ window = new Ôö¼ÓÔ¤Ô¼();
				window.open();
				int count = table.getItemCount();
				for(int i = 0; i < count;i++){
					table.getItem(0).dispose();
				}
				int b = dateTime.getMonth() + 1;
				int c = dateTime.getDay();
				int d = dateTime.getYear();
				List<String> allbooksBooks = uml.middleclass.Book.getbooks();
				for (int i = 0; i < allbooksBooks.size(); i += 5) {
					Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
					SimpleDateFormat f_day=new SimpleDateFormat("dd"); 
					int day = Integer.parseInt(f_day.format(date).toString());
					if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
						TableItem tableItem2 = new TableItem(table, SWT.NONE);
						if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Ôç²Í",
									allbooksBooks.get(i + 4),});
						}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Îç²Í",
									allbooksBooks.get(i + 4),});
						}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Íí²Í",
									allbooksBooks.get(i + 4),});
						}else {
							tableItem2.setText(new String[] { allbooksBooks.get(i),
									allbooksBooks.get(i + 1),
									allbooksBooks.get(i + 2),
									"Ò¹Ïü",
									allbooksBooks.get(i + 4),});
						}
					}
				}
			}
		});
		toolItem.setImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u589E\u52A0\u9884\u7EA6.png"));
		toolItem.setText("     \u589E\u52A0\u9884\u7EA6     ");

		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
					MessageBox messageBox = new MessageBox(shell, style);
					messageBox.setText("Information");
					messageBox.setMessage("ÊÇ·ñÒªÈ¡ÏûÔ¤Ô¼?");
					if (e.doit = messageBox.open() == SWT.YES) {
						TableItem[] tableItems = table.getSelection();
						int bookid = Integer.parseInt(tableItems[0].getText());
						uml.middleclass.Book.cancel(bookid);
						int count = table.getItemCount();
						
						for(int i = 0; i < count;i++){
							table.getItem(0).dispose();
						}
						
						int b = dateTime.getMonth() + 1;
						int c = dateTime.getDay();
						int d = dateTime.getYear();
						List<String> allbooksBooks = uml.middleclass.Book.getbooks();
						for (int i = 0; i < allbooksBooks.size(); i += 5) {
							Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
							SimpleDateFormat f_day=new SimpleDateFormat("dd"); 
							int day = Integer.parseInt(f_day.format(date).toString());
							if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
								TableItem tableItem2 = new TableItem(table, SWT.NONE);
								if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
									tableItem2.setText(new String[] { allbooksBooks.get(i),
											allbooksBooks.get(i + 1),
											allbooksBooks.get(i + 2),
											"Ôç²Í",
											allbooksBooks.get(i + 4),});
								}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
									tableItem2.setText(new String[] { allbooksBooks.get(i),
											allbooksBooks.get(i + 1),
											allbooksBooks.get(i + 2),
											"Îç²Í",
											allbooksBooks.get(i + 4),});
								}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
									tableItem2.setText(new String[] { allbooksBooks.get(i),
											allbooksBooks.get(i + 1),
											allbooksBooks.get(i + 2),
											"Íí²Í",
											allbooksBooks.get(i + 4),});
								}else {
									tableItem2.setText(new String[] { allbooksBooks.get(i),
											allbooksBooks.get(i + 1),
											allbooksBooks.get(i + 2),
											"Ò¹Ïü",
											allbooksBooks.get(i + 4),});
								}
							}
						}
					}
				}
			}
		});
		toolItem_1.setImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u53D6\u6D88\u9884\u7EA6.png"));
		toolItem_1.setText("     \u53D6\u6D88\u9884\u7EA6      ");

		ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		toolItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					TableItem[] tableItems = table.getSelection();
					int bookid = Integer.parseInt(tableItems[0].getText());
					
					Book book = Book.getBook(bookid);
					for (int i = 0; i < book.getTables().size(); i++) {
						Book.deletebookdishes(bookid, book.getTables().get(i).getTableid());
					}
					
					Ôö¼ÓÔ¤Ô¼ window = new Ôö¼ÓÔ¤Ô¼(bookid);
					window.open();
					
					int count = table.getItemCount();
					for(int i = 0; i < count;i++){
						table.getItem(0).dispose();
					}
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					int d = dateTime.getYear();
					List<String> allbooksBooks = uml.middleclass.Book.getbooks();
					for (int i = 0; i < allbooksBooks.size(); i += 5) {
						Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
						SimpleDateFormat f_day=new SimpleDateFormat("dd"); 
						int day = Integer.parseInt(f_day.format(date).toString());
						if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
							TableItem tableItem2 = new TableItem(table, SWT.NONE);
							if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Ôç²Í",
										allbooksBooks.get(i + 4),});
							}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Îç²Í",
										allbooksBooks.get(i + 4),});
							}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Íí²Í",
										allbooksBooks.get(i + 4),});
							}else {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Ò¹Ïü",
										allbooksBooks.get(i + 4),});
							}
						}
					}
				}				
			}
		});
		toolItem_2.setImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u4FEE\u6539\u9884\u7EA6.png"));
		toolItem_2.setText("      \u4FEE\u6539\u9884\u7EA6       ");

		ToolItem toolItem_3 = new ToolItem(toolBar, SWT.NONE);
		toolItem_3.setImage(SWTResourceManager.getImage(Child_GUI2.class,
				"/pic/\u9884\u7EA6\u5230\u8FBE.png"));
		toolItem_3.setText("      \u9884\u7EA6\u5230\u8FBE      ");
		int d = dateTime.getYear();
		int b = dateTime.getMonth() + 1;
		int c = dateTime.getDay();
		List<String> allbooksBooks = uml.middleclass.Book.getbooks();
		for (int i = 0; i < allbooksBooks.size(); i += 5) {
			Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
			SimpleDateFormat f_day = new SimpleDateFormat("dd"); 
			int day = Integer.parseInt(f_day.format(date).toString());
			if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
				TableItem tableItem2 = new TableItem(table, SWT.NONE);
				if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
					tableItem2.setText(new String[] { allbooksBooks.get(i),
							allbooksBooks.get(i + 1),
							allbooksBooks.get(i + 2),
							"Ôç²Í",
							allbooksBooks.get(i + 4),});
				}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
					tableItem2.setText(new String[] { allbooksBooks.get(i),
							allbooksBooks.get(i + 1),
							allbooksBooks.get(i + 2),
							"Îç²Í",
							allbooksBooks.get(i + 4),});
				}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
					tableItem2.setText(new String[] { allbooksBooks.get(i),
							allbooksBooks.get(i + 1),
							allbooksBooks.get(i + 2),
							"Íí²Í",
							allbooksBooks.get(i + 4),});
				}else {
					tableItem2.setText(new String[] { allbooksBooks.get(i),
							allbooksBooks.get(i + 1),
							allbooksBooks.get(i + 2),
							"Ò¹Ïü",
							allbooksBooks.get(i + 4),});
				}
			}
		}
		toolItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					TableItem[] tableItems = table.getSelection();
					int bookid = Integer.parseInt(tableItems[0].getText());
					uml.middleclass.Book.arrival(bookid);
					int count = table.getItemCount();
					for(int i = 0; i < count;i++){
						table.getItem(0).dispose();
					}
					int b = dateTime.getMonth() + 1;
					int c = dateTime.getDay();
					int d = dateTime.getYear();
					List<String> allbooksBooks = uml.middleclass.Book.getbooks();
					for (int i = 0; i < allbooksBooks.size(); i += 5) {
						Date date = uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getBookTime();
						SimpleDateFormat f_day=new SimpleDateFormat("dd"); 
						int day = Integer.parseInt(f_day.format(date).toString());
						if(day == c && (date.getMonth() + 1) == b && d == (date.getYear() + 1900) && (uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("NOTARRIVAL") || uml.middleclass.Book.getBook(Integer.parseInt(allbooksBooks.get(i))).getState().equals("ARRIVAL"))){
							TableItem tableItem2 = new TableItem(table, SWT.NONE);
							if(allbooksBooks.get(i + 3).equals("BREAKFAST")){
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Ôç²Í",
										allbooksBooks.get(i + 4),});
							}else if (allbooksBooks.get(i + 3).equals("LUNCH")) {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Îç²Í",
										allbooksBooks.get(i + 4),});
							}else if (allbooksBooks.get(i + 3).equals("DINNER")) {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Íí²Í",
										allbooksBooks.get(i + 4),});
							}else {
								tableItem2.setText(new String[] { allbooksBooks.get(i),
										allbooksBooks.get(i + 1),
										allbooksBooks.get(i + 2),
										"Ò¹Ïü",
										allbooksBooks.get(i + 4),});
							}
						}
					}
				}
			}
		});
	}
}
