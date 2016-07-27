package de.hegmanns.spring.schulung.demo.hallowelt.mitspring.annotations;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;

@Configuration
@ComponentScan
public class HalloWeltApplikationMitSpringAnnotations {
	
	@Bean
	MessageProvider provider(){
		return new AnnotationMessageProvider();
	}

	public static void main(String [] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(HalloWeltApplikationMitSpringAnnotations.class);
		
		MessageRenderer renderer = context.getBean(MessageRenderer.class);
		renderer.render();
		
		System.out.println("Bean-Names im Context:");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}
}
