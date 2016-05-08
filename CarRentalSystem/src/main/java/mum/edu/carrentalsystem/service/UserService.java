package mum.edu.carrentalsystem.service;

import java.io.Serializable;

import mum.edu.carrentalsystem.model.Users;

public interface UserService extends Serializable{
	public Users findByUsername(String username);

}
