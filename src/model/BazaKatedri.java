package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import view.PredavaniPredmetiJTable;

public class BazaKatedri extends DefaultComboBoxModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BazaKatedri instance = null;
	
	public static BazaKatedri getInstance() {
		if (instance == null) {
			instance = new BazaKatedri();
		}
		return instance;
	}
	
	private List<Katedra> katedre;
	
	private BazaKatedri() {
		
		initKatedre();
		
	}

	private void initKatedre() {
		this.katedre = new ArrayList<Katedra>();
		
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd.MM.yyyy").parse("27.08.1986");	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		katedre.add(new Katedra("1", "Katedra za elektroniku", new Profesor("Zlatkovic","Jovan",d,new Adresa("Skolska","39","Beograd","Srbija"),"0612133215","zlatkovicjovan@gmail.com",new Adresa("Vojnicka","32","Subotica","Srbija"),"657506348"+ "","Profesor",15)));
		katedre.add(new Katedra("2", "Katedra za elektricna merenja", new Profesor("Markovic","Bata",d,new Adresa("Temerinska","30","Temerin","Srbija"),"0613221315","markovicbata@gmail.com",new Adresa("Zlatarska","72","Sombor","Srbija"),"149924490","Vanredni profesor",12)));
		katedre.add(new Katedra("3", "Katedra za racunarske nauke", new Profesor("Zmajovic","Goran",d,new Adresa("Kninska","12","Cuprija","Srbija"),"0613213215","zmajovicgoran@gmail.com",new Adresa("Srbobranska","96","Aleksandrovac","Srbija"),"768078525","Boca",18)));
		katedre.add(new Katedra("4", "Katedra za automatiku", new Profesor("Borovic","Zlatko",d,new Adresa("Banatska","89","Loznica","Srbija"),"0612211335","boroviczlatko@gmail.com",new Adresa("Pivska","1","Vrsac","Srbija"),"680529925","Gospodin",20)));
		katedre.add(new Katedra("5", "Katedra za racunarske komunikacije", new Profesor("Vujovic","Darko",d,new Adresa("Zlatarska","72","Sombor","Srbija"),"0621121335","vujovicdarko@gmail.com",new Adresa("Temerinska","30","Temerin","Srbija"),"211061702","Docent",19)));
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
