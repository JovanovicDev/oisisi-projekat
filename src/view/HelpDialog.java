package view;

import javax.swing.JDialog;
import javax.swing.SpringLayout;

public class HelpDialog extends JDialog {

	public HelpDialog() {
		super();
		setModal(true);
		setTitle("Pomoc");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		
		
		
		setVisible(true);
	}
}
