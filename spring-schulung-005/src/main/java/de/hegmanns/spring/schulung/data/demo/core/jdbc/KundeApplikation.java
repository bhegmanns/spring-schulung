package de.hegmanns.spring.schulung.data.demo.core.jdbc;

import de.hegmanns.spring.schulung.data.demo.core.Kunde;
import de.hegmanns.spring.schulung.data.demo.core.KundeRepository;

public class KundeApplikation {

	public static void main(String[] args) {
        KundeRepository kundeRepository = new KundeRepositoryJdbcImpl();

        Kunde kunde = new Kunde();
        kunde.setId(1);
        kunde.setVorname("Bernd");
        kunde.setNachname("Hegmanns");
        kundeRepository.addKunde(kunde);
        
        Kunde gelesenerKunde = kundeRepository.getKundeById(1);
        System.out.println("Kunde name: " + gelesenerKunde.getVorname() + " " + gelesenerKunde.getNachname());
 }
}
