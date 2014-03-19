package de.ithegmanns.spring.basic.di.a;

import java.math.BigDecimal;

public class Ware implements Comparable<Ware>{

	private String name;
	
	private String warennummer;
	
	private BigDecimal einzelpreis;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarennummer() {
		return warennummer;
	}

	public void setWarennummer(String warennummer) {
		this.warennummer = warennummer;
	}

	public BigDecimal getEinzelpreis() {
		return einzelpreis;
	}

	public void setEinzelpreis(BigDecimal einzelpreis) {
		this.einzelpreis = einzelpreis;
	}

	public int compareTo(Ware ware) {
		return this.getName().compareTo(ware.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((einzelpreis == null) ? 0 : einzelpreis.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((warennummer == null) ? 0 : warennummer.hashCode());
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
		Ware other = (Ware) obj;
		if (einzelpreis == null) {
			if (other.einzelpreis != null)
				return false;
		} else if (!einzelpreis.equals(other.einzelpreis))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (warennummer == null) {
			if (other.warennummer != null)
				return false;
		} else if (!warennummer.equals(other.warennummer))
			return false;
		return true;
	}
	
	
	
	
}
