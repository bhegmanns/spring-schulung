package de.hegmanns.spring.schulung.k002.e04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HalloWelt04Applikation {

public static void main(String[] args) {
		
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanDefinition.class);
	((AnnotationConfigApplicationContext)applicationContext).registerShutdownHook();
	HalloWelt04 halloWelt = applicationContext.getBean(HalloWelt04.class);
	}

}
