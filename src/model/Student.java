package model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Student {

	public enum StatusEnum{B,S};
	private int id;
	private String surname;
	private String name;
	private Date birthDate;
	private Adresa adress;
	private String phone;
	private String email;
	private String index;
	private int enrollmentYear;
	private int studyYear;
	private StatusEnum status;
	private Double averageGrade;
	private List<Ocena> passedExams;
	private List<Ocena> failedExams;
	
	public Student() {
		super();
		passedExams = new ArrayList<Ocena>();
		failedExams = new ArrayList<Ocena>();
	}
	
	public Student(int id, String surname, String name, Date birthDate, Adresa adress, String phone, String email,
			String index, int enrollmentYear, int studyYear, StatusEnum status, Double averageGrade) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.index = index;
		this.enrollmentYear = enrollmentYear;
		this.studyYear = studyYear;
		this.status = status;
		this.averageGrade = averageGrade;
		passedExams = new ArrayList<Ocena>();
		failedExams = new ArrayList<Ocena>();	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Adresa getAdress() {
		return adress;
	}

	public void setAdress(Adresa adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getEnrollmentYear() {
		return enrollmentYear;
	}

	public void setEnrollmentYear(int enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Ocena> getPassedExams() {
		return passedExams;
	}

	public List<Ocena> getFailedExams() {
		return failedExams;
	}

}
