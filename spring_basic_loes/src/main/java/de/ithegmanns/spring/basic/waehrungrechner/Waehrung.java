package de.ithegmanns.spring.basic.waehrungrechner;

public class Waehrung {
	
	public static final Waehrung EURO = new Waehrung("EUR");
	public static final Waehrung USD  = new Waehrung("USD");

	private String symbol;
	
	public Waehrung(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
}
