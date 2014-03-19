package de.ithegmanns.spring.basic.waehrungrechner;

public class WaehrungsrechnerImpl implements Waehrungsrechner {

	
	private WaehrungsKurs waehrungskurs;
	
	public WaehrungsKurs getWaehrungskurs() {
		return waehrungskurs;
	}

	public void setWaehrungskurs(WaehrungsKurs waehrungskurs) {
		this.waehrungskurs = waehrungskurs;
	}

	public Geldbetrag rechneInZielwaehrung(Geldbetrag geldbetrag) {
		Geldbetrag neuerBetrag = new Geldbetrag(geldbetrag.getBetrag().multiply(waehrungskurs.getFaktor()), waehrungskurs.getZielwaehrung());
		return neuerBetrag;
	}

}
