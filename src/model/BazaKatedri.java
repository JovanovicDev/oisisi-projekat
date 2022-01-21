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



public class BazaKatedri {


	private static BazaKatedri instance = null;
	
	public static BazaKatedri getInstance() {
		if (instance == null) {
			instance = new BazaKatedri();
		}
		return instance;
	}
	
	private List<Katedra> katedre;
	
	private BazaKatedri() {
		this.katedre = new ArrayList<Katedra>();
		
	}


	public void save() throws IOException {
		
		int gen = 0;
		File f = new File("katedra.txt");
		BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		try {
			for(Katedra k : katedre) {
			pw.write(++gen+",");
			pw.write(k.getId()+",");	
			pw.write(k.getName()+",");
			if(k.getChief() == null) {
				pw.write("null");
			} else {
				pw.write(k.getChief().getId()+"");
			}
			pw.newLine();

			}
		} finally {
			pw.close();
		}
		
		
	}
	
	public void load() throws IOException {
		this.katedre = new ArrayList<Katedra>();
		File f = new File("katedra.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String str;
			while(( str = reader.readLine()) != null) {
				String[] delovi = str.split(",");
				Katedra k = new Katedra();
				k.setID(Integer.parseInt(delovi[0]));
				k.setId(delovi[1]);
				k.setName(delovi[2]);
				for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
					if(p.getId() == Integer.parseInt(delovi[3])) {
						k.setChief(p);
						
					}
				}
				katedre.add(k);
			}
		} finally {
			reader.close();
		}
	}

	public List<Katedra> getKatedre() {
		return katedre;
	}

	public void setKatedre(List<Katedra> katedre) {
		this.katedre = katedre;
	}

	public void postaviSefaKatedre(Katedra k, Profesor p) {
		
		for(Katedra k1 : katedre) {
			
			if(k1.getId().equals(k.getId())) {
				k1.setChief(p);
			}
		}
	}
	
}
