package de.ithegmanns.spring.basic.di.d;

public abstract class ZaehlerAdvisor<T extends Zaehler> {

	public abstract void advice(T zaehler);
	
}
