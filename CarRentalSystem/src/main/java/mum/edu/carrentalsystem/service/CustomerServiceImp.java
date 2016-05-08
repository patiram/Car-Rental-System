package mum.edu.carrentalsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.carrentalsystem.dao.CustomerDao;
import mum.edu.carrentalsystem.model.Customer;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService{
	
	
public CustomerServiceImp() {
	// TODO Auto-generated constructor stub
}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Autowired
	CustomerDao customerDao;
	

	@Override
	public Customer addCustomer(Customer customer) {
		byte[] image = customer.getLicenseImage().getBytes();
		customer.setImage(image);
		customerDao.save(customer);
		return customer;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
		
	}

	@Override
	public Customer findByLicenceNumber(String licence) {
		// TODO Auto-generated method stub
		return customerDao.findByLicenceNumber(licence);
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public List<Customer> findAllCustomerByFirstName(String firstname) {
		// TODO Auto-generated method stub
		
		return customerDao.findByFirstNameLike(firstname);
	}

	@Override
	public List<Customer> findAllByCustomerByZip(int zip) {
		// TODO Auto-generated method stub
		
		return customerDao.findByAddress_Zip(zip);
	}

	@Override
	public List<Customer> findAllCustomerByState(String state) {
		// TODO Auto-generated method stub
		return customerDao.findByAddress_State(state);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id);
		
	}


	@Override
	public List<Customer> findAllCustomerByLastName(String lastname) {
		// TODO Auto-generated method stub
		return customerDao.findByLastNameLike(lastname);
		
	}

}
