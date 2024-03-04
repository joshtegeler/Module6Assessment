package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDetails;
import model.InventoryItem;
import model.Salesman;

/**
 * Servlet implementation class EditInventoryDetailsServlet
 */
@WebServlet("/editInventoryDetailsServlet")
public class EditInventoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInventoryDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryDetailsHelper dao = new InventoryDetailsHelper();
		InventoryItemHelper lih = new InventoryItemHelper();
		SalesmanHelper sh = new SalesmanHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		InventoryDetails inventoryToUpdate = dao.searchForInventoryDetailsById(tempId);

		String newInventoryName = request.getParameter("inventoryName");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String salesmanName = request.getParameter("salesmanName");
		//find our add the new shopper
		Salesman newSalesman = sh.findSalesman(salesmanName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		List<InventoryItem> selectedCarsInInventory = new ArrayList<InventoryItem>();
		try {
			//items are selected in list to add
			String[] selectedCars = request.getParameterValues("allInventoriesToAdd");
			

			for (int i = 0; i < selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				InventoryItem c = lih.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsInInventory.add(c);

			}
			inventoryToUpdate.setListOfItems(selectedCarsInInventory);
		} catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<InventoryItem> selectedItemsInList = new ArrayList<InventoryItem>();
			inventoryToUpdate.setListOfItems(selectedCarsInInventory);
		}

		inventoryToUpdate.setInventoryName(newInventoryName);
		inventoryToUpdate.setStartDate(ld);
		inventoryToUpdate.setSalesman(newSalesman);

		dao.updateInventory(inventoryToUpdate);

		getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
	}

}