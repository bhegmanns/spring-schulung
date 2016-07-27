package hegmanns.de.spring.schulung.aufgabe.currency.spring;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;

import de.hegmanns.spring.schulung.aufgabe.currency.CurrencyService;
import de.hegmanns.spring.schulung.aufgabe.currency.spring.RealTimeRateProvider;
import de.hegmanns.spring.schulung.aufgabe.currency.spring.SpringConfiguredCurrencyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RealTimeRateProvider.class, SpringConfiguredCurrencyService.class})
public class CurrencyServiceSpringBasedUnitTest {

	@Autowired
	private CurrencyService currencyService;
	
	@Test
	public void properCurrency(){
		assertThat(currencyService.getAmount(BigDecimal.ONE, "EUR", "USD").get(), notNullValue());
	}
}
