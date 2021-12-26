package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.ProfesorKontroler;
import controller.StudentKontroler;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import model.Student;

public class MyActionListenerDelete implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(ViewPanel.tabIndex) {
		case 0: 
			if(StudentiJTable.rowSelectedIndex>-1) {
				
				Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
				int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
                		"Da li ste sigurni da zelite da obrisete studenta " + s.getIndex() + " - " + s.getName() + " " + s.getSurname() + "?", 
                		"Potvrda brisanja", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION) {
                	StudentKontroler.getInstance().obrisiStudenta(s);
                } else {
                	return;
                }
				
			}
			break;
		case 1:
			if(ProfesoriJTable.rowSelectedIndex>-1) {
				
				Profesor p = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
				int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), 
                		"Da li ste sigurni da zelite da obrisete profesora " + p.getTitle() + " " + p.getName() + " " + p.getSurname() + "?", 
                		"Potvrda brisanja", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION) {
                	ProfesorKontroler.getInstance().obrisiProfesora(p);
                } else {
                	return;
                }
					 
			}
			
			break;
		default:
			
			break;
		}
				
	}	
	
}