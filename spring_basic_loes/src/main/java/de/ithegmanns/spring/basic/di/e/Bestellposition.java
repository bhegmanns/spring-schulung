package de.ithegmanns.spring.basic.di.e;

public class Bestellposition implements Comparable<Bestellposition>{
	
	private int anzahl;
	
	private Ware ware;

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	public int compareTo(Bestellposition bestellung) {
		int vergleichswert = this.getWare().compareTo(bestellung.getWare());
		if (vergleichswert == 0){
			vergleichswert = anzahl - bestellung.getAnzahl();
		}

		return vergleichswert;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + anzahl;
		result = prime * result + ((ware == null) ? 0 : ware.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellposition other = (Bestellposition) obj;
		if (anzahl != other.anzahl)
			return false;
		if (ware == null) {
			if (other.ware != null)
				return false;
		} else if (!ware.equals(other.ware))
			return false;
		return true;
	}
	
	
	
	
}
