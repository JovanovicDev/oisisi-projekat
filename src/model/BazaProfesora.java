package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BazaProfesora extends AbstractTableModel {
	
	
	private static final long serialVersionUID = -8615026166189637882L;
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("E-MAIL");
		
		initProfesori();
		
		
	}
	
	private void initProfesori() {
		
		this.profesori = new ArrayList<Profesor>();
		
		profesori.add(new Profesor("Zlatkovic","Zlatko",new Date(),new Adresa(),"061","@gmail.com",new Adresa(),"1","Doca",5));
		profesori.add(new Profesor("Markovic","Zlatko",new Date(),new Adresa(),"061","@gmail.com",new Adresa(),"1","Docent",5));
		profesori.add(new Profesor("Zmajovic","Zlatko",new Date(),new Adresa(),"061","@gmail.com",new Adresa(),"1","Boca",5));
		
		
	}

	public List<Profesor> getProfesori() {
		return profesori;
		}
	
	public void setProfesori(List<Profesor> studenti) {
		this.profesori = studenti;
		}
	
	public int getColumnCount() {
		return 3;
		}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

			Profesor p = this.profesori.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getName();
			case 1:
				return p.getSurname();
			case 2:
				return p.getTitle();
			case 3:
				return p.getEmail();
			default:
				return null;
			
		}
	}

}
