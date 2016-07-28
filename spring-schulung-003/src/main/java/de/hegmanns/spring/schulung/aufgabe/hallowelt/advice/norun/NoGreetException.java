package de.hegmanns.spring.schulung.aufgabe.hallowelt.advice.norun;

public class NoGreetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoGreetException(String greet){
		super("method not allowed for " + greet);
	}
}
