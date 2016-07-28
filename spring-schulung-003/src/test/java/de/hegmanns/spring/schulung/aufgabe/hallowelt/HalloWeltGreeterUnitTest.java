package de.hegmanns.spring.schulung.aufgabe.hallowelt;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.aufgabe.hallowelt.advice.norun.NoGreetException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/greeter.xml")
public class HalloWeltGreeterUnitTest {

	@Resource(name = "greeter")
	private HalloWeltGreeter greeter;
	
	@After
	public void afterAnyTest(){
		try {
			(new LoginProvider()).doLogout("1");
		} catch (RuntimeException e) {
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void notLoggedIn(){
		
        greeter.sayHello("Bernd");
	}
	
	@Test
	public void loggedIn(){
		LoginProvider loginProvider = new LoginProvider();
		loginProvider.doLogin("1", "Bernd", "Hegmanns", "1");
		greeter.sayHello("Bernd");
	}
	
	@Test(expected = NoGreetException.class)
	public void tryingBill(){
		LoginProvider loginProvider = new LoginProvider();
		loginProvider.doLogin("1", "Bill", "Bill", "1");
		greeter.sayHello("Bill");
	}
}
