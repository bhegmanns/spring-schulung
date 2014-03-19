package de.ithegmanns.spring.basic.el.b;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ElDemoClient {

	/**
	 * Add VM-argument:
	 * -Darena=O2-Arena
	 * to make this work.
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "de/ithegmanns/spring/basic/el/b/beans-annot.xml" });

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
