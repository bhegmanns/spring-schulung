package de.ithegmanns.spring.basic.timer.a;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestErinnerungServiceQuartz {

	public static void main(String[] args) throws InterruptedException {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "de/ithegmanns/spring/basic/timer/a/beans.xml"});

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("ShutdownHook: context.close");
				context.close();
			}
		});

		// Spring muss weiterlaufen...zumindest einige Minuten!
		Thread.sleep(1000*60*10);
	}
}
