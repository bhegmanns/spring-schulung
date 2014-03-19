package de.ithegmanns.spring.basic.di.b;

import java.math.BigDecimal;
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
public class DependencyTestB {
	private static Logger LOG = Logger.getLogger(DependencyTestB.class.getName());
	
	public static final String NAME_RECHNUNGSBUILDER = "rechnungsBuilder";
	public static final String NAME_RECHNUNGSBUILDER_PER_KONSTRUKTOR = "rechnungsBuilderKonstruktorInjizierung";
	
	private static ConfigurableApplicationContext applicationContext = null;
	private RechnungsBuilder rechnungsbuilder = null;
	
	@BeforeClass
	public static void vorbereitung(){
		applicationContext = new ClassPathXmlApplicationContext("de/ithegmanns/spring/basic/di/b/beans.xml");
		
	}
	
	@Before
	public void vorbereitungProTest(){
		rechnungsbuilder = applicationContext.getBean(NAME_RECHNUNGSBUILDER, RechnungsBuilder.class);
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
		Assert.assertNotNull(rechnungsbuilder);
	}

	@Test
	public void bestellungUndRechnungAnlegen(){
		Kunde firstKunde = erstelleFirstKunde();
		
		Ware tasse = erstelleWare(new BigDecimal("2.50"), "Tasse");
		Ware teller = erstelleWare(new BigDecimal("4.00"), "Teller");
		
		Bestellung bestellung = new Bestellung();
		bestellung.setKunde(firstKunde);
		bestellung.addBestellposition(erstellePosition(teller, 4));
		bestellung.addBestellposition(erstellePosition(tasse, 4));
		
		
		Rechnung rechnung = rechnungsbuilder.erstelleRechnung(bestellung);
		Assert.assertTrue("Habe 26 als Preis erwartet, jedoch erhalten: " + rechnung.getOffenerRechnungsbetrag(), (new BigDecimal("26")).compareTo(rechnung.getOffenerRechnungsbetrag()) == 0);
	}
	
	@Test
	public void bestellungUndRechnungAnlegenMitKonstruktorDi(){
		Kunde firstKunde = erstelleFirstKunde();
		
		Ware tasse = erstelleWare(new BigDecimal("2.50"), "Tasse");
		Ware teller = erstelleWare(new BigDecimal("4.00"), "Teller");
		
		Bestellung bestellung = new Bestellung();
		bestellung.setKunde(firstKunde);
		bestellung.addBestellposition(erstellePosition(teller, 4));
		bestellung.addBestellposition(erstellePosition(tasse, 4));
		
		RechnungsBuilder rechnungsbuilderCoDi = applicationContext.getBean(NAME_RECHNUNGSBUILDER_PER_KONSTRUKTOR, RechnungsBuilder.class);
		Rechnung rechnung = rechnungsbuilderCoDi.erstelleRechnung(bestellung);
		Assert.assertTrue("Habe 26 als Preis erwartet, jedoch erhalten: " + rechnung.getOffenerRechnungsbetrag(), (new BigDecimal("26")).compareTo(rechnung.getOffenerRechnungsbetrag()) == 0);
	}
	
	private Bestellposition erstellePosition(Ware ware, int anzahl){
		Bestellposition bestellposition = new Bestellposition();
		bestellposition.setAnzahl(anzahl);
		bestellposition.setWare(ware);
		
		return bestellposition;
	}
	
	private Kunde erstelleFirstKunde(){
		Kunde kunde = new Kunde();
		kunde.setKundennummer("123");
		kunde.setKundensegment(KundenSegment.FIRST);
		return kunde;
	}
	
	private int warennummer = 1;
	private Ware erstelleWare(BigDecimal einzelpreis, String name){
		Ware ware = new Ware();
		ware.setEinzelpreis(einzelpreis);
		ware.setWarennummer("" + warennummer);
		warennummer++;
		ware.setName(name);
		return ware;
	}
}
