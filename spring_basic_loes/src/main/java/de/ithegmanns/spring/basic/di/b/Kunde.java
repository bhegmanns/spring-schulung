package de.ithegmanns.spring.basic.di.b;

public class Kunde {
	/**
	 * Ein eindeutiger Geschaeftsschluessel
	 */
	private String kundennummer;
	
	/**
	 * Das KundenSegment des Kunden, welches eine Gruppierung
	 * innerhalb der Firma abbildet.
	 */
	private KundenSegment kundensegment;

	public String getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}

	public KundenSegment getKundensegment() {
		return kundensegment;
	}

	public void setKundensegment(KundenSegment kundensegment) {
		this.kundensegment = kundensegment;
	}
	
	
}
