package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */


@Entity
public class InventoryDetails {
    @Id
    @GeneratedValue
    private int id;
    private String inventoryName; // Changed variable name to follow Java naming conventions
    private LocalDate startDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Salesman salesman;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<InventoryItem> listOfItems;

    // Constructors, getters, setters, and toString method

    public InventoryDetails() {
        super();
    }

    public InventoryDetails(int id, String inventoryName, LocalDate startDate, Salesman salesman,
            List<InventoryItem> listOfItems) {
        super();
        this.id = id;
        this.inventoryName = inventoryName;
        this.startDate = startDate;
        this.salesman = salesman;
        this.listOfItems = listOfItems;
    }

    public InventoryDetails(String inventoryName, LocalDate startDate, Salesman salesman,
            List<InventoryItem> listOfItems) {
        super();
        this.inventoryName = inventoryName;
        this.startDate = startDate;
        this.salesman = salesman;
        this.listOfItems = listOfItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public List<InventoryItem> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<InventoryItem> listOfItems) {
        this.listOfItems = listOfItems;
    }

    @Override
    public String toString() {
        return "InventoryDetails [id=" + id + ", inventoryName=" + inventoryName + ", startDate=" + startDate
                + ", salesman=" + salesman + ", listOfItems=" + listOfItems + "]";
    }
}

