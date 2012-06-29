package uml.gui;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import uml.middleclass.Dish;
import uml.middleclass.DishGroup;


public class ÐÞ¸Ä²Ë {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	private String dishGroup;
	private String name;
	private String unitPrice;
	private String jinpin;
	private String currentInventory;
	private String unitgroup;
	private Text text;
	
	public ÐÞ¸Ä²Ë(String dishGroup,String name,String unitPrice,String jinpin,String currentInventory,String unitgroup){
		setCurrentInventory(currentInventory);
		setDishGroup(dishGroup);
		setJinpin(jinpin);
		setName(name);
		setUnitgroup(unitgroup);
		setUnitPrice(unitPrice);
	}
	
	/**
	 * 
	 * @return currentInventory
	 */
	public String getCurrentInventory() {
		return currentInventory;
	}
	/**
	 * 
	 * @param currentInventory
	 */
	public void setCurrentInventory(String currentInventory) {
		this.currentInventory = currentInventory;
	}
	/**
	 * 
	 * @return dishGroup
	 */
	public String getDishGroup() {
		return dishGroup;
	}
	/**
	 * 
	 * @param dishGroup
	 */
	public void setDishGroup(String dishGroup) {
		this.dishGroup = dishGroup;
	}
	/**
	 * 
	 * @return jinpin
	 */
	public String getJinpin() {
		return jinpin;
	}
	/**
	 * 
	 * @param jinpin
	 */
	public void setJinpin(String jinpin) {
		this.jinpin = jinpin;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return unitgroup
	 */
	public String getUnitgroup() {
		return unitgroup;
	}
	/**
	 * 
	 * @param unitgroup
	 */
	public void setUnitgroup(String unitgroup) {
		this.unitgroup = unitgroup;
	}
	/**
	 * 
	 * @return unitPrice
	 */
	public String getUnitPrice() {
		return unitPrice;
	}
	/**
	 * 
	 * @param unitPrice
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ÐÞ¸Ä²Ë  window = new ÐÞ¸Ä²Ë("ÈÈ°è²Ë", "¼¦×¦", "12.4", "jt", "45", "Ã¶");
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
		shell.setImage(SWTResourceManager.getImage(ÐÞ¸Ä²Ë.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(ÐÞ¸Ä²Ë.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(283, 354);
		shell.setText("²Ë");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_1.setBounds(31, 17, 61, 27);
		label_1.setText("\u83DC\u540D\u79F0\uFF1A");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setBounds(44, 66, 48, 27);
		lblNewLabel.setText("\u7C7B\u522B\uFF1A");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_2.setBounds(44, 112, 48, 27);
		label_2.setText("\u552E\u4EF7\uFF1A");

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_3.setBounds(44, 160, 48, 27);
		label_3.setText("\u5355\u4F4D\uFF1A");

		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_4.setBounds(44, 212, 48, 27);
		label_4.setText("\u5E93\u5B58\uFF1A");

		Button button = new Button(shell, SWT.NONE);
		button.setBounds(31, 281, 80, 27);
		button.setText("\u786E\u8BA4");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(143, 281, 80, 27);
		button_1.setText("\u53D6\u6D88");

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_1.setBounds(101, 14, 86, 23);
		text_1.setText(getName());
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(98, 65, 88, 25);
		List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
		String []contents_1 = new String[dishgroups_1.size()];
		for(int i=0;i<dishgroups_1.size();i++){
			contents_1[i] = dishgroups_1.get(i).getCategory();
		}
		combo.setItems(contents_1);
		combo.setText(getDishGroup());
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_2.setBounds(99, 111, 88, 23);
		text_2.setText(getUnitPrice());
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
		
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_3.setBounds(98, 159, 89, 23);
		text_3.setText(getUnitgroup());
		text_3.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]"); 
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
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_4.setBounds(98, 212, 89, 23);
		text_4.setText(getCurrentInventory());
		text_4.addVerifyListener(new VerifyListener() {
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
		
		text = new Text(shell, SWT.BORDER);
		text.setVisible(false);
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(108, 241, 86, 23);
		text.setText(getJinpin());
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u5143");
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_5.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		label_5.setBounds(193, 112, 61, 27);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(toJP(text_1.getText()));
				Dish.update(getName(), new Dish(new DishGroup(combo.getText()), text_1.getText(), Float.valueOf(text_2.getText()), text.getText(), Integer.parseInt(text_4.getText()), text_3.getText()));
				shell.close();
			}
		});
	}
	public static String toJP(String c){
	    
	     char[] chars = c.toCharArray();
	    
	     StringBuffer sb = new StringBuffer("");
	    
	     for(int i=0;i<chars.length;i++){
	      sb.append(getJP(chars[i]));
	     }
	    
	     return sb.toString();
	  }
	 
	public static String getJP(char c){
		  byte[] array = new byte[2];
	      array = String.valueOf(c).getBytes();
	     
	     if(array.length<2)return String.valueOf(c);
	              int i = (short)(array[0] - '\0' + 256) * 256 + ((short)(array[1] - '\0' + 256));
	              if ( i < 0xB0A1) return String.valueOf(c);
	              if ( i < 0xB0C5) return "a";
	              if ( i < 0xB2C1) return "b";
	              if ( i < 0xB4EE) return "c";
	              if ( i < 0xB6EA) return "d";
	              if ( i < 0xB7A2) return "e";
	              if ( i < 0xB8C1) return "f";
	              if ( i < 0xB9FE) return "g";
	              if ( i < 0xBBF7) return "h";
	              if ( i < 0xBFA6) return "j";
	              if ( i < 0xC0AC) return "k";
	              if ( i < 0xC2E8) return "l";
	              if ( i < 0xC4C3) return "m";
	              if ( i < 0xC5B6) return "n";
	              if ( i < 0xC5BE) return "o";
	              if ( i < 0xC6DA) return "p";
	              if ( i < 0xC8BB) return "q";
	              if ( i < 0xC8F6) return "r";
	              if ( i < 0xCBFA) return "s";
	              if ( i < 0xCDDA) return "t";
	              if ( i < 0xCEF4) return "w";
	              if ( i < 0xD1B9) return "x";
	              if ( i < 0xD4D1) return "y";
	              if ( i < 0xD7FA) return "z";
	              return String.valueOf(c);
	      }
}
