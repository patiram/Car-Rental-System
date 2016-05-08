package mum.edu.carrentalsystem.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import mum.edu.carrentalsystem.model.Booking;
import mum.edu.carrentalsystem.model.Car;
import mum.edu.carrentalsystem.model.CarType;
import mum.edu.carrentalsystem.model.Customer;

public interface BookingService extends Serializable{
    public int newBooking(Booking booking);
    public int updateBooking(Booking booking);
    public int deleteBooking(Booking booking);
    public List<Booking> getAllBooking();
    public Booking findBookingByPickUpDate(Date pickUpDate);
    public Booking findBookingByDueDate(Date dueDate);
    public Booking findBookingByReturnDate(Date returnDate);
    public Booking findBookingByCar(Car car);
    public Booking findBookingByCustomer(Customer customer);
    public Booking findBookingByCategory(CarType category);
	public void confirmBooking(int id, int car_id, int user_id);
}
