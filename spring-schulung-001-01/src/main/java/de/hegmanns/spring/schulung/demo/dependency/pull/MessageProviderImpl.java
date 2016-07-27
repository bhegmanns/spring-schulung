package de.hegmanns.spring.schulung.demo.dependency.pull;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageProvider;

public class MessageProviderImpl implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hallo Welt";
	}

}
