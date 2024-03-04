package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import model.InventoryDetails;
import model.InventoryItem;
import model.Salesman;

/**
 * Servlet implementation class CreateNewInventoryServlet
 */
@WebServlet("/createNewInventoryServlet")
public class CreateNewInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryItemHelper lih = new InventoryItemHelper();
		String listName = request.getParameter("inventoryName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String salesmanName = request.getParameter("salesmanName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<InventoryItem> selectedItemsInList = new ArrayList<InventoryItem>();
		
		if(selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				InventoryItem c = lih.searchForCarById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Salesman salesman = new Salesman(salesmanName);
		
		InventoryDetails sld = new InventoryDetails(0, salesmanName, ld, salesman, selectedItemsInList);
		
		sld.setListOfItems(selectedItemsInList);
		
		InventoryDetailsHelper slh = new InventoryDetailsHelper();
		slh.insertNewInventoryDetails(sld);
		
		getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
