package de.hegmanns.spring.schulung.aufgabe.currency;

import java.math.BigDecimal;
import java.util.Optional;

public interface CurrencyService {

	Optional<BigDecimal> getAmountInEUR(BigDecimal amount, String currency);
    Optional<BigDecimal> getAmount(BigDecimal amount, String currencyFrom, String currencyTo);
}
