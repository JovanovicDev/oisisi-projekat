package controller;

import model.BazaProfesora;
import model.Profesor;
import view.ProfesoriJTable;

public class ProfesorKontroler {

	private static ProfesorKontroler instance = null;
	
	public static ProfesorKontroler getInstance() {
		if (instance == null) {
			instance = new ProfesorKontroler();
		}
		return instance;
	}
	
	private ProfesorKontroler() {}
	
	public void DodajProfesora(Profesor p) {
		
		BazaProfesora.getInstance().dodajProfesora(p);
		ProfesoriJTable.azurirajPrikaz("Dodat", -1);

	}
	
	public void izmeniProfesora(Profesor p) {
		if (ProfesoriJTable.rowSelectedIndex < 0) {
			return;
		}
		BazaProfesora.getInstance().izmeniProfesora(p);
		ProfesoriJTable.azurirajPrikaz("Azuriran", -1);
	}
	
	public void obrisiProfesora(Profesor p) {
		BazaProfesora.getInstance().obrisiProfesora(p);
		ProfesoriJTable.azurirajPrikaz("Obrisan", -1);
	}
	
}
