package mum.edu.carrentalsystem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.common.reflect.TypeToken;

import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Category;
import mum.edu.carrentalsystem.service.CarService;

@Controller
public class CarController {
	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public String addCar(@ModelAttribute Car car, Model model) {
		model.addAttribute("car", car);
		return "addCar";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String add(@Valid Car car, BindingResult result, Model model) {
		String view = "redirect:/";
		if (!result.hasErrors()) {
			/*
			 * FileOutputStream outputStream = null; String filePath =
			 * car.getPicture().getOriginalFilename();
			 */
			carService.addCar(car);
		} else {
			view = "addCar";
		}
		return view;
	}

	// Car List and RUD operation
	@RequestMapping(value = "/carList", method = RequestMethod.GET)
	public String readCarList(@ModelAttribute("car") Car car, Model model) {
		List<Car> carList = new ArrayList<Car>();
		String searchText = (String) model.asMap().get("searchText");
		String filterCriteria = (String) model.asMap().get("filterCriteria");
		if (searchText != null && filterCriteria != null) {

		} else if (filterCriteria != null) {

		} else if (searchText != null) {

		} else {
			carList = carService.getAllCars();
		}
		model.addAttribute("category",Arrays.asList(Category.values()));
		model.addAttribute("carList", carList);
		return "carList";
	}

	@RequestMapping(value = "/car-update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable long id, Model model) {
		Car car = carService.get(id);
		model.addAttribute(car);
		System.out.println(id);
		return "updateCar";

	}

	@RequestMapping(value = "/car-update/{id}", method = RequestMethod.POST)
	public String update(@Valid Car car, @PathVariable long id, BindingResult result) {
		if (result.hasErrors())
			return "redirect:/car-update" + id;

		carService.update(id, car);
		return "redirect:../carList";
	}

	@RequestMapping(value = "/car-delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable long id) {
		System.out.println("deleted id " + id);
		carService.delete(id);
		return "redirect:../carList";

	}
/*	@RequestMapping(value = "/carList/{category}", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Car> getCarInJSON(@PathVariable Category category, Model model) {
		System.out.println(category);
		List<Car> cars = carService.findCarByCategory(category);
		
		System.out.println("Cars: " + cars.size());
		return cars;
	}*/
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
}
