package de.hegmanns.spring.schulung.k002.e01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalloWelt01Applikation {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/e01/bean_e01.xml");
		System.out.println("" + applicationContext.getBean("hallowelt_singleton_default", HalloWelt01.class).getMessage());
	}

}
