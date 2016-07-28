package de.hegmanns.spring.schulung.demo.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CarRepositoryImpl implements CarRepository{

	@Override
	public List<String> getCarDetails() {

		List<String> cars = new ArrayList<>();

		cars.add(0, "Santro");
		cars.add(1, "Zen");
		cars.add(2, "Alto");
		cars.add(3, "Qualis");
		cars.add(4, "Innova");

		for (String c : cars) {
			System.out.println(c);
		}

		return cars;

	}

	@PostConstruct
	public void foo(){
		System.out.println("CarRepositoryImpl erzeugt");
	}
}
