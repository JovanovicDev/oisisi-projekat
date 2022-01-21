package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import model.BazaKatedri;
import model.BazaProfesora;
import model.Katedra;
import model.Ocena;
import model.Profesor;

public class KatedraDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static List<Profesor> listaSvihProfesora;
	public static List<Profesor> listaProfesora;
	
	public KatedraDialog() {
		super();
		setModal(true);
		setTitle("Katedre");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(400, 300);
		setLocationRelativeTo(null);
				
		JLabel katedraLbl = new JLabel("Katedre: ");
		JComboBox<Katedra> katedraCmb = new JComboBox<Katedra>();
		katedraCmb.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, katedraLbl, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, katedraLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, katedraCmb, 160, SpringLayout.WEST, katedraLbl);
		layout.putConstraint(SpringLayout.NORTH, katedraCmb, -5, SpringLayout.NORTH, katedraLbl);
		
		List<Katedra> listaKatedri = BazaKatedri.getInstance().getKatedre();
		for(Katedra k : listaKatedri) {
			katedraCmb.addItem(k);
		}
		
		JLabel profesorLbl = new JLabel("Profesori: ");
		JComboBox<Profesor> profesorCmb = new JComboBox<Profesor>();
		profesorCmb.setPreferredSize(new Dimension(150,30));
		layout.putConstraint(SpringLayout.NORTH, profesorLbl, 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, profesorLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, profesorCmb, 160, SpringLayout.WEST, profesorLbl);
		layout.putConstraint(SpringLayout.NORTH, profesorCmb, -5, SpringLayout.NORTH, profesorLbl);
	
		listaSvihProfesora = BazaProfesora.getInstance().getProfesori();
		listaProfesora = new ArrayList<Profesor>();
		for(Profesor p : listaSvihProfesora) {
			if((p.getTitle().equals("Profesor") || p.getTitle().equals("Vanredni profesor")) && p.getYearsOfService() >= 5) {
				listaProfesora.add(p);
				profesorCmb.addItem(p);
			}
		}
		
		JButton snimiBtn = new JButton("Snimi");
		snimiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda snimanja", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION) {
                	Katedra k = (Katedra)katedraCmb.getSelectedItem();
                	System.out.println(k.getName());
                	Profesor p = (Profesor)profesorCmb.getSelectedItem();
                	BazaKatedri.getInstance().postaviSefaKatedre(k, p);
                	JOptionPane.showMessageDialog(
							null, 
						   "Profesor " + profesorCmb.getSelectedItem() + " je postavljen za sefa " + katedraCmb.getSelectedItem() + ".", 
						    "Uspesna akcija",
						    JOptionPane.INFORMATION_MESSAGE); 
                	dispose();
                }
			}
		});
		
		JButton odustaniBtn = new JButton("Odustani");
		odustaniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		layout.putConstraint(SpringLayout.NORTH, snimiBtn, 170, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, snimiBtn, 100, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 100, SpringLayout.WEST, snimiBtn);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 0, SpringLayout.NORTH, snimiBtn);
		
		add(katedraLbl);
		add(katedraCmb);
		add(profesorLbl);
		add(profesorCmb);
		add(snimiBtn);
		add(odustaniBtn);
		setVisible(true);
	}

}
