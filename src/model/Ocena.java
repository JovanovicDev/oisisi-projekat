package model;

import java.util.Date;

public class Ocena {
	
	public enum GradeEnum {
		
		PET(5),SEST(6),SEDAM(7),OSAM(8),DEVET(9),DESET(10);
		
		private int numVal;
		
		private GradeEnum(int numVal){
			this.numVal= numVal;
		}
		
		public int getNumVal() {
			return numVal;
		}
	};
	private Student student;
	private Predmet subject;
	private GradeEnum grade;
	private Date examDate;
	
	public Ocena() {
		super();
	}

	public Ocena(Student student, Predmet subject, GradeEnum grade, Date examDate) {
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

	public GradeEnum getGrade() {
		return grade;
	}

	public void setGrade(GradeEnum grade) {
		this.grade = grade;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
}
