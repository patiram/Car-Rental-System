package mum.edu.carrentalsystem.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id @GeneratedValue
	private int id;
	/*@Temporal(TemporalType.TIMESTAMP)
	private Date pickUpDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	private boolean isAvailable;*/

	/*	private double fare;
	private boolean isPicked;
    private boolean isReturned;
    private boolean isDamaged;
    private boolean isPaid;
    private boolean isOverDue;*/
	@OneToOne
	@JoinColumn
	@JsonIgnore
	private Car car;
	@ManyToOne 
	@JoinColumn(referencedColumnName="id")
	@JsonIgnore
	private Users user;
	
/*	@OneToOne
	@JoinColumn(referencedColumnName="id")
	private CarType cartype;
*/	
	public int getId() {
		return id;
	}
/*	public Date getDueDate() {
		return dueDate;
	}*/
/*	public Date getReturnDate() {
		return returnDate;
	}
	public boolean isAvailable() {
		return isAvailable;
	}*/
/*	public double getFare() {
		return fare;
	}*/
	public Car getCar() {
		return car;
	}
/*	public Customer getCustomer() {
		return customer;
	}
*/	public void setId(int id) {
		this.id = id;
	}
/*	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}*/
/*	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}*/
/*	public void setFare(double fare) {
		this.fare = fare;
	}*/
	public void setCar(Car car) {
		this.car = car;
	}
/*	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getPickUpDate() {
		return pickUpDate;
	}
	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}*/
/*	public boolean isPicked() {
		return isPicked;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public boolean isDamaged() {
		return isDamaged;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public boolean isOverDue() {
		return isOverDue;
	}
	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public void setDamaged(boolean isDamaged) {
		this.isDamaged = isDamaged;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public void setOverDue(boolean isOverDue) {
		this.isOverDue = isOverDue;
	}*/
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
/*	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}*/
	@Override
	public String toString() {
		return "Booking [id=" + id + ", car=" + car + ", user=" + user + "]";
	}
	
}
