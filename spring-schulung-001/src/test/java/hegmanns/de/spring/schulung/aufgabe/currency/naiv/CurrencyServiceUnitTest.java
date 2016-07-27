package hegmanns.de.spring.schulung.aufgabe.currency.naiv;

import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

import de.hegmanns.spring.schulung.aufgabe.currency.CurrencyService;
import de.hegmanns.spring.schulung.aufgabe.currency.naiv.NaiverCurrencyService;

public class CurrencyServiceUnitTest {

	private CurrencyService currencyService;

    @Before
    public void beforeAnyTest(){
        currencyService = new NaiverCurrencyService();
    }

    @Test
    public void equalCurrency(){
    	assertThat(currencyService.getAmount(BigDecimal.TEN, "EUR", "EUR").get(), comparesEqualTo(BigDecimal.TEN));
    }
    
    @Test
    public void equalCurrencyDontRemoteLookup(){
    	
    	//Set the http proxy to webcache.mydomain.com:8080
//    	System.setProperty("http.proxyHost", "webcache.mydomain.com");
//    	System.setProperty("http.proxyPort", "8080");
//
//    	// Next connection will be through proxy.
//    	URL url = new URL("http://java.sun.com/");
//    	InputStream in = url.openStream();
//
//    	// Now, let's 'unset' the proxy.
//    	System.setProperty("http.proxyHost", null);

    	// From now on http connections will be done directly.
    }
    
    @Test
    public void unequalCurrencyWithRemoteLookup(){
    	
    }

    @Test
    public void unknownCurrency(){
    	assertThat(currencyService.getAmount(BigDecimal.ONE, "EUR", "EEE").isPresent(), is(false));
    }

    /**
     * Go to http://api.fixer.io/latest?base=EUR;symbols=USD for validate
     * rate.
     */
    @Test
    public void validRate(){
    	assertThat(currencyService.getAmount(BigDecimal.ONE, "EUR", "USD").get(), comparesEqualTo(new BigDecimal("1.1174")));
    }
    
    /**
     * Go to http://api.fixer.io/latest?base=EUR;symbols=USD for validate
     * rate.
     * calculate given rate * 5
     */
    @Test
    public void calculateWithRate(){
    	assertThat(currencyService.getAmount(new BigDecimal(5), "EUR", "USD").get(), comparesEqualTo(new BigDecimal("5.587")));
    }
    
}
