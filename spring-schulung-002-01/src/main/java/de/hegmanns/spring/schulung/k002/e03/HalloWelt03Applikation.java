package de.hegmanns.spring.schulung.k002.e03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HalloWelt03Applikation {

public static void main(String[] args) {
		
	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanDefinition.class);
	System.out.println("" + applicationContext.getBean("hallowelt_singleton_default", HalloWelt03.class).getMessage());
	}

}
