package de.ithegmanns.spring.basic.waehrungrechner;

import java.math.BigDecimal;

public interface WaehrungsKurs {

	public Waehrung getZielwaehrung();
	public Waehrung getQuellwaehrung();
	
	public BigDecimal getFaktor();
}
