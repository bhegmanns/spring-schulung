package de.hegmanns.spring.schulung.aufgabe.hallowelt.aspectj;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

	public String hello(String name){
		return "hello " + name;
	}
	
	public String sayHello(){
		return "hello";
	}
}
