package hegmanns.de.spring.schulung.aufgabe.currency.naiv;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

import de.hegmanns.spring.schulung.aufgabe.currency.CurrencyService;
import de.hegmanns.spring.schulung.aufgabe.currency.RateProvider;
import de.hegmanns.spring.schulung.aufgabe.currency.naiv.NaiverCurrencyService;
import de.hegmanns.spring.schulung.aufgabe.currency.spring.SpringConfiguredCurrencyService;

public class CurrencyServiceUnitTest {

	private CurrencyService currencyService;
	
	private RateProvider rateProvider;
	
	private static BigDecimal ANY_RATE = BigDecimal.TEN;

    @Before
    public void beforeAnyTest(){
        currencyService = new SpringConfiguredCurrencyService();//new NaiverCurrencyService();
        rateProvider = Mockito.mock(RateProvider.class);
        ((SpringConfiguredCurrencyService)currencyService).setRateProvider(rateProvider);
    }

    @Test
    public void equalCurrency(){
    	assertThat(currencyService.getAmount(BigDecimal.TEN, "EUR", "EUR").get(), comparesEqualTo(BigDecimal.TEN));
    }
    
    @Test
    public void equalCurrencyDontRemoteLookup(){
    	currencyService.getAmount(BigDecimal.TEN, "ANY", "ANY");
    	verify(rateProvider, never()).getRate(anyString(), anyString());
    }
    
    @Test
    public void unequalCurrencyWithRemoteLookup(){
    	when(rateProvider.getRate(anyString(), anyString())).thenReturn(Optional.of(BigDecimal.TEN));
    	currencyService.getAmount(BigDecimal.TEN, "ANY", "OTH");
    	
    	verify(rateProvider, times(1)).getRate(anyString(), anyString());
    }
    
    private boolean machWas(String s){
    	// ...
    	return "hallo".equals(s);
    }

    @Test
    public void unknownCurrency(){
    	when(rateProvider.getRate(anyString(), anyString())).thenReturn(Optional.empty());
    	assertThat(currencyService.getAmount(BigDecimal.ONE, "EUR", "EEE").isPresent(), is(false));
    }

    /**
     * Go to http://api.fixer.io/latest?base=EUR;symbols=USD for validate
     * rate.
     */
    @Test
    public void validRate(){
    	when(rateProvider.getRate(anyString(), anyString())).thenReturn(Optional.of(ANY_RATE));
    	assertThat(currencyService.getAmount(BigDecimal.ONE, "EUR", "USD").get(), comparesEqualTo(ANY_RATE));
    }
    
    /**
     * Go to http://api.fixer.io/latest?base=EUR;symbols=USD for validate
     * rate.
     * calculate given rate * 5
     */
    @Test
    public void calculateWithRate(){
    	when(rateProvider.getRate(anyString(), anyString())).thenReturn(Optional.of(ANY_RATE));
    	BigDecimal myAmount = new BigDecimal(5);
    	assertThat(currencyService.getAmount(myAmount, "EUR", "USD").get(), comparesEqualTo(ANY_RATE.multiply(myAmount)));
    }
    
}
