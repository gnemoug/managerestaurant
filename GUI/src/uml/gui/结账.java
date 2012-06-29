package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableItem;
import java.util.List;
import uml.middleclass.Dish;
import uml.middleclass.DishGroup;

public class Ω·’À {

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Text text_2;
	private float money;
	List<String> walkinbillshowsList = null;
	private int ptableid;
	private int walkinbillid;
	private int bookbillid;

	public Ω·’À() {
		
	}
	
	public Ω·’À(int ptableid, int walkinbillid, int bookbillid) {
		setPtableid(ptableid);
		setWalkinbillid(walkinbillid);
		setBookbillid(bookbillid);
	}

	public Ω·’À(int ptableid, int walkinbillid, int bookbillid, float money,
			List<String> walkinbillshowsList) {
		setMoney(money);
		setWalkinbillshowsList(walkinbillshowsList);
		setPtableid(ptableid);
		setWalkinbillid(walkinbillid);
		setBookbillid(bookbillid);
	}

	public int getBookbillid() {
		return bookbillid;
	}

	public void setBookbillid(int bookbillid) {
		this.bookbillid = bookbillid;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public List<String> getWalkinbillshowsList() {
		return walkinbillshowsList;
	}

	public void setWalkinbillshowsList(List<String> walkinbillshowsList) {
		this.walkinbillshowsList = walkinbillshowsList;
	}

	public int getPtableid() {
		return ptableid;
	}

	public void setPtableid(int ptableid) {
		this.ptableid = ptableid;
	}

	public int getWalkinbillid() {
		return walkinbillid;
	}

	public void setWalkinbillid(int walkinbillid) {
		this.walkinbillid = walkinbillid;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ω·’À window = new Ω·’À();
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
		shell.setImage(SWTResourceManager
				.getImage(Ω·’À.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Ω·’À.class,
				"/pic/\u80CC\u666F0.jpg"));
		shell.setSize(737, 505);
		shell.setText("Ω·’À");

		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 10, SWT.BOLD));
		tabFolder.setBounds(0, 80, 377, 324);

		final TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("\u83DC\u5355");

