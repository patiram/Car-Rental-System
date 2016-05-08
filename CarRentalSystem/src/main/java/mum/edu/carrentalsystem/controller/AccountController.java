package mum.edu.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AccountController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model){
		return "account/login";
	}
	
	
	@RequestMapping(value = "loginfailed", method = RequestMethod.GET)
	public String loginfailed(Model model){
		model.addAttribute("error","Sorry, Login failed !");
		return "account/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model){
		//model.addAttribute("error","Log out successful");
		return "account/login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logoutuser(Model model){
		//model.addAttribute("error","true");
		return "account/login";
	}
}
