package de.ithegmanns.spring.basic.di.a;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Die Rechnung.
 * 
 * @author B. Hegmanns
 */
public class Rechnung {

	/**
	 * Die Bestellung, fuer die diese Rechnung
	 * gilt.
	 */
	private Bestellung bestellung;
	
	private boolean abgeschlossen;
	
	/**
	 * Die aus den einzelnen Bestellpositionen resultierenden Rechnungspositionen.
	 */
	private Map<Bestellposition, Rechnungsposition> rechnungspositionen;
	
	/**
	 * Zusaetzliche Rechnungspositionen, die nicht konkret vom Kunden beeinflusst werden.
	 * Dabei kann es sich beispielsweise um kostenloste Zusatzartikel oder Preisnachlaesse
	 * handeln, oder Versandtkosten.
	 */
	private List<Rechnungsposition> zusaetzlichePositionen;
	
	/**
	 * Der aus dieser Rechnung noch offene Betrag.
	 */
	private BigDecimal offenerRechnungsbetrag;

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public Map<Bestellposition, Rechnungsposition> getRechnungspositionen() {
		return rechnungspositionen;
	}

	public void setRechnungspositionen(
			Map<Bestellposition, Rechnungsposition> rechnungspositionen) {
		checkAenderung();
		this.rechnungspositionen = rechnungspositionen;
	}

	public List<Rechnungsposition> getZusaetzlichePositionen() {
		return zusaetzlichePositionen;
	}

	public void setZusaetzlichePositionen(
			List<Rechnungsposition> zusaetzlichePositionen) {
		checkAenderung();
		this.zusaetzlichePositionen = zusaetzlichePositionen;
	}

	public BigDecimal getOffenerRechnungsbetrag() {
		return offenerRechnungsbetrag;
	}

	public void setOffenerRechnungsbetrag(BigDecimal offenerRechnungsbetrag) {
		checkAenderung();
		this.offenerRechnungsbetrag = offenerRechnungsbetrag;
	}

	public boolean isAbgeschlossen() {
		return abgeschlossen;
	}

	public void setAbgeschlossen(boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}
	
	private void checkAenderung(){
		if (abgeschlossen)
		{
			throw new RuntimeException("Rechnung ist bereits abgeschlossen!");
		}
	}
	
	
}
