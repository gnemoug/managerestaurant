package uml.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class ±¸×¢ {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private String content;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			±¸×¢ window = new ±¸×¢();
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
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(±¸×¢.class, "/pic/zhuozi4.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage(±¸×¢.class, "/pic/\u80CC\u666F0.jpg"));
		shell.setSize(369, 267);
		shell.setText("±¸×¢");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		lblNewLabel.setBounds(42, 28, 61, 22);
		lblNewLabel.setText("\u540D\u79F0\uFF1A");

		text = new Text(shell, SWT.READ_ONLY);
		text.setBounds(109, 28, 73, 23);

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.BOLD));
		label.setBounds(42, 75, 61, 22);
		label.setText("\u5907\u6CE8\uFF1A");

		text_1 = new Text(shell, SWT.BORDER | SWT.MULTI);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(109, 75, 199, 57);
		

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				content = text_1.getText();
				shell.close();
			}
		});
		btnNewButton.setBounds(117, 174, 80, 27);
		btnNewButton.setText("\u786E\u8BA4");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		btnNewButton_1.setBounds(228, 174, 80, 27);
		btnNewButton_1.setText("\u53D6\u6D88");

	}
	
	public String getContent(){
		return content;
	}
}
