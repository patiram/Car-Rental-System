package mum.edu.carrentalsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.userdetails.User;

@Entity
public class Users implements Serializable{
	@Id @GeneratedValue
	private int id;
	private String username;
	private String password;	
	private String role;

	/*	@OneToOne(mappedBy="user")
	private Customer customer;
*/
	@OneToOne(mappedBy = "user")
	private Customer customer;
/*	@OneToOne 
	@JoinColumn(name="customer_id")
	private Customer customer;
*/
	@OneToMany(mappedBy="user")
	@Cascade(value=(org.hibernate.annotations.CascadeType.ALL))
	private List<Booking> booking= new ArrayList<Booking>();

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
