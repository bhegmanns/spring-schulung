package de.ithegmanns.spring.basic.di.a;

public class MeinSingleton {

	private int wert = 5;
	
	public MeinSingleton(){
		MeinSingleton.instanz = this;
	}

	public int getWert() {
		return wert;
	}
	
	public void setWert(int wert){
		this.wert = wert;
	}
	
	private static MeinSingleton instanz = null;
	public static MeinSingleton getInstance(){
		return instanz;
	}
}
