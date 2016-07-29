package de.hegmanns.spring.schulung.aufgabe;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class OlympicRegistrationService {

	@Resource(name = "attendeeRepositoryImpl")
	private AttendeeRepository attendeeRepository;
	
	private CountryGroupRepository countryGroupRepository;
	
	public void registerForOlympicGames(String firstName, String lastName, String countryName){
		
	}
}
