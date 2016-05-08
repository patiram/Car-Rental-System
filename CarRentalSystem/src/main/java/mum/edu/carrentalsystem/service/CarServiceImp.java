package mum.edu.carrentalsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.carrentalsystem.dao.CarDao;
import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.Category;


public class CarServiceImp implements CarService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private CarDao carDao;

	@Autowired
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public void addCar(Car car) {
		// TODO Auto-generated method stub
		byte[] pictureBytes = car.getCarPicture().getBytes();
		car.setPicture(pictureBytes);
		carDao.save(car);
	}

	@Override
	public List<Car> getAllCars() {
		// TODO Auto-generated method stub
		return carDao.findAll();
	}

	@Override
	public Car get(long id) {
		// TODO Auto-generated method stub
		return carDao.findById(id);
	}

	@Override
	public void update(long id, Car car) {
		// TODO Auto-generated method stub
		car.setId(id);
		byte[] pic = car.getCarPicture().getBytes();
		car.setPicture(pic);
		carDao.save(car);
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		carDao.delete(id);
	}

	@Override
	public List<Car> findCarByCategory(Category category) {
		// TODO Auto-generated method stub
		return carDao.findByCarType(category);
	}


	
}
