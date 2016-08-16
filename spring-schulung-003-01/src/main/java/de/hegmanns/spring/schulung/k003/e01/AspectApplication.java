package de.hegmanns.spring.schulung.k003.e01;

public class AspectApplication {

	public static void main(String[] args) {
		System.out.println("Dies ist eine mit AspectJ umwobene Applikation");
		
		
		HalloWelt halloWelt = new HalloWelt();
		
		System.out.println("call halloWelt.main(\"hallo Welt\")");
		halloWelt.main("hallo Welt");
		
		System.out.println("call halloWelt.keinMain(\"hallo Welt\")");
		halloWelt.keinMain("hallo Welt");
		
		System.out.println("call halloWelt.rufeMain(\"hallo Welt\")");
		halloWelt.rufeMain("hallo Welt");
	}

}
