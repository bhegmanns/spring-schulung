package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended;

public class DefaultMessageRenderer extends AbstractMessageRenderer {

	@Override
	protected void renderMessage(String message) {
		System.out.println(message);
	}

}
