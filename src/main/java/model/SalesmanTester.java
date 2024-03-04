package model;

import java.util.List;

import controller.SalesmanHelper;
import model.Salesman;
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Feb 23, 2024
 */


public class SalesmanTester {
	public static void main(String[] args) {
		Salesman bill = new Salesman("Bill");
		SalesmanHelper sh = new SalesmanHelper();
		
		sh.insertSalesman(bill);
		
		Salesman jim = new Salesman("Jim");
		sh.insertSalesman(jim);
		
		List<Salesman> allSalesmen = sh.showAllSalesmen();
		for(Salesman a: allSalesmen) {
			System.out.println(a.toString());
		}
	}
}
