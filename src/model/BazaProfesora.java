package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import view.ViewPanel;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.MainFrame;
import view.PredavaniPredmetiJTable;
import view.ProfesoriJTable;

public class BazaProfesora extends AbstractTableModel {
	
	
	private static final long serialVersionUID = -8615026166189637882L;
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<String> kolone;

	
	private BazaProfesora() {
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("E-MAIL");
		
		initProfesori();
		
		
	}
	
	private void initProfesori() {
		
		this.profesori = new ArrayList<Profesor>();
		
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd.MM.yyyy").parse("27.08.1986");	
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		profesori.add(new Profesor("Zlatkovic","Jovan",d,new Adresa("Skolska",39,"Beograd","Srbija"),"0612133215","zlatkovicjovan@gmail.com",new Adresa("Vojnicka",32,"Subotica","Srbija"),"657506348"+ "","Doca",15));
		profesori.add(new Profesor("Markovic","Bata",d,new Adresa("Temerinska",30,"Temerin","Srbija"),"0613221315","markovicbata@gmail.com",new Adresa("Zlatarska",72,"Sombor","Srbija"),"149924490","Docent",12));
		profesori.add(new Profesor("Zmajovic","Goran",d,new Adresa("Kninska",12,"Cuprija","Srbija"),"0613213215","zmajovicgoran@gmail.com",new Adresa("Srbobranska",96,"Aleksandrovac","Srbija"),"768078525","Boca",18));
		profesori.add(new Profesor("Borovic","Zlatko",d,new Adresa("Banatska",89,"Loznica","Srbija"),"0612211335","boroviczlatko@gmail.com",new Adresa("Pivska",1,"Vrsac","Srbija"),"680529925","Gospodin",20));
		profesori.add(new Profesor("Simic","Marko",d,new Adresa("Gorska",37,"Vrbas","Srbija"),"0613212135","simicmarko@gmail.com",new Adresa("Kninska",1,"Grad","Srbija"),"797962484","Majstor",12));
		profesori.add(new Profesor("Marovic","Bogdan",d,new Adresa("Pivska",1,"Vrsac","Srbija"),"0632112135","marovicbogdan@gmail.com",new Adresa("Gorska",37,"Vrbas","Srbija"),"181714190","Poglavar",5));
		profesori.add(new Profesor("Soric","Filip",d,new Adresa("Srbobranska",96,"Aleksandrovac","Srbija"),"0611521332","soricfilip@gmail.com",new Adresa("Kninska",12,"Cuprija","Srbija"),"209133592","Maestro",7));
		profesori.add(new Profesor("Vujovic","Darko",d,new Adresa("Zlatarska",72,"Sombor","Srbija"),"0621121335","vujovicdarko@gmail.com",new Adresa("Temerinska",30,"Temerin","Srbija"),"211061702","Docent",19));
		profesori.add(new Profesor("Filipovic","Stevan",d,new Adresa("Vojnicka",32,"Subotica","Srbija"),"0611213325","filipovicstevan@gmail.com",new Adresa("Skolska",39,"Beograd","Srbija"),"517201783","Doca",8));
		
		
	}

	public List<Profesor> getProfesori() {
		return profesori;
		}
	
	public void setProfesori(List<Profesor> studenti) {
		this.profesori = studenti;
		}
	
	public int getColumnCount() {
		return 3;
		}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public void dodajProfesora(Profesor p) {
		
		for(Profesor p1 : profesori) {
			
			if(p1.getNumberID().equals(p.getNumberID())){
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Profesori moraju da imaju razlicite brojeve licnih karti!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
					return;
			}
			
		}
		this.profesori.add(p);
	}
	
	public void izmeniProfesora(Profesor p1) {
		for (Profesor p : profesori) {
			if (p.getNumberID().equals(p1.getNumberID())) {
			
				p.setName(p1.getName());
				p.setSurname(p1.getSurname());
				p.setEmail(p1.getEmail());
				p.setTitle(p1.getTitle());
				p.setAdress(p1.getAdress());
				p.setBirthDate(p1.getBirthDate());
				p.setYearsOfService(p1.getYearsOfService());
				p.setPhone(p1.getPhone());
				p.setOfficeAdress(p1.getOfficeAdress());
	
			}
		}
		ProfesoriJTable.rowSelectedIndex = -1;
	}
	
	
	public void obrisiProfesora(Profesor p) {
		profesori.remove(p);
		ProfesoriJTable.rowSelectedIndex = -1;
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	public void dodajPredmetProfesoru(Profesor p,Predmet pred) {
		
		for(Profesor profesor : profesori) {
			
			if(profesor.getNumberID().equals(p.getNumberID())) {
				
				profesor.getSubjectsList().add(pred);
			}
		}
		PredavaniPredmetiJTable.azurirajPrikaz("Dodat", -1);
	}
	public void skiniPredmeProfesoru(Profesor p,Predmet pred) {
		
		for(Profesor profesor : profesori) {
			
			if(profesor.getNumberID().equals(p.getNumberID())) {
				
				profesor.getSubjectsList().remove(pred);
			}
		}
		PredavaniPredmetiJTable.azurirajPrikaz("Uklonjen", -1);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

			Profesor p = this.profesori.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getName();
			case 1:
				return p.getSurname();
			case 2:
				return p.getTitle();
			case 3:
				return p.getEmail();
			default:
				return null;
			
		}
	}
}
