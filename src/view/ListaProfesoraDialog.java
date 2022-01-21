package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class ListaProfesoraDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	public static JList<Profesor> listaProfesora;
	public static DefaultListModel<Profesor> dlm;
	public static int index = -1;
	
	public ListaProfesoraDialog(Predmet p) {
		
		super();
		setModal(true);
		setTitle("Odaberi profesora");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 400);
		setLocationRelativeTo(null);
		
	   dlm = new DefaultListModel<Profesor>();
	   dlm.addAll(BazaProfesora.getInstance().getProfesori());

		listaProfesora = new JList<Profesor>(dlm);
		JScrollPane panel = new JScrollPane(listaProfesora);
		panel.setPreferredSize(new Dimension(300,200));
		layout.putConstraint(SpringLayout.NORTH, panel, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panel, 43, SpringLayout.WEST, this);
		this.add(panel);
		
		JButton dodajBtn = new JButton("Potvrdi");
		layout.putConstraint(SpringLayout.NORTH, dodajBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dodajBtn, 80, SpringLayout.WEST, this);
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				index = listaProfesora.getSelectedIndex();
				if(index == -1) JOptionPane.showMessageDialog(new JPanel(), "Nesto iz liste mora biti odabrano.", "Warning",
				        JOptionPane.WARNING_MESSAGE);
				else {
					PredmetDialog.proff = listaProfesora.getSelectedValue();
					PredmetDialog.profTxt.setText(PredmetDialog.proff.getName() + " " +PredmetDialog.proff.getSurname());
					dispose();
				}
	
			}
		});
		this.add(dodajBtn);
		
		JButton odustaniBtn = new JButton("Odustani");
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 225, SpringLayout.WEST, this);
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PredmetDialog.profTxt.setText("");
				PredmetDialog.proff = new Profesor();
				dispose();
				
			}
				
			
		});
		this.add(odustaniBtn);
		
		setVisible(true);
	}
	
}
