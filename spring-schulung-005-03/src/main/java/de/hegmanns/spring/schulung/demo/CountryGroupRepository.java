package de.hegmanns.spring.schulung.demo;

import org.springframework.data.repository.CrudRepository;

public interface CountryGroupRepository extends CrudRepository<CountryGroup, String>{

	CountryGroup findByName(String name);
}
