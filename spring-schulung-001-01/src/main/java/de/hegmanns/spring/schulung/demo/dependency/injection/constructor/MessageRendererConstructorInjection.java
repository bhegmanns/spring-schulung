package de.hegmanns.spring.schulung.demo.dependency.injection.constructor;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageProvider;
import de.hegmanns.spring.schulung.demo.dependency.core.MessageRenderer;

public class MessageRendererConstructorInjection implements MessageRenderer{

	private MessageProvider messageProvider;
	
	public MessageRendererConstructorInjection(MessageProvider messageProvider){
		this.messageProvider = messageProvider;
	}

	@Override
	public void render() {
		System.out.println("" + messageProvider.getMessage());
	}
	
	
}
