package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended;

public class HalloWeltExtended {

	public static void main(String [] args){
		MessageProvider messageProvider = new DefaultMessageProvider();
		MessageRenderer messageRenderer = new DefaultMessageRenderer();
		messageRenderer.setMessageProvider(messageProvider);
		
		messageRenderer.render();
	}
}
