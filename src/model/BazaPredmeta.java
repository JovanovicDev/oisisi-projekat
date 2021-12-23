package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

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
		
		predmeti.add(new Predmet("1","Matematika",SemesterEnum.summer,2,new Profesor(),6));
		predmeti.add(new Predmet("2","Srpski",SemesterEnum.summer,2,new Profesor(),6));
		predmeti.add(new Predmet("3","Matematika",SemesterEnum.winter,2,new Profesor(),6));
		
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