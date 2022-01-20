package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import view.NepolozeniJTable;
import view.PredmetiJTable;

public class BazaNepolozenih extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8038686070866423758L;
	
	private List<Ocena> nepolozeni;
	private List<String> kolone;
	
	public BazaNepolozenih(Student s) {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SEMESTAR");
		
		initNepolozeni(s);

	}
	
	public void initNepolozeni(Student s) {
		this.nepolozeni = s.getFailedExams();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	public void deleteOcena(Ocena o) {
		
		this.nepolozeni.remove(o);
		NepolozeniJTable.azurirajPrikaz("Dodat", -1);
		
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Ocena o = this.nepolozeni.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return o.getSubject().getSubjectID();
		case 1:
			return o.getSubject().getName();
		case 2:
			return o.getSubject().getEspb();
		case 3:
			return o.getSubject().getYear();
		case 4:
			return o.getSubject().getSemester();
		default:
			return 0;
		}
	}
	
	public Ocena getRow(int rowIndex) {
		return this.nepolozeni.get(rowIndex);
		}


	public List<Ocena> getNepolozeni() {
		return nepolozeni;
	}

	public void setNepolozeni(List<Ocena> nepolozeni) {
		this.nepolozeni = nepolozeni;
	}

}
