package de.ithegmanns.spring.basic.di.c;

public class Nummer {

	private long wert;
	
	public Nummer(){
		this(0);
	}
	public Nummer(long initial){
		this.wert = initial;
	}
	public void setWert(long wert){
		this.wert = wert;
	}
	public long getWert(){
		return this.wert;
	}
}
