package de.ithegmanns.spring.basic.di.c;

import java.math.BigDecimal;

public class Rechnungsposition {

	private BigDecimal positionspreis;
	private String positionstext;
	
	public Rechnungsposition(){}
	public Rechnungsposition(String positionstext, BigDecimal positionspreis){
		this.positionspreis = positionspreis;
		this.positionstext = positionstext;
	}
	public BigDecimal getPositionspreis() {
		return positionspreis;
	}
	public void setPositionspreis(BigDecimal positionspreis) {
		this.positionspreis = positionspreis;
	}
	public String getPositionstext() {
		return positionstext;
	}
	public void setPositionstext(String positionstext) {
		this.positionstext = positionstext;
	}
	
	
	
}
