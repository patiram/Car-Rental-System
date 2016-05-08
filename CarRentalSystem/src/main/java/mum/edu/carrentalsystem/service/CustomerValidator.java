package mum.edu.carrentalsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import mum.edu.carrentalsystem.model.Customer;

@Component
public class CustomerValidator implements Validator {
	@Autowired
	private UserService userService;

	

	public boolean supports(Class clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "licenceNumber", "error.licenceNumber",
				"Licence Number is required.");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth",
		// "error.dateOfBirth", "dateOfBirth is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.phone", "Phone is required.");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "error.dateOfBirth", "dateOfBirth is required.");

		ValidationUtils.rejectIfEmpty(errors, "address.city", "error.address.city", "city is required.");
		ValidationUtils.rejectIfEmpty(errors, "address.street", "error.address.street", "street is required.");
		ValidationUtils.rejectIfEmpty(errors, "address.state", "error.address.state", "State is required.");
		ValidationUtils.rejectIfEmpty(errors, "address.zip", "error.address.zip", "Zip is required.");

		//Added To find the Username in the database by prabhat
		if (userService.findByUsername(customer.getUser().getUsername()) != null) {
//			System.out.println("I am here1");
			errors.rejectValue("user.username", "error.user.username","Username "+customer.getUser().getUsername()+" already exist");
		}
	}

}