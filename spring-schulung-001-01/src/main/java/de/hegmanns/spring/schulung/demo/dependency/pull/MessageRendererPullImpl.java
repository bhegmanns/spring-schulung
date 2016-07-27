package de.hegmanns.spring.schulung.demo.dependency.pull;

import java.util.Optional;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageProvider;
import de.hegmanns.spring.schulung.demo.dependency.core.MessageRenderer;

public class MessageRendererPullImpl implements MessageRenderer {

	private Optional<MessageProvider> messageProvider;
	
	@Override
	public void render() {
		System.out.println("" + messageProvider.orElseThrow(() -> new RuntimeException("no messageProvider initialized")).getMessage());
	}

	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = Optional.ofNullable(provider);
	}

	public MessageProvider getMessageProvider() {
		return messageProvider.orElse(null);
	}

}
