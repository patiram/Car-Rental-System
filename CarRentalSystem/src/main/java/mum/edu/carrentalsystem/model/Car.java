package mum.edu.carrentalsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private long id;

	@NotEmpty
	private String registrationId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirationDate;
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "id")
	//@JsonIgnore
	private CarType cartype;
	@NotEmpty
	private String description;
	@Lob
	private byte[] picture;
	private transient CommonsMultipartFile carPicture = null;
	
/*	@OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private  Booking booking;
*/
	public Car() {
		super();
	}

	/*
	 * public Car(String registrationID, String model, String year, Category
	 * category) { this.registrationId = registrationID; this.model = model;
	 * this.year = year; this.category = category; }
	 */
	public String getUrlPicture() {
		if (this.picture != null)
			return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(this.picture);
		return "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public CarType getCartype() {
		return cartype;
	}

	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

/*	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}*/

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
		/* this.pictureName = picture.getOriginalFilename(); */
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public CommonsMultipartFile getCarPicture() {
		return carPicture;
	}

	public void setCarPicture(CommonsMultipartFile carPicture) {
		this.carPicture = carPicture;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", registrationId=" + registrationId + ", registeredDate=" + registeredDate
				+ ", expirationDate=" + expirationDate + ", cartype=" + cartype + ", description=" + description
				+ ", picture=" + Arrays.toString(picture)+ "]";
	}



}
