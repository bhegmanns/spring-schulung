package de.hegmanns.spring.schulung.demo.dependency.pull;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageRenderer;

public class PullApplication {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("/pull-beans.xml");
		MessageRenderer renderer = appCtx.getBean("renderer", MessageRenderer.class);
		renderer.render();
	}

}
