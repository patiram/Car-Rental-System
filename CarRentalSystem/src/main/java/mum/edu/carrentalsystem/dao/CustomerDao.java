package mum.edu.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.carrentalsystem.model.Customer;
@Transactional
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	 public List<Customer> findByFirstNameLike(String firstName);
	 public List<Customer> findByLastNameLike(String firstName);
	 public List<Customer> findByAddress_Zip(int zip);
	 public Customer findByLicenceNumber(String licenceNumber);
	 public List<Customer> findByAddress_State(String state);
	 public Customer findById(int id);

}
