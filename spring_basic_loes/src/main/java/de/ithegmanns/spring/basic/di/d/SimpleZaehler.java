package de.ithegmanns.spring.basic.di.d;

public class SimpleZaehler implements Zaehler{
	
	private long zaehlerstand;

	public SimpleZaehler(){}
	public SimpleZaehler(long initial){
		this.zaehlerstand = initial;
	}
	
	public SimpleZaehler(long initial, ZaehlerAdvisor<SimpleZaehler> advisor){
		this.zaehlerstand = initial;
		if (advisor != null)
		{
			advisor.advice(this);
		}
	}
	
	protected void setNeuenZaehlerstand(long neuerZaehlerstand){
		this.zaehlerstand = neuerZaehlerstand;
	}
	public void inkrementiere() {
		setNeuenZaehlerstand(getZaehlerstand() + 1);
	}
	public void dekrementiere() {
		setNeuenZaehlerstand(getZaehlerstand() - 1);
	}
	public long getZaehlerstand() {
		return zaehlerstand;
	}
	
	
}
