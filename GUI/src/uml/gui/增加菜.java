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

public class Ôö¼Ó²Ë {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			 Ôö¼Ó²Ë window = new  Ôö¼Ó²Ë();
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
		shell.setImage(SWTResourceManager.getImage(Ôö¼Ó²Ë.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Ôö¼Ó²Ë.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(283, 354);
		shell.setText("²Ë");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_1.setBounds(31, 20, 61, 27);
		label_1.setText("\u83DC\u540D\u79F0\uFF1A");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setBounds(44, 74, 48, 27);
		lblNewLabel.setText("\u7C7B\u522B\uFF1A");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_2.setBounds(44, 122, 48, 27);
		label_2.setText("\u552E\u4EF7\uFF1A");

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_3.setBounds(44, 167, 48, 27);
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
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setVisible(false);
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(101, 242, 86, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_1.setBounds(101, 17, 86, 23);
		
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(99, 73, 88, 25);
		List<DishGroup> dishgroups_1 = uml.middleclass.DishGroup.getAllDishGroups();
		String []contents_1 = new String[dishgroups_1.size()];
		for(int i=0;i<dishgroups_1.size();i++){
			contents_1[i] = dishgroups_1.get(i).getCategory();
		}
		combo.setItems(contents_1);
		combo.select(0);
		
		text_2 = new Text(shell, SWT.BORDER);
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
		text_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_2.setBounds(99, 121, 88, 23);

		text_3 = new Text(shell, SWT.BORDER);
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
		text_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_3.setBounds(98, 166, 89, 23);

		text_4 = new Text(shell, SWT.BORDER);
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
		text_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		text_4.setBounds(98, 212, 89, 23);
		
		final Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		lblNewLabel_1.setBounds(99, 245, 88, 17);
		lblNewLabel_1.setText("\u8BE5\u83DC\u5DF2\u5B58\u5728\uFF01");
		lblNewLabel_1.setVisible(false);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_2.setBounds(193, 122, 61, 27);
		lblNewLabel_2.setText("\u5143");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(Dish.search(text_1.getText())){
					lblNewLabel_1.setVisible(true);
				}else{
					text.setText(toJP(text_1.getText()));
					Dish dish = new Dish(new DishGroup(combo.getText()),text_1.getText(), Float.valueOf(text_2.getText()), text.getText(), Integer.parseInt(text_4.getText()), text_3.getText());
					dish.save();
					shell.close();
				}
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

