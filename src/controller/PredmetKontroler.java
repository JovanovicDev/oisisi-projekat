package controller;

import model.BazaPredmeta;
import model.Predmet;
import view.ProfesoriJTable;
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

	public void obrisiPredmet(Predmet p) {
		BazaPredmeta.getInstance().obrisiPredmet(p);
		PredmetiJTable.azurirajPrikaz("Obrisan", -1);
	}
	
}