package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import view.MainFrame;
import view.PredmetiJTable;
import view.ProfesoriJTable;
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
		this.predmeti = new ArrayList<Predmet>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		
		

	}
	public void save() throws IOException {
		int id = 0;
		File f = new File("predmet.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Predmet p : predmeti) {
			pw.write(++id+ ",");
			pw.write(p.getSubjectID()+",");
			pw.write(p.getName()+",");
		    pw.write(p.getYear()+",");
		    pw.write(p.getEspb()+",");
		    if(p.getProf() == null) {
				pw.write("null,");
			} else {
				pw.write(p.getProf().getId()+",");
			}
			pw.write(p.getSemester()+"");
			pw.newLine();

			}
		} finally {
			pw.close();
		}
		
	}
	
	public void load() throws IOException {
		File f = new File("predmet.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String str;
			while((str = reader.readLine()) != null) {
				String[] delovi = str.split(",");
				Predmet p = new Predmet();
				p.setId(Integer.parseInt(delovi[0]));
				p.setSubjectID(delovi[1]);
				p.setName(delovi[2]);
				p.setYear(Integer.parseInt(delovi[3]));
				p.setEspb(Integer.parseInt(delovi[4]));
				for(Profesor p1 : BazaProfesora.getInstance().getProfesori()) {
					if(delovi[5].equals("null")) {
						p.setProf(null);;
					} else if (Integer.parseInt(delovi[5]) == p1.getId()) {
						p.setProf(p1);;
					}
				}
				switch(delovi[6]) {
				case "ZIMSKI":
					p.setSemester(SemesterEnum.ZIMSKI);
					break;
				case "LETNJI":
					p.setSemester(SemesterEnum.LETNJI);
					break;
				default:
					break;
				}
				predmeti.add(p);
			}
		} finally {
			reader.close();
		}
	}
	
	public BazaPredmeta(Profesor p) {
		
		
		

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA");
		this.kolone.add("SEMESTAR");
		
		initPredmeti(p);

	}
	
	
	
	private void initPredmeti(Profesor p) {
		this.predmeti = p.getSubjectsList();
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
				s.setProf(s1.getProf());
			}
		}
		PredmetiJTable.rowSelectedIndex = -1;
	}
	
	public void obrisiPredmet(Predmet p) {
		if(p.getProf()==null) {
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
