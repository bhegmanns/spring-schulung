package de.ithegmanns.spring.basic.di.d;

/**
 * Ein begrenzter Zaehler, dessen Zaehlerstand vorgegebene Grenzwerte nicht ueberschreitet.
 * 
 * @author B. Hegmanns
 */
public class BegrenzterZaehler extends SimpleZaehler implements Zaehler {

	private long minimalwert;
	private long maximalwert;
	
	public BegrenzterZaehler(long minimalwert, long maximalwert, long initial){
		super(initial);
		this.minimalwert = minimalwert;
		this.maximalwert = maximalwert;
	}

	@Override
	protected void setNeuenZaehlerstand(long neuerZaehlerstand) {
		super.setNeuenZaehlerstand(Math.max(Math.min(neuerZaehlerstand, maximalwert), minimalwert));
	}
	
}
