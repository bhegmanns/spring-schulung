package de.ithegmanns.spring.basic.di.a;

/**
 * Die konkreten Kundensegmente.
 * 
 * @author B. Hegmanns
 */
public enum KundenSegment {
	STANDARD("STANDARD"), FIRST("FIRST"), SILBER("SILBER");
	
	private KundenSegment(String name){}
	
	private String name;
	
	public String getName(){
		return name;
	}
}
