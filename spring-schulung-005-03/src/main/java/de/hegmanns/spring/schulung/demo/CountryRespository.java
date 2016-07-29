package de.hegmanns.spring.schulung.demo;

import java.util.List;

public interface CountryRespository {

	List<Attendee> findByGroup(String groupName);
	void add(CountryGroup countryGroup);
}
