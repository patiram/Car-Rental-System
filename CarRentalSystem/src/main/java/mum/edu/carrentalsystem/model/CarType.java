package mum.edu.carrentalsystem.model;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class CarType implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	private String model;
	@NotEmpty
	private String brand;
	@NotEmpty
	private String year;
	
	private boolean airConditioner;
	@Digits(message = "Seats field must be Greater than 0.", integer = 32767, fraction = 2)
	@NumberFormat(style = Style.NUMBER)
	@NotNull(message = "Seats field must not be blank.")
	@Min(1)
	private int seats;
	@Enumerated(EnumType.STRING)
	private Category category;
	@Valid
	@OneToOne(cascade = CascadeType.ALL)//(mappedBy = "cartype", fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName="id")
	private Rate rate;
	
	@OneToOne(mappedBy = "cartype")
	@JsonIgnore
	private Car car;

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}

	public String getYear() {
		return year;
	}

	public boolean isAirConditioner() {
		return airConditioner;
	}

	public int getSeats() {
		return seats;
	}

	public Rate getRate() {
		return rate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setAirConditioner(boolean airConditioner) {
		this.airConditioner = airConditioner;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

/*	@Override
	public String toString() {
		return "CarType [id=" + id + ", model=" + model + ", brand=" + brand + ", year=" + year + ", airConditioner="
				+ airConditioner + ", seats=" + seats + ", category=" + category + ", rate=" + rate + ", car=" + car
				+ "]";
	}*/

}
