package de.hegmanns.spring.schulung.aufgabe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryGroup {

	@Id
	private String name;
	
	private String countryCode;
	
	private String teamManagerFirstName;
	private String teamManagerSecondName;
	
	@Column(unique = true)
	private String teamManagerUsername;
	private String teamManagerPassword;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getTeamManagerFirstName() {
		return teamManagerFirstName;
	}
	public void setTeamManagerFirstName(String teamManagerFirstName) {
		this.teamManagerFirstName = teamManagerFirstName;
	}
	public String getTeamManagerSecondName() {
		return teamManagerSecondName;
	}
	public void setTeamManagerSecondName(String teamManagerSecondName) {
		this.teamManagerSecondName = teamManagerSecondName;
	}
	public String getTeamManagerUsername() {
		return teamManagerUsername;
	}
	public void setTeamManagerUsername(String teamManagerUsername) {
		this.teamManagerUsername = teamManagerUsername;
	}
	public String getTeamManagerPassword() {
		return teamManagerPassword;
	}
	public void setTeamManagerPassword(String teamManagerPassword) {
		this.teamManagerPassword = teamManagerPassword;
	}
	
	
}
