package de.hegmanns.spring.schulung.aufgabe;

import de.hegmanns.spring.schulung.aufgabe.entity.CountryGroup;

public interface CountryGroupRepository {

	CountryGroup getByCountryName(String countryName);
	void addCountry(CountryGroup countryGroup);
}
