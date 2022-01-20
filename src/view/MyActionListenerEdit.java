package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;

public class MyActionListenerEdit implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(ViewPanel.tabIndex) {
		case 0: 
			if(StudentiJTable.rowSelectedIndex>-1) {
				
				Student s = BazaStudenata.getInstance().getRow(StudentiJTable.rowSelectedIndex);
				 new StudentDialog(s.getId(),s.getSurname(),s.getName(),s.getBirthDate(),s.getAdress(),s.getPhone()
						,s.getEmail(),s.getIndex(),s.getEnrollmentYear(),s.getStudyYear(),s.getStatus(),s.getAverageGrade());
								
			}
			break;
		case 1:
			if(ProfesoriJTable.rowSelectedIndex>-1) {
				
				Profesor b = BazaProfesora.getInstance().getRow(ProfesoriJTable.rowSelectedIndex);
				 new ProfesorDialog(b.getSurname(),b.getName(),b.getBirthDate(),b.getAdress(),b.getPhone()
						,b.getEmail(),b.getOfficeAdress(),b.getNumberID(),b.getTitle(),b.getYearsOfService());
					 
			}
			
			break;
		default:
			if(ProfesoriJTable.rowSelectedIndex>-1) {
				
				Predmet b = BazaPredmeta.getInstance().getRow(PredmetiJTable.rowSelectedIndex);
				 new PredmetDialog(b.getSubjectID(),b.getName(),b.getSemester(),b.getYear(),b.getProf(),b.getEspb());
					 
			}
			break;
		}		
		
	}
		
}
