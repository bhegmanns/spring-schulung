package de.hegmanns.spring.schulung.demo.dependency.injection.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.hegmanns.spring.schulung.demo.dependency.core.MessageRenderer;

public class ConstructorInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("/constructorinjection-beans.xml");
		MessageRenderer renderer = appCtx.getBean("renderer", MessageRenderer.class);
		renderer.render();
		
		renderer = appCtx.getBean("renderer_1", MessageRenderer.class);
		renderer.render();
		
		renderer = appCtx.getBean("renderer_2", MessageRenderer.class);
		renderer.render();
	}

}
