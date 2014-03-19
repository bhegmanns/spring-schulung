package de.ithegmanns.spring.basic.di.e;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SimpleTarif implements Tarif {
	private static final String POS_VERSANDT = "Versandt- und Verpackung";

	public BigDecimal getPreis(Bestellposition bestellposition) {
		return bestellposition.getWare().getEinzelpreis().multiply(BigDecimal.valueOf(bestellposition.getAnzahl()));
	}
	
	public List<Rechnungsposition> getZusaetzlicheRechnungspositionen(
			Bestellung bestellung) {
		
		List<Rechnungsposition> rechnungspositionen = new ArrayList<Rechnungsposition>();
		Kunde kunde = bestellung.getKunde();
		
		
		switch(kunde.getKundensegment())
		{
		case FIRST:
			rechnungspositionen.add(createRechnungsposition(POS_VERSANDT, new BigDecimal("0")));
			break;
		case SILBER:
			rechnungspositionen.add(createRechnungsposition(POS_VERSANDT, new BigDecimal(2)));
			break;
		case STANDARD:
			rechnungspositionen.add(createRechnungsposition(POS_VERSANDT, new BigDecimal("3.75")));
			break;
		default: throw new RuntimeException("Unbekanntes Kundensegment");
		}
		
		return rechnungspositionen;
	}
	
	private Rechnungsposition createRechnungsposition(String positionstext, BigDecimal positionspreis){
		Rechnungsposition rechnungsposition = new Rechnungsposition();
		rechnungsposition.setPositionspreis(positionspreis);
		rechnungsposition.setPositionstext(positionstext);
		
		return rechnungsposition;
	}

}
