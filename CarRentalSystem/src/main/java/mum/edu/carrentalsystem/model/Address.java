package mum.edu.carrentalsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Address {
@Id @GeneratedValue
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
//@NotBlank(message = "Please enter the street.")
private String street;
//@NotBlank(message = "Please enter the City.")
private String city;
//@NotEmpty(message = "Please enter the State.")
private String state;
//@NumberFormat(style = Style.NUMBER)
//@NotNull(message = "Please enter the Zip.")
private int zip;

public Address() {
	super();
}
public Address(String street, String city, String state, int zip) {
	super();
	this.street = street;
	this.city = city;
	this.state = state;
	this.zip = zip;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getZip() {
	return zip;
}
public void setZip(int zip) {
	this.zip = zip;
}

}
