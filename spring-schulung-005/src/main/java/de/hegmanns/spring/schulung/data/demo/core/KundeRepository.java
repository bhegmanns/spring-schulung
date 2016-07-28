package de.hegmanns.spring.schulung.data.demo.core;

public interface KundeRepository {
	
//	String getNameById(long id);

	Kunde getKundeById(long id);
	
	void addKunde(Kunde kunde);
	
	void createDatabase();
}
