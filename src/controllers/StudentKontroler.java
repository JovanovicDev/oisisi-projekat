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
	
	public void izmeniStudenta(Student s) {
		if (StudentiJTable.rowSelectedIndex < 0) {
			return;
		}
		BazaStudenata.getInstance().izmeniStudenta(s);
		StudentiJTable.azurirajPrikaz("Azuriran", -1);
	}
	
	
	
	
	
}
