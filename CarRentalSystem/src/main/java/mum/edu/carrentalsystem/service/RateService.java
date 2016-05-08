package mum.edu.carrentalsystem.service;

import java.io.Serializable;

import mum.edu.carrentalsystem.model.CarType;

public interface RateService extends Serializable{
	public void addRateByCategory(double rate, CarType category);
	public void addDailyRateByCategory(double rate, CarType category);
	public void addWeeklyRateByCategory(double rate, CarType category);
	public void addMonthlyRateByCategory(double rate, CarType category);
	public void updateDailyRateByCategory(double rate, CarType category);
	public void updateWeeklyRateByCategory(double rate, CarType category);
	public void updateMonthlyRateByCategory(double rate, CarType category);
}
