package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.custom.CLabel;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.*;



public class G财务管理 {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			G财务管理 window = new G财务管理();
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
		shell.setImage(SWTResourceManager.getImage(G财务管理.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(731, 513);
		shell.setText("财务管理");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBounds(0, 0, 726, 486);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		
		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setBackgroundMode(SWT.INHERIT_FORCE);
		tabFolder.setBounds(0, 0, 726, 517);
		formToolkit.adapt(tabFolder);
		formToolkit.paintBordersFor(tabFolder);
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("\u8D39\u7528\u53CA\u6536\u5165\u7EDF\u8BA1\u8868");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_1.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F0.jpg"));
		tabItem.setControl(composite_1);
		formToolkit.paintBordersFor(composite_1);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		table.setBounds(38, 22, 506, 361);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("   \u9879\u76EE\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("\u9879\u76EE\u91D1\u989D");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("\u9879\u76EE\u7C7B\u578B");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("\u529E\u7406\u65F6\u95F4");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("\u5907\u6CE8\u4FE1\u606F");
		
		Button button = new Button(composite_1, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					Child_GUI5 window = new Child_GUI5();
					window.open();
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button.setBounds(590, 292, 80, 27);
		formToolkit.adapt(button, true, true);
		button.setText("\u589E\u52A0\u8D39\u7528");
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(table.getSelectionCount() != 0){
					添加收入类型 window = new 添加收入类型();
					window.open();
				}
			}
		});
		button_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		button_1.setBounds(590, 356, 80, 27);
		formToolkit.adapt(button_1, true, true);
		button_1.setText("\u589E\u52A0\u6536\u5165");
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("\u7ECF\u8425\u72B6\u51B5\u7EDF\u8BA1\u8868");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		composite_2.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_2.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F0.jpg"));
		tbtmNewItem.setControl(composite_2);
		formToolkit.paintBordersFor(composite_2);
		
		TabFolder tabFolder_1 = new TabFolder(composite_2, SWT.NONE);
		tabFolder_1.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		tabFolder_1.setBackgroundMode(SWT.INHERIT_FORCE);
		tabFolder_1.setBounds(0, 0, 723, 460);
		formToolkit.adapt(tabFolder_1);
		formToolkit.paintBordersFor(tabFolder_1);
		
		TabItem tabItem_1 = new TabItem(tabFolder_1, SWT.NONE);
		tabItem_1.setText("\u6536\u5165\u7C7B");
		
		Composite composite_3 = new Composite(tabFolder_1, SWT.NONE);
		tabItem_1.setControl(composite_3);
		composite_3.setBackgroundMode(SWT.INHERIT_FORCE);
		formToolkit.paintBordersFor(composite_3);
		
		Label lblNewLabel = new Label(composite_3, SWT.NONE);
		lblNewLabel.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel.setBounds(97, 8, 80, 22);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("\u8D77\u59CB\u65E5\u671F\uFF1A");
		
		DateTime dateTime = new DateTime(composite_3, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(183, 6, 88, 24);
		formToolkit.adapt(dateTime);
		formToolkit.paintBordersFor(dateTime);
		
		Label lblNewLabel_1 = new Label(composite_3, SWT.NONE);
		lblNewLabel_1.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(407, 10, 80, 19);
		formToolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("\u7EC8\u6B62\u65E5\u671F\uFF1A");
		
		DateTime dateTime_1 = new DateTime(composite_3, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(509, 10, 88, 24);
		formToolkit.adapt(dateTime_1);
		formToolkit.paintBordersFor(dateTime_1);
		
		CLabel lblNewLabel_8 = new CLabel(composite_3, SWT.NONE);
		lblNewLabel_8.setBounds(151, 96, 406, 305);
		PieDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D(
				"收入类统计图", // 图表标题
				dataset, // 数据集
				true, 	// 是否显示图例
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
		);
		chart.setBackgroundPaint(Color.pink);
		File file = new File("F:\\fruit.jpg");
		try {
			ChartUtilities.saveChartAsPNG(file,chart, 400, 300);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		lblNewLabel_8.setImage(SWTResourceManager.getImage("F:\\fruit.jpg"));
		
		
		
		
		formToolkit.adapt(lblNewLabel_8);
		formToolkit.paintBordersFor(lblNewLabel_8);
		lblNewLabel_8.setText("");
		
		TabItem tbtmNewItem_2 = new TabItem(tabFolder_1, SWT.NONE);
		tbtmNewItem_2.setText("\u652F\u51FA\u7C7B");
		
		Composite composite_4 = new Composite(tabFolder_1, SWT.NONE);
		tbtmNewItem_2.setControl(composite_4);
		formToolkit.paintBordersFor(composite_4);
		
		Label lblNewLabel_2 = new Label(composite_4, SWT.NONE);
		lblNewLabel_2.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_2.setBounds(126, 12, 80, 22);
		formToolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("\u8D77\u59CB\u65F6\u95F4\uFF1A");
		
		DateTime dateTime_2 = new DateTime(composite_4, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_2.setBounds(206, 10, 88, 24);
		formToolkit.adapt(dateTime_2);
		formToolkit.paintBordersFor(dateTime_2);
		
		Label lblNewLabel_3 = new Label(composite_4, SWT.NONE);
		lblNewLabel_3.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_3.setBounds(429, 10, 74, 22);
		formToolkit.adapt(lblNewLabel_3, true, true);
		lblNewLabel_3.setText("\u7EC8\u6B62\u65F6\u95F4\uFF1A");
		
		DateTime dateTime_3 = new DateTime(composite_4, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_3.setBounds(511, 8, 88, 24);
		formToolkit.adapt(dateTime_3);
		formToolkit.paintBordersFor(dateTime_3);
		
		CLabel label_1 = new CLabel(composite_4, SWT.NONE);
		label_1.setBounds(156, 83, 406, 306);
		PieDataset dataset1 = getDataSet1();
		JFreeChart chart1 = ChartFactory.createPieChart3D(
				"支出类统计图", // 图表标题
				dataset, // 数据集
				true, 	// 是否显示图例
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
		);
		chart1.setBackgroundPaint(Color.pink);
		File file1 = new File("F:\\fruit1.jpg");
		try {
			ChartUtilities.saveChartAsPNG(file1,chart1, 400, 300);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		label_1.setImage(SWTResourceManager.getImage("F:\\fruit1.jpg"));
		
		
		
		
		formToolkit.adapt(label_1);
		formToolkit.paintBordersFor(label_1);
		label_1.setText("");
		
		TabItem tbtmNewItem_3 = new TabItem(tabFolder_1, SWT.NONE);
		tbtmNewItem_3.setText("\u5229\u6DA6\u7387");
		
		Composite composite_5 = new Composite(tabFolder_1, SWT.NONE);
		tbtmNewItem_3.setControl(composite_5);
		formToolkit.paintBordersFor(composite_5);
		
		Label lblNewLabel_5 = new Label(composite_5, SWT.NONE);
		lblNewLabel_5.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_5.setBounds(121, 10, 86, 22);
		formToolkit.adapt(lblNewLabel_5, true, true);
		lblNewLabel_5.setText("\u5F00\u59CB\u65E5\u671F\uFF1A");
		
		DateTime dateTime_4 = new DateTime(composite_5, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
		dateTime_4.setBounds(213, 8, 88, 24);
		formToolkit.adapt(dateTime_4);
		formToolkit.paintBordersFor(dateTime_4);
		
		Label lblNewLabel_6 = new Label(composite_5, SWT.NONE);
		lblNewLabel_6.setBackgroundImage(SWTResourceManager.getImage(G财务管理.class, "/pic/\u80CC\u666F1.jpg"));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.BOLD));
		lblNewLabel_6.setBounds(399, 10, 86, 22);
		formToolkit.adapt(lblNewLabel_6, true, true);
		lblNewLabel_6.setText("\u7EC8\u6B62\u65E5\u671F\uFF1A");
		
		DateTime dateTime_5 = new DateTime(composite_5, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
		dateTime_5.setBounds(491, 10, 88, 24);
		formToolkit.adapt(dateTime_5);
		formToolkit.paintBordersFor(dateTime_5);
		
		CLabel label_2 = new CLabel(composite_5, SWT.NONE);
		label_2.setBounds(151, 82, 406, 306);
		CategoryDataset dataset2 = getDataSet2();
		JFreeChart chart2 = ChartFactory.createBarChart3D(
				"利润图", // 图表标题
				"月份", // 目录轴的显示标签
				"产量（公斤）", // 数值轴的显示标签
				dataset2, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, 	// 是否显示图例(对于简单的柱状图必须是false)
				false, 	// 是否生成工具
				false 	// 是否生成URL链接
		);
		chart1.setBackgroundPaint(Color.pink);
		File file2 = new File("F:\\fruit2.jpg");
		try {
			ChartUtilities.saveChartAsPNG(file2,chart2, 400, 300);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		label_2.setImage(SWTResourceManager.getImage("F:\\fruit2.jpg"));
		
		
		
		formToolkit.adapt(label_2);
		formToolkit.paintBordersFor(label_2);
		label_2.setText("");
		//composite_4.setVisible(false);
	}
	
	private static PieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		return dataset;
	}
	
	private static PieDataset getDataSet1() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		return dataset;
	}
	
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(300, "广州", "苹果");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(500, "广州", "香蕉");
		dataset.addValue(400, "广州", "葡萄");
		dataset.addValue(700, "广州", "荔枝");
		return dataset;
	}
}
