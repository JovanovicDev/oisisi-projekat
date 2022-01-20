package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.BazaStudenata;
import model.Ocena;
import model.Ocena.GradeEnum;
import model.Student;


public class UnosOceneDialog extends JDialog {

	private static final long serialVersionUID = -2576061086827011956L;
	
	public UnosOceneDialog(Ocena o,Student s) {
		super();
		setModal(true);
		setTitle("Unos ocene");
		setResizable(false);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(300, 330);
		setLocationRelativeTo(null);
		
		JLabel sifraLbl = new JLabel("Sifra*");
		JTextField sifraTxt = new JTextField();
		sifraTxt.setPreferredSize(new Dimension(90,25));
		sifraTxt.setText(o.getSubject().getSubjectID());
		sifraTxt.setEditable(false);
		
		layout.putConstraint(SpringLayout.NORTH, sifraLbl, 45, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, sifraLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, sifraTxt, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, sifraTxt, 40, SpringLayout.NORTH, this);
		
		add(sifraLbl);
		add(sifraTxt);
		JLabel nazivLbl = new JLabel("Naziv*");
		JTextField nazivTxt = new JTextField();
		nazivTxt.setPreferredSize(new Dimension(90,25));
		nazivTxt.setText(o.getSubject().getName());
		nazivTxt.setEditable(false);
		
		layout.putConstraint(SpringLayout.NORTH, nazivLbl, 85, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nazivLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, nazivTxt, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, nazivTxt, 80, SpringLayout.NORTH, this);
		add(nazivLbl);
		add(nazivTxt);
		
		
		JLabel ocenaLbl = new JLabel("Ocena*");
		JComboBox<Integer> comboOcena = new JComboBox<Integer>();
		comboOcena.setPreferredSize(new Dimension(90,25));
		comboOcena.addItem(6);comboOcena.addItem(7);comboOcena.addItem(8);comboOcena.addItem(9);comboOcena.addItem(10);
		layout.putConstraint(SpringLayout.NORTH, ocenaLbl, 125, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, ocenaLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, comboOcena, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, comboOcena, 120, SpringLayout.NORTH, this);
		add(ocenaLbl);
		add(comboOcena);
		
		
		JLabel datumLbl = new JLabel("Datum*");
		JTextField datumTxt = new JTextField();
		datumTxt.setPreferredSize(new Dimension(90,25));
		
		layout.putConstraint(SpringLayout.NORTH, datumLbl, 165, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, datumLbl, 40, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, datumTxt, 150, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, datumTxt, 160, SpringLayout.NORTH, this);
		
		add(datumLbl);
		add(datumTxt);
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");
		
		layout.putConstraint(SpringLayout.NORTH, potvrdiBtn, 205, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, potvrdiBtn, 55, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, odustaniBtn, 145, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, odustaniBtn, 205, SpringLayout.NORTH, this);
		
		add(potvrdiBtn);
		add(odustaniBtn);
		
		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboOcena.getSelectedIndex()==0) o.setGrade(GradeEnum.SEST);
				if(comboOcena.getSelectedIndex()==1) o.setGrade(GradeEnum.SEDAM);
				if(comboOcena.getSelectedIndex()==2) o.setGrade(GradeEnum.OSAM);
				if(comboOcena.getSelectedIndex()==3) o.setGrade(GradeEnum.DEVET);
				if(comboOcena.getSelectedIndex()==4) o.setGrade(GradeEnum.DESET);
				try {
					Date d = new SimpleDateFormat("dd.MM.yyyy").parse(datumTxt.getText());
					o.setExamDate(d);	
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(new JPanel(), "Format datuma je dd.MM.yyyy .", "Warning",
					        JOptionPane.WARNING_MESSAGE);
				}
				
				AbstractTableModelNepolozeni.bo.deleteOcena(o);
				AbstractTableModelPolozeni.bo.dodajOcenu(o);
				BazaStudenata.getInstance().dodavanjeOcene(s,o);
				BazaStudenata.getInstance().brisanjeNepolozenog(s,o);
				
				
				
				
			}

		});
		
		setVisible(true);
	}

}
