package de.ithegmanns.spring.basic.waehrungrechner;


import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WaehrungsrechnerDirectTest {
	
	private WaehrungsKurs kurs;
	
	@Before
	public void beforeAnyTest()
	{
		kurs = new WaehrungsKurs() {
			
			public Waehrung getZielwaehrung() {
				return Waehrung.USD;
			}
			
			public Waehrung getQuellwaehrung() {
				return Waehrung.EURO;
			}
			
			public BigDecimal getFaktor() {
				return new BigDecimal("0.5");
			}
		};
	}

	@Test
	public void waehrungsrechnerAendertUrsprungsbetragNicht()
	{
		WaehrungsrechnerImpl waehrungsrechner = new WaehrungsrechnerImpl();
		waehrungsrechner.setWaehrungskurs(kurs);
		
		Geldbetrag betrag = new Geldbetrag(BigDecimal.TEN, Waehrung.EURO);
		Geldbetrag betragInDollar = waehrungsrechner.rechneInZielwaehrung(betrag);
		
		Assert.assertTrue("" + betrag.getWaehrung().getSymbol(), betrag.getWaehrung().equals(Waehrung.EURO));
		Assert.assertTrue("" + betragInDollar.getWaehrung().getSymbol(), betragInDollar.getWaehrung().equals(Waehrung.USD));
		Assert.assertTrue("" + betragInDollar.getBetrag(), betragInDollar.getBetrag().compareTo(new BigDecimal("5")) == 0);
	}
}
