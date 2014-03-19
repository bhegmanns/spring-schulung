package de.ithegmanns.spring.basic.el.a;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ElDemoClient {

	/**
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "de/ithegmanns/spring/basic/el/a/beans.xml" });

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				// context schliessen: Nur fuer ApplicationContext noetig
				System.out.println("context.close()...");
				context.close();
			}
		});
		
		ConfiguredClass conf = (ConfiguredClass) context.getBean("configuredClass");

		System.out.println("Band: " + conf.getBand());
		System.out.println("Arena: " + conf.getArena());
		System.out.println("Veranstalter: " + conf.getVeranstalter());
		System.out.println("Anzahl Tickets: " + conf.getAnzahlTickets());
		
	}
}
