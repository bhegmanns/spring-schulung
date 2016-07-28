package de.hegmanns.spring.schulung.aufgabe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendee {

	@Id
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "country_name")
	private CountryGroup countryGroup;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CountryGroup getCountryGroup() {
		return countryGroup;
	}

	public void setCountryGroup(CountryGroup countryGroup) {
		this.countryGroup = countryGroup;
	}
	
	
}
