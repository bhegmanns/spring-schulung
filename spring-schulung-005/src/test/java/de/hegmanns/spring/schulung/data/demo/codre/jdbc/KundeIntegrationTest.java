package de.hegmanns.spring.schulung.data.demo.codre.jdbc;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;
import de.hegmanns.spring.schulung.data.demo.core.jdbc.KundeRepositoryJdbcImpl;

@FixMethodOrder
public class KundeIntegrationTest {

	static KundeRepository kunderepository = new KundeRepositoryJdbcImpl();
	
	@BeforeClass
	public static void before(){
		kunderepository.createDatabase();
	}
	
	@Test
	public void foo(){
		Kunde kunde = new Kunde();
        kunde.setId(1);
        kunde.setVorname("Bernd");
        kunde.setNachname("Hegmanns");
        kunderepository.addKunde(kunde);
	}
	
	@Test
	public void foo1(){
		Kunde gelesenerKunde = kunderepository.getKundeById(1);
		assertThat(gelesenerKunde, notNullValue());
	}
}
