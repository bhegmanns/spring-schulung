package de.ithegmanns.spring.basic.di.a;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author B. Hegmanns
 */
@Lazy(false)
public class DependencyTestA {
	
	public static final String NAME_RECHNUNGSBUILDER = "rechnungsBuilder";
	
	private BeanFactory context = null;
	private RechnungsBuilder rechnungsbuilder = null;
	
	@Before
	public void vorbereitung(){
		context = new XmlBeanFactory(new ClassPathResource("de/ithegmanns/spring/basic/di/a/beans.xml"));
		
		rechnungsbuilder = context.getBean(NAME_RECHNUNGSBUILDER, RechnungsBuilder.class);
	}
	
	@Test
	public void checkContexte(){
		Assert.assertNotNull(context);
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
	public void meinSingletonIstNichtNull(){
		Assert.assertNotNull(MeinSingleton.getInstance());
		Assert.assertEquals(25, MeinSingleton.getInstance().getWert());
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
