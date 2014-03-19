package de.ithegmanns.spring.basic.waehrungrechner;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WaehrungsrechnerMockTest {

	@Mock
	private WaehrungsKurs waehrungskurs;
	
	@InjectMocks
	private WaehrungsrechnerImpl waehrungsrechner;
	
	@Test
	public void waehrungsrechnerAendertUrsprungsbetragNicht()
	{
		Mockito.when(waehrungskurs.getFaktor()).thenReturn(new BigDecimal("0.5"));
		Mockito.when(waehrungskurs.getZielwaehrung()).thenReturn(Waehrung.USD);
		
		Geldbetrag betrag = new Geldbetrag(BigDecimal.TEN, Waehrung.EURO);
		Geldbetrag umgerechnerBetrag = waehrungsrechner.rechneInZielwaehrung(betrag);
		
		Assert.assertTrue("" + betrag.getWaehrung().getSymbol(), betrag.getWaehrung().equals(Waehrung.EURO));
		Assert.assertTrue("" + umgerechnerBetrag.getWaehrung().getSymbol(), umgerechnerBetrag.getWaehrung().equals(Waehrung.USD));
		Assert.assertTrue("" + umgerechnerBetrag.getBetrag(), umgerechnerBetrag.getBetrag().compareTo(new BigDecimal("5")) == 0);
	}
}
