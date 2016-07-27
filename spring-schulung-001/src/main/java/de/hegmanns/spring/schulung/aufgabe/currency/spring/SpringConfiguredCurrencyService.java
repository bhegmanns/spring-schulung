package de.hegmanns.spring.schulung.aufgabe.currency.spring;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.hegmanns.spring.schulung.aufgabe.currency.CurrencyService;
import de.hegmanns.spring.schulung.aufgabe.currency.RateProvider;

@Component
public class SpringConfiguredCurrencyService implements CurrencyService {
	
	@Autowired
	private RateProvider rateProvider;
	

	public RateProvider getRateProvider() {
		return rateProvider;
	}

	public void setRateProvider(RateProvider rateProvider) {
		this.rateProvider = rateProvider;
	}

	@Override
	public Optional<BigDecimal> getAmountInEUR(BigDecimal amount, String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BigDecimal> getAmount(BigDecimal amount, String currencyFrom, String currencyTo) {
		if (currencyFrom.equals(currencyTo)){
			return Optional.of(amount);
		}
		
		Optional<BigDecimal> rate = rateProvider.getRate(currencyFrom, currencyTo);
		if (rate.isPresent()){
			return Optional.of(amount.multiply(rate.get()));
		}
		return Optional.empty();
	}

}
