package de.hegmanns.spring.schulung.aufgabe;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/app-context.xml")
@FixMethodOrder
public class ConfigurationIntegrationTest {

	@Test
	public void foo(){
		
	}
}
