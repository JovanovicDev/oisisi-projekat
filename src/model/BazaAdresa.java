package model;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BazaAdresa {


	private static BazaAdresa instance = null;
	
	public static BazaAdresa getInstance() {
		if (instance == null) {
			instance = new BazaAdresa();
		}
		return instance;
	}
	
	private List<Adresa> adrese;
	
	private BazaAdresa() {
		adrese = new ArrayList<Adresa>();
		adrese.add(new Adresa("Tolstojeva","31","Grad","Drzava"));
		adrese.add(new Adresa("Tolstojeva","31","Grad","Drzava"));
		
	}
	
	public void save() throws IOException {
		
		
		File f = new File("adresa1.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Adresa a : adrese) {
			pw.write(a.getId()+",");
			pw.write(a.getStreet()+",");	
			pw.write(a.getNumber()+",");
		    pw.write(a.getCity()+",");
		    pw.write(a.getCountry());
			pw.newLine();

			}
		} finally {
			pw.close();
		}	
	}

	public List<Adresa> getAdrese() {
		return adrese;
	}

	public void setAdrese(List<Adresa> adrese) {
		this.adrese = adrese;
	}


	
}
