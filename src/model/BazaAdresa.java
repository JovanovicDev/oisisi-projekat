package model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

		
	}
	
	public void save() throws IOException {
		
		
		File f = new File("adresa.txt");
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

	public void load() throws IOException {
		this.adrese = new ArrayList<Adresa>();
		File f = new File("adresa.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String str;
			while(( str = reader.readLine()) != null) {
				String[] delovi = str.split(",");
				Adresa a = new Adresa();
				a.setId(Integer.parseInt(delovi[0]));
				a.setStreet(delovi[1]);
				a.setNumber(delovi[2]);
				a.setCity(delovi[3]);
				a.setCountry(delovi[4]);
				adrese.add(a);
			}
		} finally {
			reader.close();
		}
	}
	
	public void dodajAdresu(Adresa a) {
		adrese.add(a);
		
	}
	
	public void izmeniAdresu(Adresa a) {
		
		for(Adresa a1 : adrese) {
			if(a1.getId() == a.getId()) {
				
				a1.setCity(a.getCity());
				a1.setStreet(a.getStreet());
				a1.setCountry(a.getCountry());
				a1.setNumber(a.getNumber());
			}
		}
	}
	public List<Adresa> getAdrese() {
		return adrese;
	}
	

	public void setAdrese(List<Adresa> adrese) {
		this.adrese = adrese;
	}


	
}
