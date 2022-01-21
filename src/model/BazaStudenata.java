package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DeflaterOutputStream;



import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Student.StatusEnum;
import view.MainFrame;
import view.StudentiJTable;

public class BazaStudenata extends AbstractTableModel  {
	

	private static final long serialVersionUID = -7046834571972915803L;
	private static BazaStudenata instance = null;
	public static int gen = 0;
	
	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEX");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		
		initStudenti();

	}
	
	private void initStudenti() {
		
		this.studenti = new ArrayList<Student>();
		
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd.MM.yyyy").parse("25.04.2000");	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		studenti.add(new Student(Integer.toString(++gen),"Petrovic","Dusan",d,new Adresa("Skolska","40","Beograd","Srbija"),"0631569216","petrovicdusan@gmail.com","RA-43-2019",2020,4,StatusEnum.B,9.00));
		studenti.add(new Student(Integer.toString(++gen),"Jovanovic","Aleksandar",d,new Adresa("Radnicka","30","Paracin","Srbija"),"0632115696","jovanovicaleksandar@gmail.com","RA-44-2019",2020,4,StatusEnum.S,8.50));
		studenti.add(new Student(Integer.toString(++gen),"Zindovic","Coban",d,new Adresa("Temerinska","31","Veternik","Srbija"),"0639215616","zindoviccoban@gmail.com","RA-144-2019",2020,4,StatusEnum.B,10.00));
		studenti.add(new Student(Integer.toString(++gen),"Nikolic","Marko",d,new Adresa("Vojnicka","32","Beograd","Srbija"),"0632115696","nikolicmarko@gmail.com","RA-145-2019",2020,4,StatusEnum.B,7.00));
		studenti.add(new Student(Integer.toString(++gen),"Grbic","Vanja",d,new Adresa("Bombaska","33","Uzice","Srbija"),"0631215696","grbicvanja@gmail.com","RA-69-2019",2020,3,StatusEnum.S,8.50));
		studenti.add(new Student(Integer.toString(++gen),"Milic","Mateja",d,new Adresa("Kninska","34","Vrbas","Srbija"),"0635692116","milicmateja@gmail.com","RA-169-2019",2020,2,StatusEnum.B,9.00));
		studenti.add(new Student(Integer.toString(++gen),"Vukasinovic","Lazar",d,new Adresa("Juznobanatska","35","Palanka","Srbija"),"0656931216","vukasinoviclazar@gmail.com","RA-227-2019",2020,2,StatusEnum.B,9.50));
		studenti.add(new Student(Integer.toString(++gen),"Peric","Lana",d,new Adresa("Borska","36","Futog","Srbija"),"0616315692","periclana@gmail.com","RA-48-2019",2020,2,StatusEnum.B,7.80));
		studenti.add(new Student(Integer.toString(++gen),"Kojic","Dragan",d,new Adresa("Zlatarska","37","Ledinci","Srbija"),"0692131566","kojicdragan@gmail.com","RA-49-2019",2020,2,StatusEnum.S,10.00));
		studenti.add(new Student(Integer.toString(++gen),"Tomasevic","Dusan",d,new Adresa("Timocka","38","Beska","Srbija"),"0639211566","tomasevicdragan@gmail.com","RA-148-2019",2020,2,StatusEnum.B,6.00));
		studenti.add(new Student(Integer.toString(++gen),"Markovic","Marko",d,new Adresa("Vojvodjanska","39","Sombor","Srbija"),"0621315696","markovicmarko@gmail.com","RA-149-2019",2020,2,StatusEnum.B,9.00));
		studenti.add(new Student(Integer.toString(++gen),"Rapic","Nikola",d,new Adresa("Gorska","43","Subotica","Srbija"),"0631516692","rapicnikola@gmail.com","RA-269-2019",2020,2,StatusEnum.S,8.50));
		studenti.add(new Student(Integer.toString(++gen),"Gakovic","Sergej",d,new Adresa("Skolska","42","Grad","Aleksandrovac"),"0693156216","gakovicsergej@gmail.com","RA-187-2019",2020,2,StatusEnum.S,10.00));
		studenti.add(new Student(Integer.toString(++gen),"Milisavljevic","Tomislav",d,new Adresa("Sremska","41","Vrsac","Srbija"),"0639211566","milisavljevictoma@gmail.com","RA-201-2019",2020,2,StatusEnum.B,7.00));
	}
	
	public void save() throws IOException {
		
		File f = new File("student1.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Student s : studenti) {
			pw.write(s.getId()+",");
			pw.write(s.getIndex()+",");	
			pw.write(s.getName()+",");
		    pw.write(s.getSurname()+",");
		    pw.write(s.getStudyYear()+",");
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		String strdate = df.format(s.getBirthDate());
			pw.write(strdate+",");
			pw.write(s.getAdress().getId()+",");
			pw.write(s.getPhone()+",");
			pw.write(s.getEmail()+",");
			pw.write(s.getStatus()+",");
			pw.write(s.getEnrollmentYear()+"");
			pw.newLine();

			}
		} finally {
			pw.close();
		}
		
		f = new File("ocena1.txt");
		pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Student s : BazaStudenata.getInstance().getStudenti()) {
					for(Ocena o : s.getPassedExams()) {
				pw.write(o.getStudent().getId()+",");
				pw.write(o.getSubject().getSubjectID()+",");
				pw.write(o.getGrade().getNumVal()+",");
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
				String strdate = df.format(o.getExamDate());
				pw.write(strdate);
				pw.newLine();
					}
			}
		} finally {
			pw.close();
		}
		f = new File("nepolozeni1.txt");
		
		pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Student s : BazaStudenata.getInstance().getStudenti()) {
				for(Ocena o : s.getFailedExams()) {
					pw.write(o.getStudent().getId()+",");
					pw.write(o.getSubject().getSubjectID());	
					pw.newLine();
					}
			}
		} finally {
			pw.close();
		}
		
		
		
	}
	
	public List<Student> getStudenti() {
		return studenti;
		}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
		}
	
	public int getColumnCount() {
		return 5;
		}

	@Override
	public int getRowCount() {
		
		return 0;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public void dodajStudenta(Student s) {
		
		for(Student s1 : studenti) {
			
			if(s1.getIndex().equals(s.getIndex())){
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Studenti moraju da imaju razlicite indexe!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
					return;
			}
			;
		}
		s.setId(Integer.toString(++gen));
		this.studenti.add(s);
	}
	
	public void izmeniStudenta(Student s1) {
		for (Student s : studenti) {
			if (s.getIndex().equals(s1.getIndex())) {
			
				s.setName(s1.getName());
				s.setSurname(s1.getSurname());
				s.setEmail(s1.getEmail());
				s.setEnrollmentYear(s1.getEnrollmentYear());
				s.setAdress(s1.getAdress());
				s.setBirthDate(s1.getBirthDate());
				s.setAverageGrade(s1.getAverageGrade());
				s.setPhone(s1.getPhone());
				s.setStatus(s1.getStatus());
				s.setStudyYear(s1.getStudyYear());
			}
		}
		StudentiJTable.rowSelectedIndex = -1;
	}
	
	public void obrisiStudenta(Student s) {
		studenti.remove(s);
		StudentiJTable.rowSelectedIndex = -1;
	}

	
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
		}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

			Student student = this.studenti.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return student.getIndex();
			case 1:
				return student.getName();
			case 2:
				return student.getSurname();
			case 3:
				return student.getStudyYear();
			case 4:
				return student.getStatus();
			case 5:
				return student.getAverageGrade();
			default:
				return null;
			
		}
	}
}
