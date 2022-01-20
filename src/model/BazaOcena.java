package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import view.NepolozeniJTable;

public class BazaOcena extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3201856542698285898L;
	private List<Ocena> ocene;
	private List<String> kolone;
	
	public BazaOcena(Student s) {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("ESPB");
		this.kolone.add("OCENA");
		this.kolone.add("DATUM");
		
		initOcene(s);

	}
	
	public void initOcene(Student s) {
		this.ocene = s.getPassedExams();
	}
	
	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
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
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	public void dodajOcenu(Ocena o) {
		this.ocene.add(o);
		NepolozeniJTable.azurirajPrikaz("Dodat", -1);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Ocena o = this.ocene.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return o.getSubject().getSubjectID();
		case 1:
			return o.getSubject().getName();
		case 2:
			return o.getSubject().getEspb();
		case 3:
			return o.getGrade().getNumVal();
		case 4:
			return o.getExamDate();
		default:
			return 0;

	}
}

}
