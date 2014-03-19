package de.ithegmanns.spring.basic.waehrungrechner;

import java.math.BigDecimal;


public class Geldbetrag {

	private BigDecimal betrag;
	
	private Waehrung waehrung;
	
	

	public Geldbetrag(BigDecimal betrag, Waehrung waehrung) {
		super();
		this.betrag = betrag;
		this.waehrung = waehrung;
	}

	public BigDecimal getBetrag() {
		return betrag;
	}

	public void setBetrag(BigDecimal betrag) {
		this.betrag = betrag;
	}

	public Waehrung getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(Waehrung waehrung) {
		this.waehrung = waehrung;
	}
	
	
}
