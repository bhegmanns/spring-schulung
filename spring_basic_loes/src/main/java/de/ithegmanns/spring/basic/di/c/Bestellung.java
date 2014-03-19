package de.ithegmanns.spring.basic.di.c;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Stellt eine Bestellung dar.
 * 
 * @author B. Hegmanns
 */
public class Bestellung implements Iterable<Bestellposition>{

	/**
	 * Dem Kunden, dem diese Bestellung gehoert.
	 */
	private Kunde kunde;
	
	/**
	 * Indikator, ob die Bestellung abgeschlossen ist, also zunaechst nicht mehr
	 * veraendert wird.
	 * Ist im allgemeinen <code>true</code>, falls die Bestellung durch die Kasse
	 * des Online-Kaufhauses berechnet worden ist.
	 */
	private boolean bestellungAbgeschlossen;
	
	/**
	 * Indikator, ob fuer diese Bestellung bereits alle Positionen berechnet worden sind.
	 */
	private boolean rechnungFuerPositionen;
	
	/**
	 * Indikator, ob fuer diese Bestellung durch den RechnungsBuilder optionale
	 * zusaetzliche Rechnungspositionen erstellt worden sind.
	 */
	private boolean zuaetzlicheRechnungspositionenErstellt;
	
	/**
	 * Indikator, ob diese Bestellung noch geaendert werden kann.
	 */
	private boolean aenderungMoeglich;
	
	/**
	 * Die Bestellungpositionen dieser Bestellung.
	 */
	private Set<Bestellposition> bestellpositionen;
	
	public Bestellung(){
		bestellpositionen = new HashSet<Bestellposition>();
	}
	
	public Iterator<Bestellposition> iterator() {
		return bestellpositionen.iterator();
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public boolean isBestellungAbgeschlossen() {
		return bestellungAbgeschlossen;
	}

	public void setBestellungAbgeschlossen(boolean bestellungAbgeschlossen) {
		this.bestellungAbgeschlossen = bestellungAbgeschlossen;
	}
	

	public boolean isAenderungMoeglich() {
		return aenderungMoeglich;
	}

	public void setAenderungMoeglich(boolean aenderungMoeglich) {
		this.aenderungMoeglich = aenderungMoeglich;
	}

	public Set<Bestellposition> getBestellpositionen() {
		return bestellpositionen;
	}

	public void setBestellpositionen(Set<Bestellposition> bestellpositionen) {
		this.bestellpositionen = bestellpositionen;
	}
	
	public void addBestellposition(Bestellposition bestellposition){
		this.bestellpositionen.add(bestellposition);
	}
	
}
