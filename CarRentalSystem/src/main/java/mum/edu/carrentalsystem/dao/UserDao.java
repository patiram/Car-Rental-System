package mum.edu.carrentalsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mum.edu.carrentalsystem.model.Users;
@Repository
public interface UserDao extends JpaRepository<Users, Integer>{
	@Query("FROM Users where username=:username")
	public Users findByUsername(@Param(value = "username") String username);

}
