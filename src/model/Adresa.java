package model;

public class Adresa {
	
	private String street;
	private int number;
	private String city;
	private String country;
	
	public Adresa() {
		super();
	}

	public Adresa(String street, int number, String city, String country) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}