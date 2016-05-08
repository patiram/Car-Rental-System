package mum.edu.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.edu.carrentalsystem.model.CarType;
import mum.edu.carrentalsystem.model.Rate;
import mum.edu.carrentalsystem.service.RateService;

@Controller
public class RateController {

	
	@RequestMapping(value="/addRate", method = RequestMethod.GET)
	public String addCar(@ModelAttribute Rate rate, Model model){
		model.addAttribute("rate", rate);
		return "addRate";
	}
	@RequestMapping(value="/addRate", method = RequestMethod.POST)
	public String add(@ModelAttribute Rate rate,BindingResult result, Model model){
        
		String view = "redirect:/";
		System.out.println("I am Here");
		return view;
	}

}
