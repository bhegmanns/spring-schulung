package de.hegmanns.spring.schulung.demo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpecialAttendeeRepositoryImpl implements SpecialAttendeeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CountryRespository countryRepository;
	
//	@Transactional(noRollbackFor = {RuntimeException.class},)
	@Override
	public void add(Attendee attendee) {
		countryRepository.add(attendee.getCountryGroup());
		entityManager.persist(attendee);
//		entityManager.getTransaction().commit();
//		throw new RuntimeException("I won't persist");
	}

}
