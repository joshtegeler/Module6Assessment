package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDetails;

/**
 * Servlet implementation class InventoryNavigationServlet
 */
@WebServlet("/inventorynavigationServlet")
public class InventoryNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryNavigationServlet() {
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
		String act = request.getParameter("doThisToInventory");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				InventoryDetails inventoryToDelete = dao.searchForInventoryDetailsById(tempId);
				dao.deleteInventory(inventoryToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				InventoryDetails inventoryToEdit = dao.searchForInventoryDetailsById(tempId);
				request.setAttribute("inventoryToEdit", inventoryToEdit);
				request.setAttribute("month", inventoryToEdit.getStartDate().getMonthValue());
				request.setAttribute("date", inventoryToEdit.getStartDate().getDayOfMonth());
				request.setAttribute("year", inventoryToEdit.getStartDate().getYear());
				InventoryItemHelper daoForItems = new InventoryItemHelper();
				
				request.setAttribute("allInventories", daoForItems.showAllCars());
							
				if(daoForItems.showAllCars().isEmpty()){
						request.setAttribute("allInventories", " ");
				}
				getServletContext().getRequestDispatcher("/edit-inventory.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllInventoriesServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-inventory.jsp").forward(request, response);
		}
		
		
		
	}

}
