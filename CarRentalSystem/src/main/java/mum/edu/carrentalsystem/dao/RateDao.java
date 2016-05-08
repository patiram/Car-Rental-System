package mum.edu.carrentalsystem.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;


import mum.edu.carrentalsystem.model.Rate;

public interface RateDao extends JpaRepository<Rate, Integer>, Serializable{

}
