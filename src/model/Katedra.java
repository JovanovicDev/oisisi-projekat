package model;

import java.util.ArrayList;
import java.util.List;

public class Katedra {
	
	private String id;
	private String name;
	private Profesor chief;
	private List<Profesor> profs;
	
	
	public Katedra() {
		super();
		profs = new ArrayList<Profesor>();
	}


	public Katedra(String id, String name, Profesor chief) {
		super();
		this.id = id;
		this.name = name;
		this.chief = chief;
		profs = new ArrayList<Profesor>();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Profesor getChief() {
		return chief;
	}


	public void setChief(Profesor chief) {
		this.chief = chief;
	}


	public List<Profesor> getProfs() {
		return profs;
	}

}
