package de.ithegmanns.spring.basic.di.c;

import java.math.BigDecimal;
import java.util.List;

public interface Tarif {

	/**
	 * Ermittelt fuer die konkreten Tarifmerkmale
	 * den Preis der Bestellposition.
	 * 
	 * @param bestellposition die zu berechnende Bestellposition
	 * @return der Preis der Position in EUR.
	 */
	public BigDecimal getPreis(Bestellposition bestellposition);
	
	/**
	 * Ermittelt fuer die konkrete Bestellung zusaetzliche Rechnungspositionen.
	 * Diese Positionen sind abhaengig vom konkreten Tarif, können aber auch
	 * von der erteilten Bestellung abhaengig sein.
	 * 
	 * @param bestellung die Bestellung
	 * @return zuaetzliche Rechnungspositionen als List
	 */
	public List<Rechnungsposition> getZusaetzlicheRechnungspositionen(Bestellung bestellung);
}
