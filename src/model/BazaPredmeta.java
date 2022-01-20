package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import view.MainFrame;
import view.PredmetiJTable;
import view.ProfesoriJTable;
import view.StudentiJTable;
import model.Predmet.SemesterEnum;

public class BazaPredmeta extends AbstractTableModel{

	private static final long serialVersionUID = 6330596085326878785L;
	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmeta() {
		
	
	

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		
		initPredmeti();

	}
	
	private void initPredmeti() {
		
		this.predmeti = new ArrayList<Predmet>();
		
		predmeti.add(new Predmet("1","Matematika",SemesterEnum.summer,2,null,6));
		predmeti.add(new Predmet("2","Srpski",SemesterEnum.summer,2,null,6));
		predmeti.add(new Predmet("3","Fizika",SemesterEnum.winter,2,new Profesor(),6));
		predmeti.add(new Predmet("4","Hemija",SemesterEnum.summer,2,new Profesor(),6));
		predmeti.add(new Predmet("5","Muzicko",SemesterEnum.summer,2,null,3));
		predmeti.add(new Predmet("6","Fizicko",SemesterEnum.winter,2,null,3));
		
	}
	public List<Predmet> getPredmeti() {
		return predmeti;
		}
	
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
		}
	
	public int getColumnCount() {
		return 4;
		}
	@Override
	public int getRowCount() {
		
		return 0;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public void dodajPredmet(Predmet p) {
	
		for(Predmet s1 : predmeti) {
			
			if(s1.getSubjectID().equals(p.getSubjectID())){
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Predmeti moraju da imaju razlicite sifre!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
					return;
			}
			;
		}
		this.predmeti.add(p);
	}
	
	public void izmeniPredmet(Predmet s1) {
		for (Predmet s : predmeti) {
			if (s.getSubjectID().equals(s1.getSubjectID())) {
				s.setName(s1.getName());
				s.setEspb(s1.getEspb());
				s.setYear(s1.getYear());
				s.setSemester(s1.getSemester());
			}
		}
		PredmetiJTable.rowSelectedIndex = -1;
	}
	
	public void obrisiPredmet(Predmet p) {
		if(p.getProf() == null) {
			predmeti.remove(p);
			ProfesoriJTable.rowSelectedIndex = -1;
		}
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

			Predmet p = this.predmeti.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getSubjectID();
			case 1:
				return p.getName();
			case 2:
				return p.getEspb();
			case 3:
				return p.getYear();
			case 4:
				return p.getSemester();
			default:
				return null;
			
		}
	}
	
	
	

}
