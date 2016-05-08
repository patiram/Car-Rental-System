package mum.edu.carrentalsystem.service;

import java.io.Serializable;
import java.util.List;

import mum.edu.carrentalsystem.model.Customer;

public interface CustomerService extends Serializable{
	public Customer addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer findByLicenceNumber(String licence);
	public List<Customer> findAllCustomer();
	public List<Customer> findAllCustomerByFirstName(String firstname);
	public List<Customer> findAllCustomerByLastName(String lastname);
	public List<Customer> findAllByCustomerByZip(int zip);
	public List<Customer> findAllCustomerByState(String state);
	public Customer getCustomer(int id);
	

}
