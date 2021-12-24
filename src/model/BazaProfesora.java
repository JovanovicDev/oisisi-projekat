package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import view.MainFrame;

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
		
		profesori.add(new Profesor("Zlatkovic","Zlatko",new Date(),new Adresa("T",29,"C","M"),"061","@gmail.com",new Adresa("A",29,"C","M"),"1","Doca",5));
		profesori.add(new Profesor("Markovic","Zlatko",new Date(),new Adresa("K",30,"C","M"),"061","@gmail.com",new Adresa("B",28,"D","M"),"2","Docent",5));
		profesori.add(new Profesor("Zmajovic","Zlatko",new Date(),new Adresa("K",1,"C","M"),"061","@gmail.com",new Adresa("C",31,"G","M"),"3","Boca",5));
		
		
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
	
	public void dodajProfesora(Profesor p) {
		
		for(Profesor p1 : profesori) {
			
			if(p1.getNumberID().equals(p.getNumberID())){
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Profesori moraju da imaju razlicite brojeve licnih karti!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
					return;
			}
			
		}
		this.profesori.add(p);
	}
	
	public void izmeniProfesora(Profesor p1) {
		for (Profesor p : profesori) {
			if (p.getNumberID().equals(p1.getNumberID())) {
			
				p.setName(p1.getName());
				p.setSurname(p1.getSurname());
				p.setEmail(p1.getEmail());
				p.setTitle(p1.getTitle());
				p.setAdress(p1.getAdress());
				p.setBirthDate(p1.getBirthDate());
				p.setYearsOfService(p1.getYearsOfService());
				p.setPhone(p1.getPhone());
				p.setOfficeAdress(p1.getOfficeAdress());
	
			}
		}
	}
	
	//Profesor(String surname, String name, Date birthDate, Adresa adress, String phone, String email,
	//Adresa officeAdress, String numberID, String title, int yearsOfService)
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
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
