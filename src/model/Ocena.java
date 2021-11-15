package model;

import java.util.Date;

enum Grade_enum {
	
	SEST(6),SEDAM(7),OSAM(8),DEVET(9),DESET(10);
	
	private int numVal;
	
	Grade_enum(int numVal){
		this.numVal= numVal;
	}
};


public class Ocena {
	
	private Student student;
	private Predmet subject;
	private Grade_enum grade;
	private Date examDate;
	
	public Ocena() {
		super();
	}

	public Ocena(Student student, Predmet subject, Grade_enum grade, Date examDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.grade = grade;
		this.examDate = examDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getSubject() {
		return subject;
	}

	public void setSubject(Predmet subject) {
		this.subject = subject;
	}

	public Grade_enum getGrade() {
		return grade;
	}

	public void setGrade(Grade_enum grade) {
		this.grade = grade;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
}
