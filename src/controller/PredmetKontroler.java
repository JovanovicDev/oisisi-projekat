package controller;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Student;
import view.ProfesoriJTable;
import view.StudentiJTable;
import view.PredmetiJTable;

public class PredmetKontroler {

	private static PredmetKontroler instance = null;
	
	public static PredmetKontroler getInstance() {
		if (instance == null) {
			instance = new PredmetKontroler();
		}
		return instance;
	}
	
	private PredmetKontroler() {}

	public void DodajPredmet(Predmet p) {
		BazaPredmeta.getInstance().dodajPredmet(p);
		PredmetiJTable.azurirajPrikaz("Dodat", -1);
	}
	
	public void izmeniPredmet(Predmet p) {
		if (PredmetiJTable.rowSelectedIndex < 0) {
			return;
		}
		BazaPredmeta.getInstance().izmeniPredmet(p);
		PredmetiJTable.azurirajPrikaz("Azuriran", -1);
	}
	
	public void obrisiPredmet(Predmet p) {
		BazaPredmeta.getInstance().obrisiPredmet(p);
		PredmetiJTable.azurirajPrikaz("Obrisan", -1);
	}
	
}