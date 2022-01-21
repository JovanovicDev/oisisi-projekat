package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class AboutDialog extends JDialog {
	
	public AboutDialog() {
		super();
		setModal(true);
		setTitle("O projektu");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(500, 250);
		setLocationRelativeTo(null);
	
		String text = "Aplikacija je namenjena da opiše rad studentske službe Fakulteta tehničkih nauka. \n"
				+ "Verzija 1.0 \n"
				+ "Autori: Aleksa Zindović RA-43/2019 i Dušan Jovanović RA-144/2019"; 

		JTextArea box = new JTextArea(text);
		box.setEditable(false);
		box.setPreferredSize(new Dimension(500,250));
		add(box);
		
		setVisible(true);
	}
}
