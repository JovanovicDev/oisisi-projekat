package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Profesor {

	private String surname;
	private String name;
	private Date birthDate;
	private Adresa adress;
	private String phone;
	private String email;
	private Adresa officeAdress;
	private String numberID;
	private String title;
	private int yearsOfService;
	private List<Predmet> subjectsList ;
	
	
	public Profesor() {
		super();
	}


	public Profesor(String surname, String name, Date birthDate, Adresa adress, String phone, String email,
			Adresa officeAdress, String numberID, String title, int yearsOfService) {
		super();
		this.surname = surname;
		this.name = name;
		this.birthDate = birthDate;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.officeAdress = officeAdress;
		this.numberID = numberID;
		this.title = title;
		this.yearsOfService = yearsOfService;
		subjectsList = new ArrayList<Predmet>();
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


	public Adresa getOfficeAdress() {
		return officeAdress;
	}


	public void setOfficeAdress(Adresa officeAdress) {
		this.officeAdress = officeAdress;
	}


	public String getNumberID() {
		return numberID;
	}


	public void setNumberID(String numberID) {
		this.numberID = numberID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYearsOfService() {
		return yearsOfService;
	}


	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}


	public List<Predmet> getSubjectsList() {
		return subjectsList;
	}
}
