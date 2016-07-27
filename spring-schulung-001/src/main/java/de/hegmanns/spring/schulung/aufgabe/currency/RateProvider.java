package de.hegmanns.spring.schulung.aufgabe.currency;

import java.math.BigDecimal;
import java.util.Optional;

public interface RateProvider {

	Optional<BigDecimal> getRate(String sourceCurrency, String targetCurrency);
}
