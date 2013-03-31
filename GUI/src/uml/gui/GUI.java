package uml.gui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

import java.text.SimpleDateFormat;

import uml.middleclass.Book;
import uml.middleclass.TableGroup;
import uml.middleclass.WalkinBill;

public class GUI {
	protected Shell shlStar;
	private Table table;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Label lblNewLabel_5;
	private Label lblNewLabel_6;
	private ToolBar toolBar;
	private String Num = "0";
	private Button button100;
	static String time = "0";
	private Display display;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.open();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlStar.open();
		shlStar.layout();
		while (!shlStar.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStar = new Shell(SWT.BORDER | SWT.MIN | SWT.RESIZE);
		shlStar.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shlStar.setImage(SWTResourceManager
				.getImage(GUI.class, "/pic/icon.ico"));
		shlStar.setBackgroundMode(SWT.INHERIT_FORCE);
		shlStar.setBackgroundImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u80CC\u666F2.jpg"));
		shlStar.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
				MessageBox messageBox = new MessageBox(shlStar, style);
				messageBox.setText("Information");
				messageBox.setMessage("ȷ��Ҫ�˳�ϵͳ��?");
				e.doit = messageBox.open() == SWT.YES;
			}
		});
		shlStar.setSize(958, 662);
		shlStar.setText("star\u9910\u9986\u8BA2\u9910\u7CFB\u7EDF");

		Composite composite = new Composite(shlStar, SWT.EMBEDDED);
		composite.setBounds(0, 105, 226, 285);
		lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		lblNewLabel_3.setBounds(108, 89, 73, 17);

		lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		lblNewLabel_2.setBounds(105, 37, 76, 17);

		lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		lblNewLabel_4.setBounds(108, 141, 73, 18);

		lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		lblNewLabel_5.setBounds(103, 193, 78, 17);

		lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_MAGENTA));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		lblNewLabel_6.setBounds(100, 242, 81, 17);

		table = new Table(shlStar, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u80CC\u666F1.jpg"));
		table.setBackground(SWTResourceManager.getColor(204, 255, 153));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(248, 409, 540, 193);
				
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Num = "0";
			}
		});

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Num = "0";
			}
		});
		tableColumn.setWidth(113);
		tableColumn.setText("         \u83DC\u540D");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(155);
		tableColumn_1.setText("\u4EF7\u683C");
		tableColumn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Num = "0";
			}
		});

		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(119);
		tableColumn_2.setText("\u6570\u91CF");
		tableColumn_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Num = "0";
			}
		});
	
		TableColumn tableColumn_3 = new TableColumn(table, SWT.CENTER);
		tableColumn_3.setWidth(153);
		tableColumn_3.setText("\u684C\u5B50\u53F7");
		tableColumn_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Num = "0";
			}
		});
		
		final TabFolder tabFolder = new TabFolder(shlStar, SWT.NONE);

		tabFolder.setBounds(252, 80, 690, 323);
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("\u5927\u5385");

		List<TableGroup> tablegroups = TableGroup.getTablegroups();

		for (int i = 0; i < tablegroups.size(); i++) {
			List<uml.middleclass.Table> tables = tablegroups.get(i).getTables();
			TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
			tabItem_1.setText(tablegroups.get(i).getCategory());

			Composite composite_1 = new Composite(tabFolder, SWT.NONE);
			composite_1.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));
			tabItem_1.setControl(composite_1);
			composite_1.setLayout(new FillLayout());
			ScrolledComposite scrolledComposite_1 = new ScrolledComposite(
					composite_1, SWT.V_SCROLL);
			scrolledComposite_1.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));

			Composite composite_2 = new Composite(scrolledComposite_1, SWT.NONE);
			composite_2.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));
			scrolledComposite_1.setContent(composite_2);
			composite_2.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_WHITE)); // White color
			composite_2.setLayout(new GridLayout(9, true));

			for (int j = 0; j < tables.size(); j++) {
				final Button button_n = new Button(composite_2, SWT.PUSH);
				button_n.setText(String.valueOf(tables.get(j).getTableid()));
				if (tables.get(j).getState().equals("EMPTY")) {
					button_n.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u65E0\u4EBA.png"));
				} else if (tables.get(j).getState().equals("WALK_IN")) {
					button_n.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u6709\u4EBA.png"));
				} else {
					List<Integer> bookbillids = uml.middleclass.Table
							.getBookbillids(tables.get(j).getTableid());
					int k = 0;
					for (k = 0; k < bookbillids.size(); k++) {
						if (Book.getBook(bookbillids.get(k)).getState()
								.equals("ARRIVAL")) {
							button_n.setImage(SWTResourceManager.getImage(
									GUI.class, "/pic/\u6709\u4EBA.png"));
							break;
						}
					}
					if (bookbillids.size() == k) {
						button_n.setImage(SWTResourceManager
								.getImage(GUI.class,
										"/pic/\u6709\u9884\u7EA6\u7684\u684C\u5B50.png"));
					}
				}
				DragSource source = new DragSource(button_n, DND.DROP_MOVE
						| DND.DROP_COPY);
				source.setTransfer(new Transfer[] { TextTransfer.getInstance() });// ���ô�������Ϊ�ı���
				source.addDragListener(new MyDragSourceListener());
				// ����targetTextΪĿ����
				DropTarget target = new DropTarget(button_n, DND.DROP_MOVE
						| DND.DROP_COPY | DND.DROP_DEFAULT);
				target.setTransfer(new Transfer[] { TextTransfer.getInstance() });
				target.addDropListener(new MyDropTargetListener());
				button_n.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Num = button_n.getText();
						int count = table.getItemCount();
						for (int i = 0; i < count; i++) {
							table.getItem(0).dispose();
						}
						int ptableid = Integer.parseInt(button_n.getText());
						String stateString = uml.middleclass.Table.search(
								ptableid).getState();
						if (stateString.equals("EMPTY")) {
							lblNewLabel_2.setText(String
									.valueOf(uml.middleclass.Table
											.search(ptableid).getTableGroup()
											.getContain_number()));
							lblNewLabel_3.setText("");
							lblNewLabel_4.setText("");
							lblNewLabel_5.setText("");
							lblNewLabel_6.setText("����");
						} else if (stateString.equals("WALK_IN")) {
							int walkinbillid = uml.middleclass.Table
									.getWalkinid(ptableid);
							List<String> walkinbillshowsList = uml.middleclass.Table
									.getwalkinbillshows(ptableid, walkinbillid);
							float wholemoney = 0;
							for (int i = 0; i < walkinbillshowsList.size(); i = i + 3) {
								wholemoney += Float.valueOf(walkinbillshowsList
										.get(i + 1))
										* Integer.parseInt(walkinbillshowsList
												.get(i + 2));
								TableItem tableItem = new TableItem(table,
										SWT.NONE);
								tableItem.setText(new String[] {walkinbillshowsList.get(i),walkinbillshowsList.get(i + 1),walkinbillshowsList.get(i + 2),String.valueOf(ptableid) });
							}
							uml.middleclass.Table table = uml.middleclass.Table
									.search(ptableid);
							lblNewLabel_2.setText(String.valueOf(table
									.getTableGroup().getLowest_consumption()));
							uml.middleclass.WalkinBill walkinBill = uml.middleclass.WalkinBill
									.getWalkinBill(walkinbillid);
							SimpleDateFormat d = new SimpleDateFormat(
									"HH:mm:ss");
							lblNewLabel_3.setText(d.format(walkinBill.getDate()));
							Date date = new Date();
							double minutes = (date.getMinutes() - walkinBill
									.getDate().getMinutes())
									+ (date.getHours() - walkinBill.getDate()
											.getHours()) * 60;
							lblNewLabel_4.setText(String.valueOf(minutes) + "��");
							lblNewLabel_5.setText(String.valueOf(wholemoney)
									+ "Ԫ");
							lblNewLabel_6.setText("����");
						} else {
							List<Integer> bookbillids = uml.middleclass.Table
									.getBookbillids(ptableid);
							int k = 0;
							for (k = 0; k < bookbillids.size(); k++) {
								if (Book.getBook(bookbillids.get(k)).getState()
										.equals("ARRIVAL")) {
									Book book = Book.getBook(bookbillids.get(k));
									int size = book.getTables().size();
									List<String> resultsStrings = uml.middleclass.Table
											.getbookbillshows(ptableid,
													bookbillids.get(k));
									System.out.println(resultsStrings);
									float wholemoney = 0;
									for (int i = 0; i < resultsStrings.size(); i = i + 4) {
										wholemoney += Float
												.valueOf(resultsStrings
														.get(i + 1))
												* Integer
														.parseInt(resultsStrings
																.get(i + 2));
										TableItem tableItem = new TableItem(
												table, SWT.NONE);
										tableItem.setText(new String[] {
												resultsStrings.get(i),
												resultsStrings.get(i + 1),
												resultsStrings.get(i + 2),resultsStrings.get(i + 3) });
									}
									lblNewLabel_2.setText(String
											.valueOf(uml.middleclass.Table
													.search(ptableid)
													.getTableGroup()
													.getContain_number()));
									SimpleDateFormat d = new SimpleDateFormat(
											"HH:mm:ss");
									lblNewLabel_3.setText(d.format(book
											.getPreArrivalTime()));
									Date date = new Date();
									double minutes = (date.getMinutes() - book
											.getPreArrivalTime().getMinutes())
											+ (date.getHours() - book
													.getPreArrivalTime()
													.getHours()) * 60;
									lblNewLabel_4.setText(String
											.valueOf(minutes) + "��");
									lblNewLabel_5.setText(String
											.valueOf(wholemoney) + "Ԫ");
									lblNewLabel_6.setText("Ԥ������");
									break;
								}
							}
							if (k == bookbillids.size()) {
								lblNewLabel_2.setText(String
										.valueOf(uml.middleclass.Table
												.search(ptableid)
												.getTableGroup()
												.getContain_number()));
								lblNewLabel_3.setText("");
								lblNewLabel_4.setText("");
								lblNewLabel_5.setText("");
								lblNewLabel_6.setText("Ԥ��δ��");
							}
						}
					}
				});
			}
			scrolledComposite_1.setExpandHorizontal(true);
			scrolledComposite_1.setExpandVertical(true);
			scrolledComposite_1.setMinSize(composite_2.computeSize(
					composite_2.getSize().x, SWT.DEFAULT));
		}

		tabFolder.getItems()[0].dispose();

		toolBar = new ToolBar(shlStar, SWT.FLAT);
		toolBar.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		toolBar.setFont(SWTResourceManager.getFont("΢���ź�", 9, SWT.BOLD));
		toolBar.setBounds(10, 0, 871, 74);

		ToolItem tltmNewItem_2 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ptableid = Integer.parseInt(Num);
				if (ptableid == 0) {
					;
				} else {
					if (uml.middleclass.Table.search(ptableid).getState()
							.equals("EMPTY")) {
						shlStar.setEnabled(false);
						Child_GUI4 window = new Child_GUI4(Integer.valueOf(Num));
						window.open();
						shlStar.setEnabled(true);
						display(tabFolder);
					} else if (uml.middleclass.Table.search(ptableid)
							.getState().equals("WALK_IN")) {
						shlStar.setEnabled(false);
						int walkinbillid = uml.middleclass.Table
								.getWalkinid(Integer.valueOf(Num));
						String peoplenumberString = String
								.valueOf(uml.middleclass.WalkinBill
										.getWalkinBill(walkinbillid)
										.getPeopleNumber());
						String feedback = String
								.valueOf(uml.middleclass.WalkinBill
										.getWalkinBill(walkinbillid)
										.getFeedback());
						System.out.println(feedback);
						Child_GUI4 window = new Child_GUI4(
								Integer.valueOf(Num), peoplenumberString,
								feedback);
						window.open();
						shlStar.setEnabled(true);
						display(tabFolder);
					} else {
						;
					}
				}
			}
		});
		tltmNewItem_2.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u5F00\u5355.png"));
		tltmNewItem_2.setText("      \u5F00\u5355/\u4FEE\u6539\u5355      ");

		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI2 window = new Child_GUI2();
				window.open();
				shlStar.setEnabled(true);
				display(tabFolder);
			}
		});
		tltmNewItem.setWidth(71);
		tltmNewItem.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u9884\u7EA6.png"));
		tltmNewItem.setText("        \u9884\u7EA6       ");

		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ptableid = Integer.parseInt(Num);
				if (ptableid == 0) {
					;
				} else {
					if (uml.middleclass.Table.search(ptableid).getState()
							.equals("EMPTY")) {
						System.out.println(Num);
					} else if (uml.middleclass.Table.search(ptableid)
							.getState().equals("WALK_IN")) {
						int walkinbillid = uml.middleclass.Table
								.getWalkinid(ptableid);
						List<String> walkinbillshowsList = uml.middleclass.Table
								.getwalkinbillshows(ptableid, walkinbillid);
						if (walkinbillshowsList.size() == 0) {
							int style = SWT.APPLICATION_MODAL | SWT.YES
									| SWT.NO;
							MessageBox messageBox = new MessageBox(shlStar,
									style);
							messageBox.setText("Information");
							messageBox.setMessage("�Ƿ�Ҫȡ������?");
							if(messageBox.open() == SWT.YES){
								e.doit = true;
								WalkinBill.giveup(walkinbillid,ptableid);
								display(tabFolder);
							}else{
								e.doit = false;
							}
						} else {
							float wholemoney = 0;
							for (int i = 0; i < walkinbillshowsList.size(); i = i + 3) {
								wholemoney += Float.valueOf(walkinbillshowsList
										.get(i + 1))
										* Integer.parseInt(walkinbillshowsList
												.get(i + 2));
							}
							int bookbillid = 0;
							shlStar.setEnabled(false);
							���� window = new ����(ptableid, walkinbillid,
									bookbillid, wholemoney, walkinbillshowsList);
							window.open();
							shlStar.setEnabled(true);
							display(tabFolder);
						}
					} else {
						List<Integer> bookbillids = uml.middleclass.Table
								.getBookbillids(ptableid);
						int k = 0;
						for (k = 0; k < bookbillids.size(); k++) {
							if (Book.getBook(bookbillids.get(k)).getState()
									.equals("ARRIVAL")) {
								Book book = Book.getBook(bookbillids.get(k));
								int size = book.getTables().size();
								List<String> resultsStrings = uml.middleclass.Table
										.getbookbillshows(ptableid,
												bookbillids.get(k));
								if (resultsStrings.size() == 0) {
									;
								} else {
									int walkinbillid = 0;
									float wholemoney = 0;
									for (int i = 0; i < resultsStrings.size(); i = i + 4) {
										wholemoney += Float
												.valueOf(resultsStrings
														.get(i + 1))
												* Integer
														.parseInt(resultsStrings
																.get(i + 2));
									}
									shlStar.setEnabled(false);
									���� window = new ����(ptableid, walkinbillid,
											bookbillids.get(k), wholemoney, resultsStrings);
									window.open();
									shlStar.setEnabled(true);
									display(tabFolder);
								}
								break;
							}
						}
						if (k == bookbillids.size()) {
							;
						}
					}
				}
			}
		});
		toolItem.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u7ED3\u8D261.png"));
		toolItem.setText("          \u7ED3\u8D26         ");

		ToolItem toolItem_3 = new ToolItem(toolBar, SWT.NONE);
		toolItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				G��Ա���� window = new G��Ա����();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		toolItem_3.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/vip\u7ED3\u8D26.png"));
		toolItem_3.setText("    \u4F1A\u5458\u7ED3\u8D26    ");

		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u52A0\u83DC.png"));
		tltmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int ptableid = Integer.parseInt(Num);
				if (ptableid == 0) {
					System.out.println("0");
				} else {
					if (uml.middleclass.Table.search(ptableid).getState()
							.equals("EMPTY")) {
						System.out.println(Num);
					} else if (uml.middleclass.Table.search(ptableid)
							.getState().equals("WALK_IN")) {
						int walkinbillid = uml.middleclass.Table
								.getWalkinid(ptableid);
						List<String> walkinbillshowsList = uml.middleclass.Table
								.getwalkinbillshows(ptableid, walkinbillid);
						if (walkinbillshowsList.size() == 0) {
							shlStar.setEnabled(false);
							���� window = new ����(ptableid, walkinbillid, 0);
							window.open();
							shlStar.setEnabled(true);
							display(tabFolder);
						} else {
							int bookbillid = 0;
							float wholemoney = 0;
							for (int i = 0; i < walkinbillshowsList.size(); i = i + 3) {
								wholemoney += Float.valueOf(walkinbillshowsList
										.get(i + 1))
										* Integer.parseInt(walkinbillshowsList
												.get(i + 2));
							}
							shlStar.setEnabled(false);
							���� window = new ����(ptableid, walkinbillid,
									bookbillid, wholemoney, walkinbillshowsList);
							window.open();
							shlStar.setEnabled(true);
							display(tabFolder);
						}
					} else {
						List<Integer> bookbillids = uml.middleclass.Table
								.getBookbillids(ptableid);
						int k = 0;
						for (k = 0; k < bookbillids.size(); k++) {
							if (Book.getBook(bookbillids.get(k)).getState()
									.equals("ARRIVAL")) {
								Book book = Book.getBook(bookbillids.get(k));
								int size = book.getTables().size();
								List<String> resultsStrings = uml.middleclass.Table
										.getbookbillshows(ptableid,
												bookbillids.get(k));
								if (resultsStrings.size() == 0) {
									shlStar.setEnabled(false);
									���� window = new ����(ptableid, 0, bookbillids
											.get(k));
									window.open();
									shlStar.setEnabled(true);
									display(tabFolder);
								} else {
									int walkinbillid = 0;
									float wholemoney = 0;
									List<String> newresultsStrings = new ArrayList<String>();
									for (int i = 0; i < resultsStrings.size(); i = i + 4) {
										wholemoney += Float.valueOf(resultsStrings.get(i + 1))* Integer.parseInt(resultsStrings.get(i + 2));
										if(resultsStrings.get(i + 3).equals(String.valueOf(ptableid))){
											newresultsStrings.add(resultsStrings.get(i));
											newresultsStrings.add(resultsStrings.get(i + 1));
											newresultsStrings.add(resultsStrings.get(i + 2));
										}
									}
									if (newresultsStrings.size() == 0){
										shlStar.setEnabled(false);
										���� window = new ����(ptableid, 0, bookbillids
												.get(k));
										window.open();
										shlStar.setEnabled(true);
										display(tabFolder);
									}else{
										shlStar.setEnabled(false);
										���� window = new ����(ptableid, walkinbillid,
												bookbillids.get(k), wholemoney,
												newresultsStrings);
										window.open();
										shlStar.setEnabled(true);
										display(tabFolder);
									}
								}
								break;
							}
						}
						if (k == bookbillids.size()) {
							;
						}
					}
				}
			}
		});
		tltmNewItem_1.setText("          \u52A0\u83DC          ");

		ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		toolItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				G��Ա���� window = new G��Ա����();
				window.open();
			}
		});
		toolItem_2.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/vip1.png"));
		toolItem_2.setText("      \u4F1A\u5458\u7BA1\u7406     ");

		ToolItem toolItem_4 = new ToolItem(toolBar, SWT.NONE);
		toolItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				G�������� window = new G��������();
				window.open();
				shlStar.setEnabled(true);
				
			}
		});
		toolItem_4.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u8D22\u52A1\u7BA1\u7406.png"));
		toolItem_4.setText("    \u8D22\u52A1\u7BA1\u7406    ");

		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI3 window = new Child_GUI3();
				window.open();
				shlStar.setEnabled(true);
				display(tabFolder);
			}
		});

		toolItem_1.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/\u7CFB\u7EDF\u8BBE\u7F6E.png"));
		toolItem_1.setText("      \u7CFB\u7EDF\u8BBE\u7F6E    ");		
		
		final Label ymd = new Label(shlStar, SWT.NONE);
		ymd.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		ymd.setAlignment(SWT.CENTER);
		ymd.setBounds(0, 471, 242, 53);
		ymd.setFont(SWTResourceManager.getFont("������κ", 14, SWT.BOLD));

		final Label hms = new Label(shlStar, SWT.NONE);
		hms.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		hms.setAlignment(SWT.CENTER);
		hms.setBounds(0, 524, 242, 58);
		hms.setFont(SWTResourceManager.getFont("������κ", 14, SWT.BOLD));
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					// TODO: handle exception
					// ʹ��UI�߳�
					display.asyncExec(new Runnable() {
						@Override
						public void run() {
							Date date = new Date(System.currentTimeMillis()); // ������ʾʱ���ĸ�ʽ
							SimpleDateFormat sdf1 = new SimpleDateFormat(
									"yyyy��MM��dd��,E");
							SimpleDateFormat sdf2 = new SimpleDateFormat(
									"HH:mm:ss");
							SimpleDateFormat sdf3 = new SimpleDateFormat("HH");
							String hour = sdf3.format(date);
							String ymdStr = sdf1.format(date);
							String hmsStr = sdf2.format(date);

							// ���Ĵ�����Label��ǩ�ؼ���ʾ����
							ymd.setText(ymdStr);
							hms.setText(hmsStr);

							if (!hour.equals(time)) {
								time = hour;
								Book.updatetablestate();
								System.out.println(hour);
								display(tabFolder);
							}

						}
					});
				}
			}
		});
		thread.start();
		
		Menu menu = new Menu(shlStar, SWT.BAR);
		shlStar.setMenuBar(menu);

		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("\u7CFB\u7EDF\u529F\u80FD");

		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);

		MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				����ԤԼ window = new ����ԤԼ();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_1.setText("\u589E\u52A0\u9884\u7EA6");

		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI2 window = new Child_GUI2();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_3.setText("\u53D6\u6D88\u9884\u7EA6");

		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI2 window = new Child_GUI2();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		mntmNewItem.setText("\u4FEE\u6539\u9884\u7EA6");

		MenuItem menuItem_2 = new MenuItem(menu_1, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI2 window = new Child_GUI2();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_2.setText("\u9884\u7EA6\u5230\u8FBE");

		MenuItem menuItem_12 = new MenuItem(menu_1, SWT.NONE);
		menuItem_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI4 window = new Child_GUI4(14);
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_12.setText("\u5F00\u5355");

		MenuItem menuItem_13 = new MenuItem(menu_1, SWT.NONE);
		menuItem_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				���� window = new ����();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_13.setText("\u70B9\u9910");

		MenuItem menuItem_14 = new MenuItem(menu_1, SWT.NONE);
		menuItem_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				���� window = new ����();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_14.setText("\u7ED3\u8D26");

		MenuItem menuItem_6 = new MenuItem(menu, SWT.CASCADE);
		menuItem_6.setText("  \u7CFB\u7EDF\u8BBE\u7F6E  ");

		Menu menu_4 = new Menu(menuItem_6);
		menuItem_6.setMenu(menu_4);

		MenuItem menuItem_7 = new MenuItem(menu_4, SWT.NONE);
		menuItem_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI3 window = new Child_GUI3();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_7.setText("\u623F\u95F4\u53CA\u9910\u684C\u8BBE\u7F6E");

		MenuItem menuItem_9 = new MenuItem(menu_4, SWT.NONE);
		menuItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				Child_GUI3 window = new Child_GUI3();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_9.setText("\u83DC\u5355\u8BBE\u7F6E");

		MenuItem menuItem_10 = new MenuItem(menu, SWT.CASCADE);
		menuItem_10.setText("\u7CFB\u7EDF\u4FE1\u606F");

		Menu menu_5 = new Menu(menuItem_10);
		menuItem_10.setMenu(menu_5);

		MenuItem menuItem_4 = new MenuItem(menu_5, SWT.NONE);
		menuItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				���� window = new ����();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_4.setText("\u5E2E\u52A9");

		MenuItem menuItem_5 = new MenuItem(menu_5, SWT.NONE);
		menuItem_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlStar.setEnabled(false);
				�汾 window = new �汾();
				window.open();
				shlStar.setEnabled(true);
			}
		});
		menuItem_5.setText("\u7CFB\u7EDF\u7248\u672C");

		Label label = new Label(composite, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		label.setFont(SWTResourceManager.getFont("�����п�", 16, SWT.BOLD));
		label.setBounds(10, 0, 50, 27);
		label.setText("\u72B6\u6001");

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		label_1.setBounds(10, 37, 92, 23);
		label_1.setText("\u6700\u4F4E\u6D88\u8D39\uFF1A");

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		label_2.setBounds(10, 89, 92, 27);
		label_2.setText("\u8FDB\u5E97\u65F6\u95F4\uFF1A");

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		label_3.setBounds(10, 141, 92, 17);
		label_3.setText("\u5DF2\u7528\u65F6\u95F4\uFF1A");

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		label_4.setBounds(10, 193, 92, 17);
		label_4.setText("\u6D88\u8D39\u91D1\u989D\uFF1A");

		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("�����п�", 14, SWT.BOLD));
		label_5.setBounds(10, 242, 92, 17);
		label_5.setText("\u9910\u53F0\u72B6\u6001\uFF1A");

		CLabel lblNewLabel = new CLabel(shlStar, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(GUI.class,
				"/pic/logo2.png"));
		lblNewLabel.setBounds(794, 460, 142, 142);
		lblNewLabel.setText("");
	}

	
	public void display(TabFolder tabFolder) {
		for (int i = 0; i < tabFolder.getItems().length; i++) {
			tabFolder.getItems()[i].dispose();
		}
		
		//tabFolder.getItems()[0].dispose();
		List<TableGroup> tablegroups = TableGroup.getTablegroups();

		for (int i = 0; i < tablegroups.size(); i++) {
			List<uml.middleclass.Table> tables = tablegroups.get(i).getTables();
			TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
			tabItem_1.setText(tablegroups.get(i).getCategory());

			Composite composite_1 = new Composite(tabFolder, SWT.NONE);
			composite_1.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));
			tabItem_1.setControl(composite_1);
			composite_1.setLayout(new FillLayout());
			ScrolledComposite scrolledComposite_1 = new ScrolledComposite(
					composite_1, SWT.V_SCROLL);
			scrolledComposite_1.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));

			Composite composite_2 = new Composite(scrolledComposite_1, SWT.NONE);
			composite_2.setBackgroundImage(SWTResourceManager.getImage(
					GUI.class, "/pic/\u80CC\u666F1.jpg"));
			scrolledComposite_1.setContent(composite_2);
			composite_2.setBackground(Display.getCurrent().getSystemColor(
					SWT.COLOR_WHITE));// White color
			composite_2.setLayout(new GridLayout(9, true));

			for (int j = 0; j < tables.size(); j++) {
				final Button button_n = new Button(composite_2, SWT.PUSH);
				button_n.setText(String.valueOf(tables.get(j).getTableid()));
				if (tables.get(j).getState().equals("EMPTY")) {
					button_n.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u65E0\u4EBA.png"));
				} else if (tables.get(j).getState().equals("WALK_IN")) {
					button_n.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u6709\u4EBA.png"));
				} else {
					List<Integer> bookbillids = uml.middleclass.Table
							.getBookbillids(tables.get(j).getTableid());
					int k = 0;
					for (k = 0; k < bookbillids.size(); k++) {
						if (Book.getBook(bookbillids.get(k)).getState()
								.equals("ARRIVAL")) {
							button_n.setImage(SWTResourceManager.getImage(
									GUI.class, "/pic/\u6709\u4EBA.png"));
							break;
						}
					}
					if (bookbillids.size() == k) {
						button_n.setImage(SWTResourceManager
								.getImage(GUI.class,
										"/pic/\u6709\u9884\u7EA6\u7684\u684C\u5B50.png"));
					}
				}
				DragSource source = new DragSource(button_n, DND.DROP_MOVE
						| DND.DROP_COPY);
				source.setTransfer(new Transfer[] { TextTransfer.getInstance() });// ���ô�������Ϊ�ı���
				source.addDragListener(new MyDragSourceListener());
				// ����targetTextΪĿ����
				DropTarget target = new DropTarget(button_n, DND.DROP_MOVE
						| DND.DROP_COPY | DND.DROP_DEFAULT);
				target.setTransfer(new Transfer[] { TextTransfer.getInstance() });
				target.addDropListener(new MyDropTargetListener());
				button_n.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Num = button_n.getText();					
						int count = table.getItemCount();
						for (int i = 0; i < count; i++) {
							table.getItem(0).dispose();
						}
						int ptableid = Integer.parseInt(button_n.getText());
						String stateString = uml.middleclass.Table.search(
								ptableid).getState();
						if (stateString.equals("EMPTY")) {
							lblNewLabel_2.setText(String
									.valueOf(uml.middleclass.Table
											.search(ptableid).getTableGroup()
											.getContain_number()));
							lblNewLabel_3.setText("");
							lblNewLabel_4.setText("");
							lblNewLabel_5.setText("");
							lblNewLabel_6.setText("����");
						} else if (stateString.equals("WALK_IN")) {
							int walkinbillid = uml.middleclass.Table
									.getWalkinid(ptableid);
							List<String> walkinbillshowsList = uml.middleclass.Table
									.getwalkinbillshows(ptableid, walkinbillid);
							float wholemoney = 0;
							for (int i = 0; i < walkinbillshowsList.size(); i = i + 3) {
								wholemoney += Float.valueOf(walkinbillshowsList
										.get(i + 1))
										* Integer.parseInt(walkinbillshowsList
												.get(i + 2));
								TableItem tableItem = new TableItem(table,
										SWT.NONE);
								tableItem.setText(new String[] {
										walkinbillshowsList.get(i),
										walkinbillshowsList.get(i + 1),
										walkinbillshowsList.get(i + 2),String.valueOf(ptableid) });
							}
							uml.middleclass.Table table = uml.middleclass.Table
									.search(ptableid);
							lblNewLabel_2.setText(String.valueOf(table
									.getTableGroup().getLowest_consumption()));
							uml.middleclass.WalkinBill walkinBill = uml.middleclass.WalkinBill
									.getWalkinBill(walkinbillid);
							SimpleDateFormat d = new SimpleDateFormat(
									"HH:mm:ss");
							lblNewLabel_3.setText(d.format(walkinBill.getDate()));
							Date date = new Date();
							double minutes = (date.getMinutes() - walkinBill
									.getDate().getMinutes())
									+ (date.getHours() - walkinBill.getDate()
											.getHours()) * 60;
							lblNewLabel_4.setText(String.valueOf(minutes) + "��");
							lblNewLabel_5.setText(String.valueOf(wholemoney)
									+ "Ԫ");
							lblNewLabel_6.setText("����");
						} else {
							List<Integer> bookbillids = uml.middleclass.Table
									.getBookbillids(ptableid);
							int k = 0;
							for (k = 0; k < bookbillids.size(); k++) {
								if (Book.getBook(bookbillids.get(k)).getState()
										.equals("ARRIVAL")) {
									Book book = Book.getBook(bookbillids.get(k));
									int size = book.getTables().size();
									List<String> resultsStrings = uml.middleclass.Table
											.getbookbillshows(ptableid,
													bookbillids.get(k));
									float wholemoney = 0;
									for (int i = 0; i < resultsStrings.size(); i = i + 4) {
										wholemoney += Float
												.valueOf(resultsStrings
														.get(i + 1))
												* Integer
														.parseInt(resultsStrings
																.get(i + 2));
										TableItem tableItem = new TableItem(
												table, SWT.NONE);
										tableItem.setText(new String[] {
												resultsStrings.get(i),
												resultsStrings.get(i + 1),
												resultsStrings.get(i + 2),resultsStrings.get(i + 3) });
									}
									lblNewLabel_2.setText(String
											.valueOf(uml.middleclass.Table
													.search(ptableid)
													.getTableGroup()
													.getContain_number()));
									SimpleDateFormat d = new SimpleDateFormat(
											"HH:mm:ss");
									lblNewLabel_3.setText(d.format(book
											.getPreArrivalTime()));
									Date date = new Date();
									double minutes = (date.getMinutes() - book
											.getPreArrivalTime().getMinutes())
											+ (date.getHours() - book
													.getPreArrivalTime()
													.getHours()) * 60;
									lblNewLabel_4.setText(String
											.valueOf(minutes) + "��");
									lblNewLabel_5.setText(String
											.valueOf(wholemoney) + "Ԫ");
									lblNewLabel_6.setText("Ԥ������");
									break;
								}
							}
							if (k == bookbillids.size()) {
								lblNewLabel_2.setText(String
										.valueOf(uml.middleclass.Table
												.search(ptableid)
												.getTableGroup()
												.getContain_number()));
								lblNewLabel_3.setText("");
								lblNewLabel_4.setText("");
								lblNewLabel_5.setText("");
								lblNewLabel_6.setText("Ԥ��δ��");
							}
						}
					}
				});
			}
			scrolledComposite_1.setExpandHorizontal(true);
			scrolledComposite_1.setExpandVertical(true);
			scrolledComposite_1.setMinSize(composite_2.computeSize(
					composite_2.getSize().x, SWT.DEFAULT));
		}

		tabFolder.getItems()[0].dispose();
	}

	public Button selectbutton(Composite composite) {
		int num = composite.getChildren().length;
		System.out.println(num);
		for (int i = 0; i < num; i++) {
			if (composite.getChildren()[i].isFocusControl() == true) {
				return (Button) composite.getChildren()[i];
			}
		}
		return null;
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}

	private class MyDragSourceListener implements DragSourceListener {
		// �ж��Ƿ�������ק�������趨���ִ�ʱ��������ק
		public void dragStart(DragSourceEvent event) {
			button100 = getSource(event);// getSource���Զ��巽��
			event.image = button100.getImage();
			// button.setImage(SWTResourceManager.getImage(GUI.class,"/pic/\u65E0\u4EBA.png"));
			if (uml.middleclass.Table.search(Integer.parseInt(button100.getText())).getState().equals("EMPTY")||uml.middleclass.Table.search(Integer.parseInt(button100.getText())).getState().equals("BOOK")) {
				event.doit = false;
			}

		}

		// �Զ��巽����ȡ����קԴ����
		private Button getSource(DragSourceEvent event) {
			DragSource source = (DragSource) event.widget;
			Button button = (Button) source.getControl();// ��sourceButton
			return button;
		}

		// �趨��Ҫ��Transfer����������
		public void dragSetData(DragSourceEvent event) {
			if (TextTransfer.getInstance().isSupportedType(event.dataType)) {// �Ƿ�֧����ק����������
				Button button = getSource(event);
				event.data = button.getText();
			}
		}

		// ��ק�������ɺ�ִ�д˷���
		public void dragFinished(DragSourceEvent event) {
			if (event.detail == DND.DROP_MOVE) {// �������ƶ���ɾ��sourceText�е�����
				Button button = getSource(event);
				button.setText("");
			}
		}
	}

	private class MyDropTargetListener implements DropTargetListener {
		// ��������Ŀ������ʱ���ô˷���
		public void dragEnter(DropTargetEvent event) {
			// Ĭ��ΪDND.DROP_DEFAULT�����ｫ����Ϊ���ƣ���סCtrl��ΪDND.DROP_COPY����סShift��ΪDND.DROP_MOVE��
			if (event.detail == DND.DROP_DEFAULT)
				event.detail = DND.DROP_COPY;
		}

		// ������Ŀ��������Χʱ�᲻�ϵ��ô˷������ڴ˷�������Ҫ������event.feedback��������ֵ�У�
		// FEEDBACK_EXPAND ʹ��ǰ�����µ���չ�����Ա���ק�������ϣ�����������������
		// FEEDBACK_INSERT_AFTER ��ĳ��ڹ�����֮����ʾһ���������ǣ������ڱ���������
		// FEEDBACK_INSERT_BEFORE ��ĳ��ڵ�ǰ������֮ǰ��ʾһ���������ǣ������ڱ���������
		// FEEDBACK_NONE ʲôҲ����.
		// FEEDBACK_SCROLL ʹĿ���������Թ������Ա������ϵ���ǰ�����������ϣ������ڱ���������
		// FEEDBACK_SELECT ʹ��ǰ�����µ��ѡ�У������ڱ���������
		public void dragOver(DropTargetEvent event) {
			event.feedback = DND.FEEDBACK_NONE;
		}

		// �����»��ſ�������������Ctrl, Shift��ʱ���ô˷���
		public void dragOperationChanged(DropTargetEvent event) {
			if (event.detail == DND.DROP_DEFAULT)
				event.detail = DND.DROP_COPY;
		}

		// �������뿪Ŀ������ʱ�����ô˷���
		public void dragLeave(DropTargetEvent event) {
		}

		// ��������ק����,ִ��drop����֮ǰ���ô˷�����
		public void dropAccept(DropTargetEvent event) {
		}

		// ��������ק����ʱ�������õķ���
		public void drop(DropTargetEvent event) {
			if (TextTransfer.getInstance().isSupportedType(
					event.currentDataType)) {
				String str = (String) event.data;// ȡ����������
				DropTarget target = (DropTarget) event.widget;
				Button text = (Button) target.getControl();// ��targetText
				// text.setText(str);
				System.out.print(str + "  " + text.getText());
				if (uml.middleclass.Table.search(Integer.parseInt(str))
						.getState().equals("WALK_IN")) {
					uml.middleclass.Table.swap(Integer.parseInt(str),
							Integer.parseInt(text.getText()));
					text.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u6709\u4EBA.png"));
					button100.setImage(SWTResourceManager.getImage(GUI.class,
							"/pic/\u65E0\u4EBA.png"));
				}
			}
		}
	}
}
