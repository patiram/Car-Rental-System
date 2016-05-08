package mum.edu.carrentalsystem.service;

import org.springframework.beans.factory.annotation.Autowired;


import mum.edu.carrentalsystem.dao.UserDao;
import mum.edu.carrentalsystem.model.Users;

public class UserServiceImp implements UserService {

	private static final long serialVersionUID = 1L;
	 @Autowired
	UserDao userDao;

	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);

	}

}
