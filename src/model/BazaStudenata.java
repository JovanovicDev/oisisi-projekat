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

import model.Ocena.GradeEnum;
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
		this.studenti = new ArrayList<Student>();
		this.kolone.add("INDEX");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");
		

	}
	
	
	public void save() throws IOException {
		
		File f = new File("student.txt");
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
			if(s.getAdress() == null) {
				pw.write("null,");
			} else {
				pw.write(s.getAdress().getId()+",");
			}
			pw.write(s.getPhone()+",");
			pw.write(s.getEmail()+",");
			pw.write(s.getStatus()+",");
			pw.write(s.getEnrollmentYear()+"");
			pw.newLine();

			}
		} finally {
			pw.close();
		}
		
		f = new File("ocena.txt");
		pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Student s : BazaStudenata.getInstance().getStudenti()) {
					for(Ocena o : s.getPassedExams()) {
				pw.write(o.getStudent().getId()+",");
				pw.write(o.getSubject().getId()+",");
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
		f = new File("nepolozeni.txt");
		
		pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Student s : BazaStudenata.getInstance().getStudenti()) {
				for(Ocena o : s.getFailedExams()) {
					pw.write(o.getStudent().getId()+",");
					pw.write(o.getSubject().getId()+"");	
					pw.newLine();
					}
			}
		} finally {
			pw.close();
		}
	}
	
	public void load() throws IOException {
		this.studenti = new ArrayList<Student>();
		File f = new File("student.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String str;
			while((str = reader.readLine()) != null) {
				String[] delovi = str.split(",");
				Student s = new Student();
				s.setId(Integer.parseInt(delovi[0]));
				s.setIndex(delovi[1]);
				s.setName(delovi[2]);
				s.setSurname(delovi[3]);
				s.setStudyYear(Integer.parseInt(delovi[4]));
				Date d;
				try {
					d = new SimpleDateFormat("dd.MM.yyyy.").parse(delovi[5]);
					s.setBirthDate(d);	
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Adresa a : BazaAdresa.getInstance().getAdrese()) {
					if(delovi[6].equals("null")) {
						s.setAdress(null);
					} else if (Integer.parseInt(delovi[6]) == a.getId()) {
						s.setAdress(a);
					}
				}
				s.setPhone(delovi[7]);
				s.setEmail(delovi[8]);
				switch(delovi[9]) {
					case "B":
						s.setStatus(StatusEnum.B);
						break;
					case "S":
						s.setStatus(StatusEnum.S);
						break;
					default:
						break;
				}
				s.setEnrollmentYear(Integer.parseInt(delovi[10]));
				studenti.add(s);
			}
		} finally {
			reader.close();
		}
			f = new File("nepolozeni.txt");
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			try {
				String str;
				while((str = reader.readLine()) != null) {
					String[] delovi = str.split(",");
					Ocena o = new Ocena();
					for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
						if(p.getId() == Integer.parseInt(delovi[1])) {
							o.setSubject(p);
						}
					}
					for(Student s : BazaStudenata.getInstance().getStudenti()) {
						if(s.getId() == Integer.parseInt(delovi[0])) {
							o.setStudent(s);
							s.getFailedExams().add(o);
						}
					}
					
				}
			} finally {
				reader.close();
			}
			
			f = new File("ocena.txt");
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			try {
				String str;
				while((str = reader.readLine()) != null) {
					String[] delovi = str.split(",");
					Ocena o = new Ocena();
					switch(delovi[2]) {
					case "6":
						o.setGrade(GradeEnum.SEST);
						break;
					case "7":
						o.setGrade(GradeEnum.SEDAM);
						break;
					case "8":
						o.setGrade(GradeEnum.OSAM);
						break;
					case "9":
						o.setGrade(GradeEnum.DEVET);
						break;
					case "10":
						o.setGrade(GradeEnum.DESET);
						break;
					default:
						break;
					}
					Date d;
					try {
						d = new SimpleDateFormat("dd.MM.yyyy.").parse(delovi[3]);
						o.setExamDate(d);;	
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
						if(p.getId() == Integer.parseInt(delovi[1])) {
							o.setSubject(p);
						}
					}
					for(Student s : BazaStudenata.getInstance().getStudenti()) {
						if(s.getId() == Integer.parseInt(delovi[0])) {
							o.setStudent(s);
							s.getPassedExams().add(o);
						}
					}
					
				}
				racunajProsek();
			} finally {
				reader.close();
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
		this.studenti.add(s);
	}
	
	public void racunajProsek() {
		
		for(Student s: studenti) {
			double suma = 0.0;
			for(Ocena o : s.getPassedExams()) {
				
				suma += o.getGrade().getNumVal();
				
			}
			if(suma/s.getPassedExams().size()>=6 &&  suma/s.getPassedExams().size()<= 10)
			s.setAverageGrade(suma/s.getPassedExams().size());
			else s.setAverageGrade(0.0);
		}
	  StudentiJTable.azurirajPrikaz("-1", 1);
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
