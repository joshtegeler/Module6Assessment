package model;

/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Jan 30, 2024
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Car {
	@Id
	@GeneratedValue
	private int id;
	private String make;
	private String model;
	private String year;
	private String horsepower;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int id, String make, String model, String year, String horsepower) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.horsepower = horsepower;
	}

	public Car(String make, String model, String year, String horsepower) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.horsepower = horsepower;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}

	
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", horsepower=" + horsepower
				+ "]";
	}

	public String returnCarDetails() {
		return this.year + " " + this.make + " " + this.model + " making " + this.horsepower + " horsepower.";
	}
}
