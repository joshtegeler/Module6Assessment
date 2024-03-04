package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */


@Entity
@Table(name="items")
public class InventoryItem {
	@Id
	@GeneratedValue
	private int id;
	private String make;
	private String model;
	private String year;
	private String horsepower;

	public InventoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryItem(int id, String make, String model, String year, String horsepower) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.horsepower = horsepower;
	}

	public InventoryItem(String make, String model, String year, String horsepower) {
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
		return "InventoryItem [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", horsepower="
				+ horsepower + "]";
	}

	public String returnInventoryDetails() {
		return this.make + ": " + this.year + " " + this.model + " " + this.horsepower;
	}
}
