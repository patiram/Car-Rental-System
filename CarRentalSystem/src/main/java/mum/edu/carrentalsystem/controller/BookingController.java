package mum.edu.carrentalsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.carrentalsystem.model.Booking;
import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Users;
import mum.edu.carrentalsystem.service.BookingService;
import mum.edu.carrentalsystem.service.CarService;
import mum.edu.carrentalsystem.service.UserService;

@Controller
public class BookingController {

	@Autowired
	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private UserService userService;

	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String bookingPage(@ModelAttribute("booking") Booking booking, Model model) {
		List<Car> listCar = new ArrayList<Car>();
		listCar = carService.getAllCars();
		List<Car> listCarEconomy = new ArrayList<Car>();
		List<Car> listCarStandard = new ArrayList<Car>();
		List<Car> listLuxuary = new ArrayList<Car>();
		List<Car> listBusiness = new ArrayList<Car>();
		for (Car c : listCar) {
			// System.out.println(c.getCartype().getCategory());
			if (c.getCartype().getCategory().toString().equals("ECONOMIC")) {
				listCarEconomy.add(c);
			} else if (c.getCartype().getCategory().toString().equals("STANDARD")) {
				listCarStandard.add(c);
			} else if (c.getCartype().getCategory().toString().equals("LUXUARY")) {
				listLuxuary.add(c);
			} else
				listBusiness.add(c);

		}
		model.addAttribute("listCarEconomy", listCarEconomy);
		model.addAttribute("listBusiness", listBusiness);
		model.addAttribute("listLuxuary", listLuxuary);
		model.addAttribute("listCarStandard", listCarStandard);
		model.addAttribute("listCar", listCar);
		model.addAttribute("booking", booking);
		System.out.println(booking);
		return "booking";

		/*
		 * User user =
		 * (User)SecurityContextHolder.getContext().getAuthentication().
		 * getPrincipal(); String name = user.getUsername(); System.out.println(
		 * "This is user:"+user);
		 */

	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public @ResponseBody String redirectBookingPage(@ModelAttribute("booking") Booking booking, int id, Model model) {

		System.out.println("Here you go with CarId: " + id);
		Car car = carService.get(id);
		Users currentUser = new Users();
		if(isLoggedInWithSAML()!=true){
		System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(car);
		
		System.out.println(user.getUsername());
		currentUser = userService.findByUsername(user.getUsername());
		System.out.println(currentUser);		
		booking.setCar(car);
		booking.setUser(currentUser);
		System.out.println(currentUser.getId());
//		booking.setPickUpDate();
		//booking.setReturnDate(returnDate);
//		bookingService.confirmBooking(0,id,currentUser.getId());
		bookingService.newBooking(booking);
		return "redirect:/";
		}else{
			System.out.println("redirect for lolgin");
		}
		// String name = user.getUsername();
		
		// booking.setUser(user);
		// System.out.println("This is user:" + user);
		return "redirect:/";
		

		// System.out.println("Here you go");
		// System.out.println(booking.getCar().getId());
		// bookingService.newBooking(booking);
		// System.out.println("I am herer");
		// return "redirect:/";
	}
	
	public boolean isLoggedInWithSAML() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null) {
	        return false;
	    } else if (authentication.isAuthenticated() && (authentication.getCredentials() != null )) {
	        return true;
	    } else {
	        return false;
	    }        
	}


/*
 * @RequestMapping(value = "/booking", method = RequestMethod.POST) public
 * String redirectBookingPage(@ModelAttribute("booking") Booking booking, Model
 * model) { System.out.println("Here you go");
 * System.out.println(booking.getCar().getId());
 * bookingService.newBooking(booking); System.out.println("I am herer"); return
 * "redirect:/"; }
 */

/*
 * @RequestMapping(value = {"/bookingcarlist"}, method = RequestMethod.GET)
 * public String bookingCarlist(Booking booking, Model model) {
 * model.addAttribute("bookingcarlist",booking ); return "bookingcarlist"; }
 */
/*
 * @RequestMapping(value = { "/bookingcarlist" }, method = RequestMethod.POST)
 * public String redirectBookingCarlist(@ModelAttribute("booking") Booking
 * booking, Model model) { // model.addAttribute("bookingcarlist",booking );
 * System.out.println("I am Here" + booking.getFare()); return "bookingconfirm";
 * }
 * 
 * 
 * @RequestMapping(value = {"/bookingconfirm"}, method = RequestMethod.GET)
 * public String bookingconfirm(Booking booking, Model model) {
 * model.addAttribute("bookingconfirm",booking ); return "bookingconfirm"; }
 * 
 * 
 * @RequestMapping(value = { "/bookingconfirm" }, method = RequestMethod.POST)
 * public String redirectBookingconfirm(@ModelAttribute("booking") Booking
 * booking, Model model) { // model.addAttribute("bookingconfirm",booking );
 * System.out.println("I am Hereeeee" + booking.getFare()); return "booking"; }
 */
/*
 * @ModelAttribute("category") public Category[] getCategory() { return
 * Category.values(); }
 */
}
