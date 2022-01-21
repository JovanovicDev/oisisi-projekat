package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import model.BazaPredmeta;
import model.Ocena;
import model.Predmet;
import model.Student;

public class DodavanjePredmetaStudentuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JList<Predmet> listaSvihPredmeta;
	public static List<Predmet> listaPolozenihINepolozenih;
	public static List<Predmet> lista2;
	public static List<Predmet> lista3;
	public static DefaultListModel<Predmet> dlm;
	public static int index = -1;
	
	public DodavanjePredmetaStudentuDialog(Student s) {
		
		super();
		setModal(true);
		setTitle("Dodavanje predmeta");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		listaPolozenihINepolozenih = new ArrayList<Predmet>();
		dlm = new DefaultListModel<Predmet>();
		for(Ocena o : s.getPassedExams()) {
			listaPolozenihINepolozenih.add(o.getSubject());
		}
		for(Ocena o : s.getFailedExams()) {
			listaPolozenihINepolozenih.add(o.getSubject());
		}
		lista3 = new ArrayList<Predmet>();
		lista2 = BazaPredmeta.getInstance().getPredmeti();
		
		for(Predmet p : lista2) {
			for(Predmet p1 : listaPolozenihINepolozenih) {
				if(p.getSubjectID().equals(p1.getSubjectID())) {
					lista3.add(p);
				}
			}
		}
		
		lista2.removeAll(lista3);
		int i = 0;
		for(Predmet p : lista2) {
			if(s.getStudyYear() >= p.getYear()) {
				dlm.add(i++, p);
			}
		}

		listaSvihPredmeta = new JList<Predmet>(dlm);
		JScrollPane panel = new JScrollPane(listaSvihPredmeta);
		panel.setPreferredSize(new Dimension(300,200));
		layout.putConstraint(SpringLayout.NORTH, panel, 40, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panel, 43, SpringLayout.WEST, this);
		this.add(panel);
		
		JButton dodajBtn = new JButton("Dodaj");
		layout.putConstraint(SpringLayout.NORTH, dodajBtn, 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, dodajBtn, 80, SpringLayout.WEST, this);
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = listaSvihPredmeta.getSelectedIndex();
				if(index == -1) JOptionPane.showMessageDialog(new JPanel(), "Nesto iz liste mora biti odabrano.", "Warning",
				        JOptionPane.WARNING_MESSAGE);
				else {
					Predmet p = listaSvihPredmeta.getSelectedValue();
					AbstractTableModelNepolozeni.bo.dodajNepolozen(p);
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
