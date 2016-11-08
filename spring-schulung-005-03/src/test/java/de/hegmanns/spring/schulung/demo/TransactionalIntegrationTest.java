package de.hegmanns.spring.schulung.demo;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/app-context-annotation.xml")
@FixMethodOrder
public class TransactionalIntegrationTest {

	@Autowired
	private AttendeeRepository attendeeRepository;
	
	@Autowired
	private CountryGroupRepository countryGroupRepository;
	
	@Autowired
	private CountryRespository countryRepository;
	
	@Autowired
	private SpecialAttendeeRepository specialAttendeeRepository;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	@Test
//	@org.junit.Ignore("it's for transaction service")
	public void addingAttendee(){
		CountryGroup groupInDatabase = countryGroupRepository.findByName("Austria");
		assertThat(groupInDatabase, nullValue());
		Attendee attendee = ConfigurationIntegrationTest.createAttendee("Ulrike", "Wichtig", "ulli", "ulli");
		CountryGroup group = ConfigurationIntegrationTest.createCountryGroup("Austria", "austi", "austi");
		attendee.setCountryGroup(group);
		
//		specialAttendeeRepository.add(attendee);
		try {
			specialAttendeeRepository.add(attendee);
			entityManager.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		groupInDatabase = countryGroupRepository.findByName("Austria");
		Attendee attendeeInDatabase = attendeeRepository.findByUsernameAndPassword("ulli", "ulli");
		assertThat(groupInDatabase, notNullValue());
		assertThat(attendeeInDatabase, notNullValue());
//		assertThat(groupInDatabase, notNullValue());
	}
	
	@Test
//	@org.junit.Ignore("it's for transaction service")
	public void readingCountryGroup(){
		CountryGroup groupInDatabase = countryGroupRepository.findByName("Austria");
		assertThat(groupInDatabase, notNullValue());
	}
	
	@Test
	public void foo(){
//		TransactionTemplate newTemplate = new TransactionTemplate(transactionTemplate.getTransactionManager());
//		newTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
		long count = transactionTemplate.execute(new TransactionCallback<Long>() {

			@Override
			public Long doInTransaction(TransactionStatus status) {
				//...
				if (true /* make service to check  quality*/){
					status.setRollbackOnly();
				}
				return (long)entityManager.createQuery("select count(c) from CountryGroup c").getSingleResult();
			}
		});
	}
}
