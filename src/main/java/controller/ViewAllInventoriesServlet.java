package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InventoryDetails;

/**
 * Servlet implementation class ViewAllListsServlet
 */
@WebServlet("/viewAllInventoriesServlet")
public class ViewAllInventoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllInventoriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryDetailsHelper idh = new InventoryDetailsHelper();
		List<InventoryDetails> abc = idh.getInventories();
		request.setAttribute("allInventories", abc);
	
		if(abc.isEmpty()) {
			request.setAttribute("allInventories", "");
		}
		
		getServletContext().getRequestDispatcher("/car-by-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}