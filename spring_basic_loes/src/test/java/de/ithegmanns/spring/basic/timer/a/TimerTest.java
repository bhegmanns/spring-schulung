package de.ithegmanns.spring.basic.timer.a;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TimerTest {

	@Test
	public void foo(){
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "de/ithegmanns/spring/basic/timer/a/beans.xml"});

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("ShutdownHook: context.close");
				context.close();
			}
		});

		// Spring muss weiterlaufen...zumindest einige Minuten!
		try {
			Thread.sleep(1000*60*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
