package model;

import java.util.List;

enum Semester_enum {summer,winter };

public class Predmet {
	
	
	private String subjectID;
	private String name;
	private Semester_enum semester; 
	private int year;
	private Profesor prof;
	private int espb;
	private List<Student> passedStudents;
	private List<Student> failedStudents;
	
	
	public Predmet() {
		super();
	}


	public Predmet(String subjectID, String name, Semester_enum semester, int year, Profesor prof, int espb) {
		super();
		this.subjectID = subjectID;
		this.name = name;
		this.semester = semester;
		this.year = year;
		this.prof = prof;
		this.espb = espb;
	}


	public String getSubjectID() {
		return subjectID;
	}


	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Semester_enum getSemester() {
		return semester;
	}


	public void setSemester(Semester_enum semester) {
		this.semester = semester;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Profesor getProf() {
		return prof;
	}


	public void setProf(Profesor prof) {
		this.prof = prof;
	}


	public int getEspb() {
		return espb;
	}


	public void setEspb(int espb) {
		this.espb = espb;
	}

}
