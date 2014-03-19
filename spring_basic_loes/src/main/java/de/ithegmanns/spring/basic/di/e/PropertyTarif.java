package de.ithegmanns.spring.basic.di.e;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Array;

public class PropertyTarif implements Tarif {
	
	private Map<String, BigDecimal> tarifInformationen;
	
	public Map<String, BigDecimal> getTarifInformationen(){
		return tarifInformationen;
	}
	
	public void setTarifInformationen(Map<String, String> tarifInformationen)
	{
		this.tarifInformationen = new HashMap<String, BigDecimal>();
		
		
	}

	public BigDecimal getPreis(Bestellposition bestellposition) {
		return bestellposition.getWare().getEinzelpreis().multiply(new BigDecimal(bestellposition.getAnzahl()));
	}

	public List<Rechnungsposition> getZusaetzlicheRechnungspositionen(
			Bestellung bestellung) {
		Kunde kunde = bestellung.getKunde();
		List<Rechnungsposition> rechnungspositionen = new ArrayList<Rechnungsposition>();
		
		BigDecimal versandtkosten = tarifInformationen.get(kunde.getKundensegment().getName());
		if (versandtkosten == null)
		{
			versandtkosten = tarifInformationen.get("DEFAULT");
		}
		
		rechnungspositionen.add(new Rechnungsposition("", versandtkosten));
		
		return rechnungspositionen;
	}

}
