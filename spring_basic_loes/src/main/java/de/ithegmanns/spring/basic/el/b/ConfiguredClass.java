package de.ithegmanns.spring.basic.el.b;

import org.springframework.beans.factory.annotation.Value;


public class ConfiguredClass {

	/*
	<bean id="configuredClass" class="de.ithegmanns.spring.basic.el.b.ConfiguredClass">
		<property name="band" value="#{myprops.band}" />
		<property name="arena" value="#{myprops.arena}" />
		<property name="veranstalter" value="#{configuration.veranstalter}" />
		<property name="anzahlTickets" value="#{2+configuration.anzahlBodyguards}" />
		
	</bean>
	*/
	
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
