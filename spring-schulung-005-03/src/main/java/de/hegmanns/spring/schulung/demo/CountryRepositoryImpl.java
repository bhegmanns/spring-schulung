package de.hegmanns.spring.schulung.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class CountryRepositoryImpl implements CountryRespository{

	@Autowired
	private CountryGroupRepository countryGroupRepository;
	
	@Autowired
	private AttendeeRepository attendeeRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Attendee> findByGroup(String countryName) {
		CountryGroup group = countryGroupRepository.findByName(countryName);
		return attendeeRepository.findByCountryGroup(group);
	}

	@Override
	@Transactional
	public void add(CountryGroup countryGroup) {
		entityManager.persist(countryGroup);
	}

	

}
