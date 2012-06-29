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

import uml.middleclass.Table;
import uml.middleclass.TableGroup;

public class Ôö¼Ó×À×Ó {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ôö¼Ó×À×Ó window = new Ôö¼Ó×À×Ó();
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
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(Ôö¼Ó×À×Ó.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(215, 243);
		shell.setText("Ôö¼Ó²Í×À");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label.setBounds(30, 23, 61, 27);
		label.setText("\u9910\u684C\u53F7\uFF1A");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label_2.setBounds(10, 85, 80, 27);
		label_2.setText("\u6240\u5728\u533A\u57DF\uFF1A");

		text = new Text(shell, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
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
		text.setBounds(97, 24, 96, 23);

		final Combo combo = new Combo(shell, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(96, 86, 96, 25);
		List<TableGroup> tablegroups = TableGroup.getTablegroups();
		String []content = new String[tablegroups.size()];
		for(int i=0;i<tablegroups.size();i++){
			content[i] = tablegroups.get(i).getCategory();
		}
		combo.setItems(content);
		combo.select(0);
		
		final Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		lblNewLabel.setBounds(97, 53, 112, 23);
		lblNewLabel.setText("\u8BE5\u684C\u5B50\u53F7\u5DF2\u5B58\u5728\uFF01");
		lblNewLabel.setVisible(false);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				uml.middleclass.Table searchtable = uml.middleclass.Table.search(Integer.parseInt(text.getText()));
				if(searchtable == null){
					List<TableGroup> tablegroups_1 = TableGroup.getTablegroups();
					for (int i = 0; i < tablegroups_1.size(); i++) {
						if(tablegroups_1.get(i).getCategory().equals(combo.getText())){
							Table table = new Table(Integer.parseInt(text.getText()),tablegroups_1.get(i),"EMPTY" );
							table.save();
						}
					}
					shell.close();
				}else{
					lblNewLabel.setVisible(true);
				}			
			}
		});
		button.setBounds(10, 155, 80, 27);
		button.setText("\u786E\u8BA4");

		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(113, 155, 80, 27);
		button_1.setText("\u53D6\u6D88");
	}
}
