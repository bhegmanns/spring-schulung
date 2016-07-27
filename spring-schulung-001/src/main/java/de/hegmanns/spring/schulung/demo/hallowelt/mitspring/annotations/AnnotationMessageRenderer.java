package de.hegmanns.spring.schulung.demo.hallowelt.mitspring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;

@Component
public class AnnotationMessageRenderer implements MessageRenderer {

	@Autowired
	private MessageProvider messageProvider;
	
	@Override
	public void render() {
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		// TODO Auto-generated method stub

	}

}
