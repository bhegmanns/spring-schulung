package de.hegmanns.spring.schulung.aufgabe.hallowelt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class GreetingApp {

	private static GenericXmlApplicationContext ctx = null;
	private static HalloWeltGreeter greeter = null;
	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/greeter.xml");
        ctx.refresh();

        greeter = ctx.getBean("greeter", HalloWeltGreeter.class);
//        notLoggedIn();
//        loggedIn();
        tryingBill();
	}
	
	private static void notLoggedIn(){
		
        greeter.sayHello("Bernd");
	}
	
	private static void loggedIn(){
		LoginProvider loginProvider = new LoginProvider();
		loginProvider.doLogin("1", "Bernd", "Hegmanns", "1");
		greeter.sayHello("Bernd");
	}
	
	private static void tryingBill(){
		LoginProvider loginProvider = new LoginProvider();
		loginProvider.doLogin("1", "Bill", "Bill", "1");
		greeter.sayHello("Bill");
	}
	
	

}
