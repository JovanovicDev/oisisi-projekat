package model;

import java.util.ArrayList;
import java.util.List;

public class Predmet {
	
	public enum SemesterEnum {summer,winter };
	private String subjectID;
	private String name;
	private SemesterEnum semester; 
	private int year;
	private Profesor prof;
	private int espb;
	private List<Student> passedStudents;
	private List<Student> failedStudents;
	
	
	public Predmet() {
		super();
		passedStudents = new ArrayList<Student>();
		failedStudents = new ArrayList<Student>();
	}


	public Predmet(String subjectID, String name, SemesterEnum semester, int year, Profesor prof, int espb) {
		super();
		this.subjectID = subjectID;
		this.name = name;
		this.semester = semester;
		this.year = year;
		this.prof = prof;
		this.espb = espb;
		passedStudents = new ArrayList<Student>();
		failedStudents = new ArrayList<Student>();
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


	public SemesterEnum getSemester() {
		return semester;
	}


	public void setSemester(SemesterEnum semester) {
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


	public List<Student> getPassedStudents() {
		return passedStudents;
	}

	public List<Student> getFailedStudents() {
		return failedStudents;
	}
	

	@Override
	public String toString() {
		return subjectID + " - " + name;
	}
	
	
}
