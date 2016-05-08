package mum.edu.carrentalsystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.edu.carrentalsystem.dao.BookingDao;
import mum.edu.carrentalsystem.dao.CarDao;
import mum.edu.carrentalsystem.model.Booking;
import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.CarType;
import mum.edu.carrentalsystem.model.Customer;

public class BookingServiceImp implements BookingService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private BookingDao bookingDao;
	
	@Autowired
	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	@Override
	public int newBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingDao.save(booking);
		return 0;
	}

	@Override
	public int updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByPickUpDate(Date pickUpDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByDueDate(Date dueDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByReturnDate(Date returnDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByCar(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking findBookingByCategory(CarType category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmBooking(int id, int car_id, int user_id) {
		// TODO Auto-generated method stub
		//bookingDao.insertBooking(id, car_id, user_id);
		
	}


}
