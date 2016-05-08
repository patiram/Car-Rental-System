package mum.edu.carrentalsystem.service;


import java.io.Serializable;
import java.util.List;

import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Category;


public interface CarService extends Serializable{
    public void addCar(Car car);
    public List<Car> getAllCars();
	public Car get(long id);
	public void update(long id, Car car);
	public void delete(long id);
	List<Car> findCarByCategory(Category category);
}
