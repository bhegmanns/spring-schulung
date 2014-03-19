package de.ithegmanns.spring.basic.el.a;


public class ConfiguredClass {

	private String band;
	
	private String arena;
	
	private String veranstalter;
	
	private int anzahlTickets = 0;
	
	// Getters and Setters:
	
	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public int getAnzahlTickets() {
		return anzahlTickets;
	}

	public void setAnzahlTickets(int anzahlTickets) {
		this.anzahlTickets = anzahlTickets;
	}

	public String getArena() {
		return arena;
	}

	public void setArena(String arena) {
		this.arena = arena;
	}

	public String getVeranstalter() {
		return veranstalter;
	}

	public void setVeranstalter(String veranstalter) {
		this.veranstalter = veranstalter;
	}
	
}
