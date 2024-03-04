package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */


@Entity
public class Salesman {
	@Id
	@GeneratedValue
	private int id;
	private String salesmanName;
	
	public Salesman() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salesman(int id, String salesmanrName) {
		super();
		this.id = id;
		this.salesmanName = salesmanrName;
	}
	public Salesman(String salesmanrName) {
		super();
		this.salesmanName = salesmanrName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	@Override
	public String toString() {
		return "Salesman [id=" + id + ", salesmanName=" + salesmanName + "]";
	}
	

}
