package de.hegmanns.spring.schulung.aufgabe.currency.spring;

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
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.hegmanns.spring.schulung.aufgabe.currency.RateProvider;
import de.hegmanns.spring.schulung.aufgabe.currency.naiv.NaiverCurrencyService;

@Component
public class RealTimeRateProvider implements RateProvider {
	
	private static Logger LOG = Logger.getLogger(NaiverCurrencyService.class);
	private static final String RATES = "rates";

	@Override
	public Optional<BigDecimal> getRate(String sourceCurrency, String targetCurrency) {
		ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);

        String urlString = "http://api.fixer.io/latest?base=" + sourceCurrency + ";symbols=" + targetCurrency;
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
        Double rate = (Double)linkedHashMap.get(targetCurrency);

        BigDecimal bigDecimal = new BigDecimal(rate.toString());
        return Optional.of(bigDecimal);
	}

}
