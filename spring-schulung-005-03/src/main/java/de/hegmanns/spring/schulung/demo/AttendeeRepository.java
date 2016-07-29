package de.hegmanns.spring.schulung.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository<Attendee, String>{

	Attendee findByUsernameAndPassword(String username, String password);
	List<Attendee> findByCountryGroup(CountryGroup countryGroup);
}
