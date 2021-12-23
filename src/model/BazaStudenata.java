package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import gui.MainFrame;
import model.Student.StatusEnum;

public class BazaStudenata extends AbstractTableModel {
	

	private static final long serialVersionUID = -7046834571972915803L;
	private static BazaStudenata instance = null;
	
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
		
		studenti.add(new Student("1","Petrovic","Dusan",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-43-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("2","Zlatko","Dusan",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-44-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("3","Zmaj","Dusan",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-144-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("4","Zmaj","Zlatko",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-145-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("5","Zmaj","Aleksa",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-69-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("4","Zmaj","Zlatko",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-169-2019",2020,2,StatusEnum.B,10.00));
		studenti.add(new Student("5","Zmaj","Aleksa",new Date(),new Adresa("ulica",29,"grad","srbija"),"063","email","RA-227-2019",2020,2,StatusEnum.B,10.00));
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
				return student.getEnrollmentYear();
			case 4:
				return student.getStatus();
			case 5:
				return student.getAverageGrade();
			default:
				return null;
			
		}
	}
}
