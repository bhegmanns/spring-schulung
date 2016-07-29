package de.hegmanns.spring.schulung.demo;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/app-context-annotation.xml")
@FixMethodOrder
public class ConfigurationIntegrationTest {

	@Autowired
	private AttendeeRepository attendeeRepository;
	
	@Autowired
	private CountryGroupRepository countryGroupRepository;
	
	@Autowired
	private CountryRespository countryRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Test
	public void attendeeCanSave(){
		Attendee attendee = createAttendee("Willi", "Wichtig", "willi", "willi");
		CountryGroup group = createCountryGroup("Germany", "germany", "germany");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		entityManager.flush();
	}
	
	@Test
	public void attendeeByCountry(){
		Attendee attendee = createAttendee("Ulrike", "Wichtig", "ulli", "ulli");
		CountryGroup group = createCountryGroup("Austria", "austi", "austi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Steffi", "Wichtig", "steffi", "steffi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Willi", "Wichtig", "willi", "willi");
		group = createCountryGroup("Germany", "germany", "germany");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		entityManager.flush();
		
		List<Attendee> byCountry = attendeeRepository.findByCountryGroup(group);
		assertThat(byCountry, hasSize(1));
	}
	
	@Test
	public void attendeeByCountryName(){
		Attendee attendee = createAttendee("Ulrike", "Wichtig", "ulli", "ulli");
		CountryGroup group = createCountryGroup("Austria", "austi", "austi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Steffi", "Wichtig", "steffi", "steffi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Willi", "Wichtig", "willi", "willi");
		group = createCountryGroup("Germany", "germany", "germany");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		entityManager.flush();
		
		List<Attendee> byCountry = countryRepository.findByGroup("Austria");
		assertThat(byCountry, hasSize(2));
	}
	
	@Test
	public void getByCredrentials(){
		Attendee attendee = createAttendee("Ulrike", "Wichtig", "ulli", "ulli");
		CountryGroup group = createCountryGroup("Austria", "austi", "austi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Steffi", "Wichtig", "steffi", "steffi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Willi", "Wichtig", "willi", "willi");
		group = createCountryGroup("Germany", "germany", "germany");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		entityManager.flush();
		
		Attendee fetchedAttendee = attendeeRepository.findByUsernameAndPassword("steffi", "steffi");
		assertThat(fetchedAttendee, notNullValue());
		assertThat(fetchedAttendee.getFirstName(), is("Steffi"));
	}
	
	@Test
	public void getCountryByName(){
		Attendee attendee = createAttendee("Ulrike", "Wichtig", "ulli", "ulli");
		CountryGroup group = createCountryGroup("Austria", "austi", "austi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Steffi", "Wichtig", "steffi", "steffi");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		attendee = createAttendee("Willi", "Wichtig", "willi", "willi");
		group = createCountryGroup("Germany", "germany", "germany");
		attendee.setCountryGroup(group);
		attendeeRepository.save(attendee);
		
		CountryGroup countryGroup = countryGroupRepository.findByName("Austria");
		assertThat(countryGroup, notNullValue());
	}
	
	@Test
	public void notpresentCountry(){
		
		CountryGroup countryGroup = countryGroupRepository.findByName("Austria");
		assertThat(countryGroup, nullValue());
	}
	
	public static CountryGroup createCountryGroup(String name, String teammanager, String password){
		CountryGroup group = new CountryGroup();
		group.setName(name);
		group.setTeamManagerUsername(teammanager);
		group.setTeamManagerPassword(password);
		return group;
	}
	
	public static Attendee createAttendee(String firstName, String lastName, String username, String password)
	{
		Attendee attendee = new Attendee();
		attendee.setFirstName(firstName);
		attendee.setLastName(lastName);
		attendee.setUsername(username);
		attendee.setPassword(password);
		return attendee;
	}
}
