package de.hegmanns.spring.schulung.demo.hallowelt.mitspring.annotations;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;


public class AnnotationMessageProvider implements MessageProvider{

	
	public String getMessage(){
		return "Hallo Welt";
	}
}
