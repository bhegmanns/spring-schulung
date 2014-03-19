package de.ithegmanns.spring.basic.aop.a;

import java.util.ArrayList;
import java.util.Collection;

public class BootTypenDAO {

	public Collection<String> getAlleBoottypen(){
		ArrayList<String> liste = new ArrayList<String>();
		liste.add("Segelboot");
		liste.add("Motorboot");
		
		return liste;
	}
}
