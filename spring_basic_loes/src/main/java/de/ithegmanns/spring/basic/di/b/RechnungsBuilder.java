package de.ithegmanns.spring.basic.di.b;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ermittelt zu einer Bestellung alle relevanten Rechnungspositionen.
 * 
 * @author B. Hegmanns
 */
public class RechnungsBuilder {

	/**
	 * Der zugrunde liegende Tarif, ermittelt alle relevanten Rechnungsbestandteile.
	 */
	private Tarif tarif;
	
	private Date date;
	
	public RechnungsBuilder(){}
	
	public RechnungsBuilder(Tarif tarif){
		this.tarif = tarif;
	}
	
	public RechnungsBuilder(Date date, Tarif tarif){
		this.date = date;
		this.tarif = tarif;
	}
	
	
	
	public Tarif getTarif() {
		return tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	/**
	 * Hauptmethode zur Ermittlung der Rechnung.
	 * 
	 * @param bestellung die Bestellung, zu der die Rechnung erstellt werden soll
	 * @return die Rechnung
	 */
	public Rechnung erstelleRechnung(Bestellung bestellung){
		Rechnung rechnung = new Rechnung();
		
		Map<Bestellposition, Rechnungsposition> rechnungspositionenFuerBestellpositionen =
				erstelleRechnungspositionenAusBestellpositionen(bestellung);
		
		List<Rechnungsposition> rechnungspositionenZusatz = erstelleZusaetzlicheRechnungspositionen(bestellung, berechnePreisAusPositionen(rechnungspositionenFuerBestellpositionen.values()));
		
		rechnung.setBestellung(bestellung);
		rechnung.setRechnungspositionen(rechnungspositionenFuerBestellpositionen);
		rechnung.setZusaetzlichePositionen(rechnungspositionenZusatz);
		rechnung.setOffenerRechnungsbetrag(berechnePreisAusPositionen(rechnungspositionenZusatz).add(berechnePreisAusPositionen(rechnungspositionenFuerBestellpositionen.values())));
		rechnung.setAbgeschlossen(true);
		
		
		return rechnung;
	}
	
	/**
	 * Ermittelt aus den uebergebenen Rechnungspositionen
	 * den Gesamtpreis.
	 * 
	 * @param preise die Collection der Rechnungspositionen
	 * @return der Gesamtpreis
	 */
	private BigDecimal berechnePreisAusPositionen(Collection<Rechnungsposition> preise)
	{
		BigDecimal preis = BigDecimal.ZERO;
		for (Rechnungsposition rechnungsposition : preise)
		{
			preis = preis.add(rechnungsposition.getPositionspreis());
		}
		return preis;
	}
	
	/**
	 * Ermittelt die zu den einzelnen Bestellpositionen der Rechnung gehoerenden
	 * Rechnungspositionen.
	 * Im Allgemeinen wird pro Bestellposition eine Rechnungsposition existieren.
	 * Konkret kann sich dies aber auch anders verhalten.
	 * 
	 * @param bestellung die Bestellung
	 * @return
	 */
	private Map<Bestellposition, Rechnungsposition> erstelleRechnungspositionenAusBestellpositionen(Bestellung bestellung){
		Map<Bestellposition, Rechnungsposition> rechnungspositionen = new HashMap<Bestellposition, Rechnungsposition>();
		
		for (Bestellposition bestellposition : bestellung)
		{
			Rechnungsposition rechnungsposition = new Rechnungsposition(bestellposition.getWare().getWarennummer() + "(Anzahl: " + bestellposition.getAnzahl() + ")", tarif.getPreis(bestellposition));
			
			rechnungspositionen.put(bestellposition, rechnungsposition);
		}
		
		
		return rechnungspositionen;
	}
	
	private List<Rechnungsposition> erstelleZusaetzlicheRechnungspositionen(Bestellung bestellung, BigDecimal preisAusPositionen){
		return tarif.getZusaetzlicheRechnungspositionen(bestellung);
	}
	
	
}
