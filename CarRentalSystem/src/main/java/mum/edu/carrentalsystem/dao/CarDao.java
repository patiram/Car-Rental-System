package mum.edu.carrentalsystem.dao;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Category;

public interface CarDao extends JpaRepository<Car, Long>, Serializable{

	List<Car> findAll();

	Car findById(long id);
	
	@Query("FROM Car c WHERE c.cartype.category=:category")
	List<Car> findByCarType(@Param(value = "category") Category category);


}
