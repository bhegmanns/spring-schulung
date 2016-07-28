package de.hegmanns.spring.schulung.demo.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class Car {

	@Autowired
	CarRepository carRepository;

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<String> fetchCarDetails() {
		
		List<String> carDetails = carRepository.getCarDetails();
		System.out.println("size = " + carDetails.size());
		return carDetails;
	}
	
	@PostConstruct
	public void foo(){
		System.out.println("Car erzeugt");
	}
}
