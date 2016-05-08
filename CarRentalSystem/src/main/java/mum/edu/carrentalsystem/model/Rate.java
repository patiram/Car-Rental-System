package mum.edu.carrentalsystem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Rate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(mappedBy = "rate")
	// @JoinColumn(referencedColumnName="id")
	@JsonIgnore
	private CarType cartype;
	@Digits(message = "Rate field must be Greater than 0.", integer = 32767, fraction = 2)
	@NumberFormat(style = Style.NUMBER)
	@NotNull(message = "Rate field must not be blank.")
	@Min(1)
	private double dailyRate;
	@Digits(message = "Rate field must be Greater than 0.", integer = 32767, fraction = 2)
	@NumberFormat(style = Style.NUMBER)
	@NotNull(message = "Rate field must not be blank.")
	@Min(1)
	private double weeklyRate;
	@Digits(message = "Rate field must be Greater than 0.", integer = 32767, fraction = 2)
	@NumberFormat(style = Style.NUMBER)
	@NotNull(message = "Rate field must not be blank.")
	@Min(1)
	private double monthlyRate;

	public CarType getCartype() {
		return cartype;
	}

	public void setCartype(CarType cartype) {
		this.cartype = cartype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public double getWeeklyRate() {
		return weeklyRate;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public void setWeeklyRate(double weeklyRate) {
		this.weeklyRate = weeklyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", cartype=" + cartype + ", dailyRate=" + dailyRate + ", weeklyRate=" + weeklyRate
				+ ", monthlyRate=" + monthlyRate + "]";
	}

}
