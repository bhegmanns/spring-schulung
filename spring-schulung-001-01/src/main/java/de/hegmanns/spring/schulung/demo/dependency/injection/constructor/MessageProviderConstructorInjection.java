package de.hegmanns.spring.schulung.demo.dependency.injection.constructor;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageProvider;

public class MessageProviderConstructorInjection implements MessageProvider {

	private String text;
	public MessageProviderConstructorInjection(String text) {
		this.text = text;
	}
	@Override
	public String getMessage() {
		return text;
	}

}
