package de.hegmanns.spring.schulung.data.demo.codre.jdbc.spring;

import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.notNull;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc_spring.xml")
@FixMethodOrder
public class KundeRepositorySpringIntegrationTest {

	@Inject
	KundeRepository kunderepository;
	
	
	@Test
	public void foo(){
		
		Kunde kunde = new Kunde();
		kunde.setId(2);
		kunde.setVorname("Diddi");
		kunde.setNachname("Didier");
		
		kunderepository.addKunde(kunde);
		
		
	}
	
	@Test
	public void foo1(){
		Kunde kunde = kunderepository.getKundeById(2);
		
		assertThat(kunde, notNullValue());
	}
	
	@Test
	public void foo2(){
		Kunde kunde1 = kunderepository.getKundeById(1);
		Kunde kunde2 = kunderepository.getKundeById(2);
		
		assertThat(kunde1, nullValue());
		assertThat(kunde2, notNullValue());
	}
}
