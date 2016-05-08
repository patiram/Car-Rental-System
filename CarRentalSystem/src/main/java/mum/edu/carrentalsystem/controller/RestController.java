package mum.edu.carrentalsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Category;
import mum.edu.carrentalsystem.service.CarService;

@Component
@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private CarService carService;

/*	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}*/
	@RequestMapping(value = "/carList/{category}", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<Car> restCarCategoryList(@PathVariable Category category) {
		System.out.println(category);
		List<Car> cars = carService.findCarByCategory(category);
		System.out.println("Cars: " + cars.size());
		return cars;
	}
}
