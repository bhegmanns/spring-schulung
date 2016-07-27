package de.hegmanns.spring.schulung.aufgabe.hallowelt;

public class CallUser {

	private String kdnr;
	private String firstName;
	private String lastName;
	
	
	public CallUser(String kdnr, String firstName, String lastName) {
		super();
		this.kdnr = kdnr;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getKdnr() {
		return kdnr;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	
}
