package de.ithegmanns.spring.basic.di.d;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Umgang mit dem ApplicationContext.
 * 
 * <p>
 * 	Neu eingefuehrt habe ich hier die Verwendung des Loggers.<br>
 * 	Hier wird noch keine konkrete Konfiguration verwendet.
 *  Die Logging-Ausgabe findet direkt in der Konsole statt.<br>
 *  Das wird sich aber in
 *  den naechsten Unteraufgaben aendern.<br>
 *  In den naechsten Unteraufgaben werden Sie unterschiedliche
 *  Logging-Konfigurationen sehen.
 * </p>
 * 
 * @author B. Hegmanns
 */
public class DependencyPropertyTestD {
	private static Logger LOG = Logger.getLogger(DependencyPropertyTestD.class.getName());
	
	public static final String NAME_ZAEHLER_SINGLETON = "singletonZaehler";
	public static final String NAME_ZAEHLER_PROTOTYPE = "prototypeZaehler";
	
	public static final String NAME_ZAEHLER_AUS_FACTORY = "zaehlerAusFactory";
	public static final String NAME_ZAEHLER_AUS_FACTORY_ADVANCED = "zaehlerAusFactory";
	
	private static ConfigurableApplicationContext applicationContext = null;
	
	@BeforeClass
	public static void vorbereitung() throws IOException{
		
		applicationContext = new ClassPathXmlApplicationContext("de/ithegmanns/spring/basic/di/d/beans.xml");
	}
	
	@Before
	public void vorbereitungProTest(){
		//
	}
	
	@AfterClass
	public static void testmethodenende(){
		LOG.info("ApplicationContext wird geschlossen");
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				applicationContext.close();
				LOG.info("ApplicationContext ist geschlossen");
			}
		});
	}
	
	@Test
	public void checkContexte(){
		Assert.assertNotNull(applicationContext);
	}
	
	@Test
	public void zaehlerUnterschiedlicheScopes(){
		Zaehler zaehlerSingleton = applicationContext.getBean(NAME_ZAEHLER_SINGLETON, Zaehler.class);
		Assert.assertEquals("", 0, zaehlerSingleton.getZaehlerstand());
		zaehlerSingleton.inkrementiere();
		Assert.assertEquals("", 1, zaehlerSingleton.getZaehlerstand());
		Zaehler zaehlerSingleton2 = applicationContext.getBean(NAME_ZAEHLER_SINGLETON, Zaehler.class);
		Assert.assertEquals("", 1, zaehlerSingleton2.getZaehlerstand());
		
		Zaehler zaehlerPrototype = applicationContext.getBean(NAME_ZAEHLER_PROTOTYPE, Zaehler.class);
		Assert.assertEquals("", 0, zaehlerPrototype.getZaehlerstand());
		zaehlerPrototype.inkrementiere();
		Assert.assertEquals("", 1, zaehlerPrototype.getZaehlerstand());
		Zaehler zaehlerPrototype2 = applicationContext.getBean(NAME_ZAEHLER_PROTOTYPE, Zaehler.class);
		Assert.assertEquals("", 0, zaehlerPrototype2.getZaehlerstand());
	}

	@Test
	public void zaehlerUeberFactories(){
		Zaehler zaehler = applicationContext.getBean(NAME_ZAEHLER_AUS_FACTORY, Zaehler.class);
		Assert.assertNotNull(zaehler);
		
		zaehler = applicationContext.getBean(NAME_ZAEHLER_AUS_FACTORY_ADVANCED, Zaehler.class);
		Assert.assertNotNull(zaehler);
	}
}
