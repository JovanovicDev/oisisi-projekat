package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import view.MainFrame;
import view.PredavaniPredmetiJTable;
import view.ProfesoriJTable;

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
		this.profesori = new ArrayList<Profesor>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("E-MAIL");
		
		
		
		
	}
	
	
	public void save() throws IOException {
		
		File f = new File("profesor.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Profesor p : profesori) {
			pw.write(p.getId()+",");
			pw.write(p.getNumberID()+",");	
			pw.write(p.getName()+",");
		    pw.write(p.getSurname()+",");
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		    String strdate = df.format(p.getBirthDate());
			pw.write(strdate+",");
			pw.write(p.getAdress().getId()+",");
			pw.write(p.getPhone()+",");
			pw.write(p.getEmail()+",");
			pw.write(p.getOfficeAdress().getId()+",");
			pw.write(p.getYearsOfService()+",");
			pw.write(p.getTitle());
			pw.newLine();

			}
		} finally {
			pw.close();
		}
		
	}
	
	public void load() throws IOException {
		this.profesori = new ArrayList<Profesor>();
		File f = new File("profesor.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String str;
			while((str = reader.readLine()) != null) {
				String[] delovi = str.split(",");
				Profesor p = new Profesor();
				p.setId(Integer.parseInt(delovi[0]));
				p.setNumberID(delovi[1]);
				p.setName(delovi[2]);
				p.setSurname(delovi[3]);
				Date d;
				try {
					d = new SimpleDateFormat("dd.MM.yyyy.").parse(delovi[4]);
					p.setBirthDate(d);	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Adresa a : BazaAdresa.getInstance().getAdrese()) {
					if(delovi[5].equals("null")) {
						p.setAdress(null);
					} else if (Integer.parseInt(delovi[5]) == a.getId()) {
						p.setAdress(a);
					}
				}
				p.setPhone(delovi[6]);
				p.setEmail(delovi[7]);
				for(Adresa a : BazaAdresa.getInstance().getAdrese()) {
					if(delovi[8].equals("null")) {
						p.setAdress(null);
					} else if (Integer.parseInt(delovi[8]) == a.getId()) {
						p.setOfficeAdress(a);
					}
				}
				p.setYearsOfService(Integer.parseInt(delovi[9]));
				p.setTitle(delovi[10]);
			    profesori.add(p);
			}
		} finally {
			reader.close();
		}
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
		ProfesoriJTable.rowSelectedIndex = -1;
	}
	
	
	public void obrisiProfesora(Profesor p) {
		profesori.remove(p);
		ProfesoriJTable.rowSelectedIndex = -1;
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public void dodajPredmetProfesoru(Profesor p,Predmet pred) {
		
		for(Profesor profesor : profesori) {
			
			if(profesor.getNumberID().equals(p.getNumberID())) {
				
				profesor.getSubjectsList().add(pred);
			}
		}
		PredavaniPredmetiJTable.azurirajPrikaz("Dodat", -1);
	}
	
	public void skiniPredmeProfesoru(Profesor p,Predmet pred) {
		
		for(Profesor profesor : profesori) {
			
			if(profesor.getNumberID().equals(p.getNumberID())) {
				
				profesor.getSubjectsList().remove(pred);
			}
		}
		PredavaniPredmetiJTable.azurirajPrikaz("Uklonjen", -1);
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
