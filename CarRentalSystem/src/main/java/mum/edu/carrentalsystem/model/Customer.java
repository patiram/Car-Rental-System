package mum.edu.carrentalsystem.model;



import java.io.Serializable;
import java.util.ArrayList;

import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private int id;
	//@NotBlank(message = "Please enter the First Name.")
	private String firstName;
	//@NotBlank(message = "Please enter the Last Name.")
	private String lastName;
	//@DateTimeFormat(pattern="MM/dd/yyyy")
	//@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	//@NotEmpty(message = "Please enter teh Licence Number.")
	private String licenceNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	@Lob
	private byte[] image;
	private transient CommonsMultipartFile  licenseImage = null;
	//@NotEmpty(message = "Please enter the email addresss.")
	private String email;
	private String phone;
/*	@OneToMany(mappedBy="customer")
	@Cascade(value=(org.hibernate.annotations.CascadeType.ALL))
	private List<Booking> booking;
*/	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName="id")
	private Users user; 

	public String getUrlPicture() {
		if (this.licenseImage != null)
			return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(this.image);
		return "";
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getLicenseNumber() {
		return this.licenceNumber;
	}
	public CommonsMultipartFile getLicenseImage() {
		return licenseImage;
	}
	public Address getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	public void setLicenseImage(CommonsMultipartFile licenseImage) {
		this.licenseImage = licenseImage;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
