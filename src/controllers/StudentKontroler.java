package controllers;

import gui.StudentiJTable;
import model.BazaStudenata;
import model.Student;

public class StudentKontroler {

	
	private static StudentKontroler instance = null;
	
	public static StudentKontroler getInstance() {
		if (instance == null) {
			instance = new StudentKontroler();
		}
		return instance;
	}
	
	private StudentKontroler() {}
	
	public void DodajStudenta(Student s) {
		BazaStudenata.getInstance().dodajStudenta(s);
		StudentiJTable.azurirajPrikaz("Dodat", -1);
	}
	
	
	
	
}
