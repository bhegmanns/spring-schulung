package de.hegmanns.spring.schulung.aufgabe;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestApplication {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/app-context.xml");
        ctx.refresh();

	}

}
