package view;

import javax.swing.JDialog;
import javax.swing.SpringLayout;

public class AboutDialog extends JDialog {
	

	private static final long serialVersionUID = 2566945927276159128L;

	public AboutDialog() {
		super();
		setModal(true);
		setTitle("O projektu");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 300);
		setLocationRelativeTo(null);
	
		
		
		
		setVisible(true);
	}
}
