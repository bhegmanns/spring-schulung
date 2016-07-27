package de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended;

public class XmlMessageRenderer extends AbstractMessageRenderer{

	@Override
	protected void renderMessage(String message) {
		System.out.println("<xml>" + message + "</xml>");
	}

}
