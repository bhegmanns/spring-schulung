package de.hegmanns.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.sun.net.httpserver.HttpsConfigurator;

import de.hegmanns.repository.PartnerRepository;

@RestController
@RequestMapping("/partner")
public class SimpleController {
	
	@Autowired
	private PartnerRepository partnerRepository;

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Partner> getPartner(@PathVariable(name="id") long id){
		
		Partner foundedPartner = partnerRepository.findOne(id);
		if (foundedPartner != null){
			return new ResponseEntity(foundedPartner, HttpStatus.OK);
		}
		
		Faker faker = new Faker(Locale.GERMANY);
		Partner partner = new Partner();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Name fakeName = faker.name();
		System.out.println("created partner " + fakeName.title() + " " + fakeName.firstName() + " " + fakeName.lastName());
		partner.setFirstName(fakeName.firstName());
		partner.setLastName(fakeName.lastName());
		partner.setDayOfBirth(Date.valueOf(simpleDateFormat.format(faker.date().past(18*365, TimeUnit.DAYS))));
		
		partnerRepository.save(partner);
		
		return new ResponseEntity<>(partner, HttpStatus.OK);
	}
}
