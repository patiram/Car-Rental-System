package mum.edu.carrentalsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.edu.carrentalsystem.model.Customer;
import mum.edu.carrentalsystem.service.CustomerService;
import mum.edu.carrentalsystem.service.CustomerValidator;
import mum.edu.carrentalsystem.service.UserService;

//@RequestMapping(value = {"/customer"})
@Controller
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	CustomerValidator validator;
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = {"/customerList"}, method = RequestMethod.GET)
	public String getAllCustomer(Model model) {
		System.out.println("&&&&/get customer controller called ");
		List <Customer> a=customerService.findAllCustomer();
		model.addAttribute("customers",a);
//		System.out.println("vallue+ "+a.get(0).getEmail());
//		logger.info("retrieving all teh custumers  {}.");
		return "customerlist";
		
	}
	
	@RequestMapping(value = {"/customerAdd"}, method = RequestMethod.POST)
	public String addCustomer( @ModelAttribute(value="customer" ) Customer customer, Model model,BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) {
		System.out.println("@@@@@@@@/Add customer controller called ");
//		System.out.println("aaaa"+customer.getUser().getLogin());
		validator.validate(customer, bindingResult);
/*		if(userService.findBylogin(customer.getUser().getLogin()) != null)
		{
			redirectAttributes.addFlashAttribute("message", customer.getUser().getLogin());
			return "redirect:/customer/add";	
		}*/
		
		System.out.println("I am Hereadsa"+userService.findByUsername(customer.getUser().getUsername())+"asdad");

		  if (bindingResult.hasErrors()) {
			  return "addcustomer";
		  }
		  System.out.println("nooo");
			customerService.addCustomer(customer);
			
			logger.info("the customer is added and the id is  {}.", customer.getId());
			return "redirect:/customerList";
	}
	
	
	@RequestMapping(value = {"/customerAdd"}, method = RequestMethod.GET)
	public String showAddCustomer(@ModelAttribute Customer customer, Model model) {
		System.out.println("@@@@@@@@/showAdd customer controller called ");
		
		logger.info("the customer is added and the id is  {}.");
		return "addcustomer";
		
	}
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
	public String getCustomer(@PathVariable int id, Model model) {
		
		model.addAttribute("customer", customerService.getCustomer(id) );
		System.out.println("@@@@@@@@/display customer controller called ");
		logger.info("teh customer id is {}.", id);
		return "displaycustomer";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@ModelAttribute(value="customer" ) Customer customer, @PathVariable int id,Model model,BindingResult bindingResult) {

		validator.validate(customer, bindingResult);
		
		  if (bindingResult.hasErrors()) {
			  return "displaycustomer";
		  }
		  System.out.println("nooo");
			logger.info("the customer is added and the id is  {}.", customer.getId());
			customer.setId(id);
			customerService.updateCustomer(customer);
			return "redirect:/customerList";
////
	}
	@RequestMapping(value="/customer/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		customerService.deleteCustomer(customerService.getCustomer(id));
		return "redirect:/customerList";
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String del(@PathVariable int id,Model model) {
		System.out.println("DDDDDELETE");
		customerService.deleteCustomer(customerService.getCustomer(id));
		return "redirect:/customerList";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String askSearch(Model model) {
		System.out.println("search called redirection");
		return "searchcustomer";
	}
	
	@RequestMapping(value="/search/", method=RequestMethod.POST)
	public String search(@RequestParam("str") String str,@RequestParam("search") String search,Model model) {
		System.out.println("search switchiiing"+str+search);
		switch (search){ 
		case  "1": return 
				"redirect:/licence/"+str;
		case  "2": return 
				"redirect:/firstname/"+str;
		case  "3": return 
				"redirect:/lastname/"+str;
		case  "4": return 
				"redirect:/zip/"+str;
		case  "5": return 
				"redirect:/state/"+str;
		default: return "searchcustomer";
		}
	}
	
	
	@RequestMapping(value="/licence/{licence}", method=RequestMethod.GET)
	public String getCustomerByLicence(@PathVariable String licence,Model model) {
		System.out.println("licence"+licence);
		model.addAttribute("customer",customerService.findByLicenceNumber(licence));
		return "customersingle";
	}
	
	@RequestMapping(value="/firstname/{firstname}", method=RequestMethod.GET)
	public String getCustomerByFirstName(@PathVariable String firstname,Model model) {
		model.addAttribute("customers",customerService.findAllCustomerByFirstName(firstname));
		return "customerlist";
	}
	@RequestMapping(value="/lastname/{lastname}", method=RequestMethod.GET)
	public String getCustomerByLastName(@PathVariable String lastname,Model model) {
		model.addAttribute("customers",customerService.findAllCustomerByLastName(lastname));
		return "customerlist";
	}
	@RequestMapping(value="/zip/{zip}", method=RequestMethod.GET)
	public String getCustomerByZip(@PathVariable String zip,Model model) {
		int zoo = 0;
		String a="customerlist";
		try {
		      zoo = Integer.parseInt(zip);
		} catch (NumberFormatException e) {
		      //Will Throw exception!
		      //do something! anything to handle the exception.
			a="searchcustomer";
		}
				
		model.addAttribute("customers",customerService.findAllByCustomerByZip(zoo));
		return a;
	}
	@RequestMapping(value="/state/{state}", method=RequestMethod.GET)
	public String getCustomerByState(@PathVariable String state,Model model) {
		model.addAttribute("customers",customerService.findAllCustomerByState(state));
		System.out.println(customerService.findAllCustomerByState(state).get(0).getLastName());
		
		return "customerlist";
	}

	

}
