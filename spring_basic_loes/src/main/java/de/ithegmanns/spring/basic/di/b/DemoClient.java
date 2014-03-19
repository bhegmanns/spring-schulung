package de.ithegmanns.spring.basic.di.b;

import java.math.BigDecimal;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DemoClient {

	public static void main(String [] args){
		@SuppressWarnings("deprecation")
		BeanFactory context = new XmlBeanFactory(new ClassPathResource("de/ithegmanns/spring/basic/di/a/beans.xml"));
		
		RechnungsBuilder rechnungsbuilder = (RechnungsBuilder)context.getBean("rechnungsBuilder");
		Kunde firstKunde = erstelleKunde();
		
		Ware tasse = erstelleWare(new BigDecimal("2,50"), "Tasse");
		Ware teller = erstelleWare(new BigDecimal("2.99"), "Teller");
		
		Bestellung bestellung = new Bestellung();
		bestellung.setKunde(firstKunde);
		bestellung.addBestellposition(erstellePosition(tasse, 4));
		bestellung.addBestellposition(erstellePosition(teller, 4));
		
		Rechnung rechnung = rechnungsbuilder.erstelleRechnung(bestellung);
		
		System.out.println("" + rechnung.getOffenerRechnungsbetrag());
	}
	
	private static Bestellposition erstellePosition(Ware ware, int anzahl){
		Bestellposition bestellposition = new Bestellposition();
		bestellposition.setAnzahl(anzahl);
		bestellposition.setWare(ware);
		
		return bestellposition;
	}
	
	private static Kunde erstelleKunde(){
		Kunde kunde = new Kunde();
		kunde.setKundennummer("123");
		kunde.setKundensegment(KundenSegment.FIRST);
		return kunde;
	}
	
	private static int warennummer = 1;
	private static Ware erstelleWare(BigDecimal einzelpreis, String name){
		Ware ware = new Ware();
		ware.setEinzelpreis(new BigDecimal(2));
		ware.setWarennummer("" + warennummer);
		warennummer++;
		ware.setName("");
		return ware;
	}
}
