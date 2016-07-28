package de.hegmanns.spring.schulung.aufgabe;

import java.util.List;

import de.hegmanns.spring.schulung.aufgabe.entity.Attendee;
import de.hegmanns.spring.schulung.aufgabe.entity.CountryGroup;

public interface AttendeeRepository {

	public void add(Attendee attendee);
	public Attendee getByNameAndPassword(String name, String password);
	
	public List<Attendee> getByCountry(String countryName);
	public List<Attendee> getByCountry(CountryGroup countryGroup);
}
