package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;

public class DodavanjePredmetaProfesoruDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JList<Predmet> listaPredmeta;
	public static List<Predmet> listaPredavanihPredmeta;
	public static List<Predmet> lista2;
	public static List<Predmet> lista3;
	public static DefaultListModel<Predmet> dlm;
	public static int index = -1;
	
	public DodavanjePredmetaProfesoruDialog(Profesor p) {
		
		super();
		setModal(true);
		setTitle("Dodaj predmet");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		JLabel predmetiLbl = new JLabel("Predmeti:");
		layout.putConstraint(SpringLayout.NORTH, predmetiLbl, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, predmetiLbl, 43, SpringLayout.WEST, this);
		this.add(predmetiLbl);
		
		listaPredavanihPredmeta = new ArrayList<Predmet>();
		dlm = new DefaultListModel<Predmet>();
		for(Predmet p1 : p.getSubjectsList()) {
			listaPredavanihPredmeta.add(p1);
		}
		lista2 = BazaPredmeta.getInstance().getPredmeti();
		lista3 = new ArrayList<Predmet>();
		for(Predmet p1 : lista2) {
			for(Predmet p2 : listaPredavanihPredmeta) {
				if(p1.getSubjectID().equals(p2.getSubjectID())) {
					lista3.add(p1);
				}
			}
		}
		lista2.removeAll(lista3);
		dlm.addAll(lista2);
		
		listaPredmeta = new JList<Predmet>(dlm);
		JScrollPane panel = new JScrollPane(listaPredmeta);
		panel.setPreferredSize(new Dimension(300,200));
		layout.putConstraint(SpringLayout.NORTH, panel, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panel, 43, SpringLayout.WEST, this);
		this.add(panel);
		
		JButton dodajBtn = new JButton("Dodaj");
		layout.putConstraint(SpringLayout.NORTH, dodajBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dodajBtn, 80, SpringLayout.WEST, this);
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = listaPredmeta.getSelectedIndex();
				if(index == -1) JOptionPane.showMessageDialog(new JPanel(), "Nesto iz liste mora biti odabrano.", "Warning",
				        JOptionPane.WARNING_MESSAGE);
				else {
					Predmet pred = listaPredmeta.getSelectedValue();
					AbstractTableModelPredavaniPredmeti.bprof.dodajPredmetProfesoru(p, pred);
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
				dispose();
			}
		});
		this.add(odustaniBtn);
		
		setVisible(true);
	}
}
