package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended;

public class DefaultMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hallo Welt";
	}

}
