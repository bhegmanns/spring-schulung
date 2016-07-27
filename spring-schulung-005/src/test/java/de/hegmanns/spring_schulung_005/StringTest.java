package de.hegmanns.spring_schulung_005;

import org.junit.Test;

public class StringTest {

	@Test
	public void foo(){
		String text = "Table/View 'KUNDE' already exists in Schema 'DERBY'";
		boolean matches = text.matches(".*KUNDE.*already exists in Schema.*");
		System.out.println("" + matches);
	}
}
