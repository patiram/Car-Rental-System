package mum.edu.carrentalsystem.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mum.edu.carrentalsystem.model.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer>, Serializable{

//	@Query(value = "insert into booking (id, car_id,user_id) VALUES (:id,:car_id,:user_id)")
//	public void insertBooking(@Param("id") int id,@Param("car_id") int car_id, @Param("user_id") int user_id);

}
