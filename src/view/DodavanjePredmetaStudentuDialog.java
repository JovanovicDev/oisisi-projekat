package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class DodavanjePredmetaStudentuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DodavanjePredmetaStudentuDialog() {
		
		super();
		setModal(true);
		setTitle("Dodavanje predmeta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		
		JScrollPane panel = new JScrollPane();
		panel.setPreferredSize(new Dimension(300,200));
		layout.putConstraint(SpringLayout.NORTH, panel, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panel, 43, SpringLayout.WEST, this);
		this.add(panel);
		
		JButton dodajBtn = new JButton("Dodaj");
		layout.putConstraint(SpringLayout.NORTH, dodajBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dodajBtn, 80, SpringLayout.WEST, this);
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		this.add(dodajBtn);
		
		JButton odustaniBtn = new JButton("Odustani");
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 225, SpringLayout.WEST, this);
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		this.add(odustaniBtn);
		
		setVisible(true);
	}
}
