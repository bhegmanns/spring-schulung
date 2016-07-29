package de.hegmanns.spring.schulung.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AttendeeRepository extends CrudRepository<Attendee, String>{

	Attendee findByUsernameAndPassword(String username, String password);
	List<Attendee> findByCountryGroup(CountryGroup countryGroup);
	
//	@Query("select count(a) from Attendee a where a.firstName.startWith(:usernameStartWith)")
//	int getCount(String usernameStartWith);
//	
//	@Query("select new Customer(c.username) from Attendee c where ... ")
//	Custumer findCustomer(String username, String password);
}
