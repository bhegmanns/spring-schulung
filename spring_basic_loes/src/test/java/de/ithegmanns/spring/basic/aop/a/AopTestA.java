package de.ithegmanns.spring.basic.aop.a;

import java.util.Collection;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTestA {

	
	@Test
	public void foo(){
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "de/ithegmanns/spring/basic/aop/a/beans.xml" });

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				// context schliessen: Nur fuer AppContext noetig
				System.out.println("context.close()...");
				context.close();
			}
		});

		//
		Bootservice bootService = (Bootservice) context.getBean("bootService");
		
		Collection<String> bootstypen = bootService.getAlleBootstypen(100);
		
		System.out.println("bootstypen=" + bootstypen);
	}
}
