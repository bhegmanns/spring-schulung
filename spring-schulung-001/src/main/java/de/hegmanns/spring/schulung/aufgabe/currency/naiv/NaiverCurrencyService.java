package de.hegmanns.spring.schulung.aufgabe.currency.naiv;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hegmanns.spring.schulung.aufgabe.currency.CurrencyService;

public class NaiverCurrencyService implements CurrencyService{
	
	private static Logger LOG = Logger.getLogger(NaiverCurrencyService.class);
	private static final String RATES = "rates";
	
	@Override
	public Optional<BigDecimal> getAmountInEUR(BigDecimal amount, String currency) {
		return getAmount(amount, currency, "EUR");
	}

	@Override
	public Optional<BigDecimal> getAmount(BigDecimal amount, String currencyFrom, String currencyTo) {
		if (currencyFrom.equals(currencyTo)){
            return Optional.of(new BigDecimal(amount.toString()));
        }
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        String urlString = "http://api.fixer.io/latest?base=" + currencyFrom + ";symbols=" + currencyTo;
        LOG.debug("URL=" + urlString);
        //System.out.println("URL = <" + urlString + ">");
        WebTarget service = client.target(urlString);
        // siehe http://fixer.io/
        String answer = service.request(MediaType.TEXT_PLAIN_TYPE).get(String.class);
        LOG.debug("Answer = " + answer);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapp = null;
        try {
            mapp = objectMapper.readValue(answer, new TypeReference<HashMap<String, Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap linkedHashMap = (LinkedHashMap)mapp.get(RATES);
        if (linkedHashMap.isEmpty()){
            return Optional.empty();
        }
        Double rate = (Double)linkedHashMap.get(currencyTo);

        BigDecimal bigDecimal = new BigDecimal(rate.toString());
        return Optional.of(bigDecimal.multiply(amount));
	}

}
