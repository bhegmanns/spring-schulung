package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfigurationmitfactory;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;

public class HalloWeltKonfigurationMitFactory {

	public static void main(String [] args){
		MessageRenderer renderer = MessageSupportFactory.instance().getMessageRenderer();
		renderer.render();
	}
}