		table = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(Ω·’À.class,
				"/pic/\u80CC\u666F1.jpg"));
		tabItem.setControl(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(94);
		tableColumn_1.setText("\u540D\u79F0");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(78);
		tblclmnNewColumn.setText("\u7C7B\u522B");

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(58);
		tableColumn.setText("\u7B80\u62FC");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(55);
		tableColumn_2.setText("\u4EF7\u683C");

		TableColumn tableColumn_3 = new TableColumn(table, SWT.CENTER);
		tableColumn_3.setWidth(38);
		tableColumn_3.setText("\u5355\u4F4D");

		TableColumn tableColumn_4 = new TableColumn(table, SWT.CENTER);
		tableColumn_4.setWidth(40);
		tableColumn_4.setText("\u5E93\u5B58");

		final TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("\u5206\u7C7B\u83DC\u5355");

		final Tree tree = new Tree(tabFolder, SWT.BORDER);
		tree.setBackgroundImage(SWTResourceManager.getImage(Ω·’À.class,
				"/pic/\u80CC\u666F1.jpg"));
		tabItem_1.setControl(tree);

		List<DishGroup> dishGroups = DishGroup.getAllDishGroups();
		List<Dish> dishs1 = Dish.getAllDishs();

		for (int i = 0; i < dishGroups.size(); i++) {
			TreeItem treeItem_n = new TreeItem(tree, 0);
			treeItem_n.setText(dishGroups.get(i).getCategory());
			treeItem_n
					.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
			for (int j = 0; j < dishs1.size(); j++) {
				if (dishs1.get(j).getDishGroup().getCategory()
						.equals(dishGroups.get(i).getCategory())) {
					TreeItem treeItem_m = new TreeItem(treeItem_n, SWT.NONE);
					treeItem_m.setText(dishs1.get(j).getName());
					treeItem_m.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 11,
							SWT.BOLD));
				}

			}
		}

		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBackgroundImage(SWTResourceManager.getImage(Ω·’À.class,
				"/pic/\u80CC\u666F1.jpg"));
		table_1.setBounds(431, 112, 290, 292);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tableColumn_7 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_7.setWidth(85);
		tableColumn_7.setText("            \u540D\u79F0");

		TableColumn tableColumn_8 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_8.setWidth(72);
		tableColumn_8.setText("\u4EF7\u683C");

		TableColumn tableColumn_9 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_9.setWidth(70);
		tableColumn_9.setText("\u6570\u91CF");

		TableColumn tableColumn_10 = new TableColumn(table_1, SWT.CENTER);
		tableColumn_10.setWidth(70);
		tableColumn_10.setText("◊¿◊”∫≈");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TabItem[] tabItems = tabFolder.getSelection();
				if (tabItems[0] == tabItem_1) {
					TreeItem[] treeItems = tree.getSelection();
					if (treeItems.length != 0 && treeItems[0].getParentItem() != null) {
						int i = 0;
						int count = table_1.getItemCount();
						for (i = 0; i < count; i++) {
							if (table_1.getItem(i).getText(0).equals(treeItems[0].getText())) {
								table_1.getItem(i).setText(2,String.valueOf(Integer.parseInt(table_1.getItem(i).getText(2)) + 1));
								for (int j = 0; j < table.getItemCount(); j++) {
									if(table.getItem(j).getText(0).equals(treeItems[0].getText())){
										table.getItem(j).setText(5, String.valueOf(Integer.parseInt(table.getItem(j).getText(5)) - 1));
									}
								}
								break;
							}
						}

						if (i == count) {
							for (int j = 0; j < table.getItemCount(); j++) {
								if(table.getItem(j).getText(0).equals(treeItems[0].getText())){
									table.getItem(j).setText(5, String.valueOf(Integer.parseInt(table.getItem(j).getText(5)) - 1));
									TableItem tableItem = new TableItem(table_1,SWT.NONE);
									tableItem.setText(new String[] {table.getItem(j).getText(0),table.getItem(j).getText(3), "1" });
								}
							}
						}
					}
				} else if (tabItems[0] == tabItem) {
					TableItem[] tableItems = table.getSelection();
					// System.out.println(tableItems[0].getText(5));
					tableItems[0].setText(5, String.valueOf(Integer
							.parseInt(tableItems[0].getText(5)) - 1));
					if (tableItems.length != 0) {
						int i = 0;
						int count = table_1.getItemCount();
						for (i = 0; i < count; i++) {
							if (table_1.getItem(i).getText(0).equals(tableItems[0].getText(0))) {
								table_1.getItem(i).setText(2,String.valueOf(Integer.parseInt(table_1.getItem(i).getText(2)) + 1));
								break;
							}
						}

						if (i == count) {
							TableItem tableItem = new TableItem(table_1,
									SWT.NONE);
							tableItem.setText(new String[] {
									tableItems[0].getText(0),
									tableItems[0].getText(3), "1" });
						}
					}

				}
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(Ω·’À.class,
				"/pic/\u7BAD\u59342.png"));
		btnNewButton.setBounds(383, 219, 42, 27);

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table_1.getSelectionCount() != 0){
					TableItem[] tableItems = table_1.getSelection();
					if (tableItems.length != 0) {
						int count = table.getItemCount();
						for (int i = 0; i < count; i++) {
							if (table.getItem(i).getText(0).equals(tableItems[0].getText())) {
								table.getItem(i).setText(5,String.valueOf(Integer.parseInt(tableItems[0].getText(2)) + Integer.parseInt(table.getItem(i).getText(5))));
								tableItems[0].dispose();
								break;
							}
						}
					}
				}
			}
		});
		button.setBounds(471, 79, 80, 27);
		button.setText("\u5220\u83DC");

		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		label.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 15, SWT.BOLD));
		label.setBounds(262, 10, 120, 27);
		label.setText("\u987E\u5BA2\u6D88\u8D39\u6E05\u5355");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		label_2.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		label_2.setBounds(160, 52, 80, 27);
		label_2.setText("\u6D88\u8D39\u91D1\u989D\uFF1A");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(getWalkinbillid() == 0){
					uml.middleclass.Book.checkout(getBookbillid());
				}else{
					
				}
				shell.close();
			}
		});
		button_1.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		button_1.setBounds(435, 430, 80, 27);
		button_1.setText("\u7ED3\u8D26");

		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_3.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		button_3.setBounds(552, 430, 80, 27);
		button_3.setText("\u53D6\u6D88");

		text_2 = new Text(shell, SWT.READ_ONLY);
		text_2.setBounds(29, 14, 128, 23);

		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel.setFont(SWTResourceManager.getFont("Œ¢»Ì—≈∫⁄", 12, SWT.BOLD));
		lblNewLabel.setBounds(247, 51, 97, 23);
		lblNewLabel.setText("New Label");

		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float displaymoney = 0;
				int count = table_1.getItemCount();
				System.out.println(count);
				for (int i = 0; i < count; i++) {
					displaymoney += Float
							.valueOf(table_1.getItem(i).getText(1))
							* Integer.parseInt(table_1.getItem(i).getText(2));
				}
				lblNewLabel.setText(String.valueOf(displaymoney) + "‘™");
			}
		});
		button_4.setBounds(401, 46, 80, 27);
		button_4.setText("\u663E\u793A\u6D88\u8D39\u91D1\u989D");
		if(getWalkinbillshowsList() == null){
			System.out.println("shit!");
		}else{
			for (int i = 0; i < getWalkinbillshowsList().size(); i = i + 4) {
				TableItem tableItem1 = new TableItem(table_1, SWT.NONE);
				tableItem1.setText(new String[] { walkinbillshowsList.get(i),
						walkinbillshowsList.get(i + 1),
						walkinbillshowsList.get(i + 2),walkinbillshowsList.get(i + 3) });
			}	
		}



		List<Dish> dishs = Dish.getAllDishs();
		for (int i = 0; i < dishs.size(); i++) {
			TableItem tableItem2 = new TableItem(table, SWT.NONE);
			tableItem2.setText(new String[] { dishs.get(i).getName(),
					dishs.get(i).getDishGroup().getCategory(),
					dishs.get(i).getJinpin(),
					String.valueOf(dishs.get(i).getUnitPrice()),
					dishs.get(i).getUnitgroup(),
					String.valueOf(dishs.get(i).getCurrentInventory()) });
		}
		lblNewLabel.setText(String.valueOf(getMoney()) + "‘™");
	}
}
