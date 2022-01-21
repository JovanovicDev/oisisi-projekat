package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import view.PredmetiJTable;
import view.ProfesoriJTable;
import view.StudentiJTable;
import model.Ocena.GradeEnum;
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
	public void save() throws IOException {
		int id = 0;
		File f = new File("predmet1.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Predmet p : predmeti) {
			pw.write(++id+ ",");
			pw.write(p.getSubjectID()+",");
			pw.write(p.getName()+",");
		    pw.write(p.getYear()+",");
		    pw.write(p.getEspb()+",");
			pw.write(p.getProf().getId()+",");
			pw.write(p.getSemester()+"");
			pw.newLine();

			}
		} finally {
			pw.close();
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
	
	private void initPredmeti() {
		
		this.predmeti = new ArrayList<Predmet>();
		
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd.MM.yyyy").parse("27.08.1986");	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		predmeti.add(new Predmet("1","Matematika",SemesterEnum.LETNJI,2,new Profesor("Zlatkovic","Jovan",d,new Adresa("Skolska","39","Beograd","Srbija"),"0612133215","zlatkovicjovan@gmail.com",new Adresa("Vojnicka","32","Subotica","Srbija"),"657506348"+ "","Doca",15),6));
		predmeti.add(new Predmet("2","Srpski",SemesterEnum.LETNJI,2,new Profesor("Markovic","Bata",d,new Adresa("Temerinska","30","Temerin","Srbija"),"0613221315","markovicbata@gmail.com",new Adresa("Zlatarska","72","Sombor","Srbija"),"149924490","Docent",12),6));
		predmeti.add(new Predmet("3","Algebra",SemesterEnum.LETNJI,2,new Profesor("Zmajovic","Goran",d,new Adresa("Kninska","12","Cuprija","Srbija"),"0613213215","zmajovicgoran@gmail.com",new Adresa("Srbobranska","96","Aleksandrovac","Srbija"),"768078525","Boca",18),6));
		predmeti.add(new Predmet("4","Hemija",SemesterEnum.LETNJI,3,new Profesor("Borovic","Zlatko",d,new Adresa("Banatska","89","Loznica","Srbija"),"0612211335","boroviczlatko@gmail.com",new Adresa("Pivska","1","Vrsac","Srbija"),"680529925","Gospodin",20),6));
		predmeti.add(new Predmet("5","Muzicko",SemesterEnum.LETNJI,2,new Profesor("Simic","Marko",d,new Adresa("Gorska","37","Vrbas","Srbija"),"0613212135","simicmarko@gmail.com",new Adresa("Kninska","1","Grad","Srbija"),"797962484","Majstor",12),3));
		predmeti.add(new Predmet("6","Arhitektura",SemesterEnum.LETNJI,2,new Profesor("Marovic","Bogdan",d,new Adresa("Pivska","1","Vrsac","Srbija"),"0632112135","marovicbogdan@gmail.com",new Adresa("Gorska","37","Vrbas","Srbija"),"181714190","Poglavar",5),6));
		predmeti.add(new Predmet("7","Analiza",SemesterEnum.LETNJI,2,new Profesor("Soric","Filip",d,new Adresa("Srbobranska","96","Aleksandrovac","Srbija"),"0611521332","soricfilip@gmail.com",new Adresa("Kninska","12","Cuprija","Srbija"),"209133592","Maestro",7),6));
		predmeti.add(new Predmet("8","Fizicko",SemesterEnum.ZIMSKI,4,new Profesor("Vujovic","Darko",d,new Adresa("Zlatarska","72","Sombor","Srbija"),"0621121335","vujovicdarko@gmail.com",new Adresa("Temerinska","30","Temerin","Srbija"),"211061702","Docent",19),3));
		predmeti.add(new Predmet("9","Fizika",SemesterEnum.ZIMSKI,4,new Profesor("Zlatkovic","Jovan",d,new Adresa("Skolska","39","Beograd","Srbija"),"0612133215","zlatkovicjovan@gmail.com",new Adresa("Vojnicka","32","Subotica","Srbija"),"657506348"+ "","Doca",15),6));
		
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
		if(p.getProf().getName().equals("")) {
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
