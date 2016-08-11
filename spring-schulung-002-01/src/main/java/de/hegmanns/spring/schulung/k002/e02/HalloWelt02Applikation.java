package de.hegmanns.spring.schulung.k002.e02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalloWelt02Applikation {

public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/e02/bean_e02.xml");
		System.out.println("" + applicationContext.getBean("hallowelt.singleton.default", HalloWelt02.class).getMessage());
	}

}
