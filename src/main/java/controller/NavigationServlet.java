package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;


@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarHelper dao = new CarHelper();
		String act = request.getParameter("doThisToCar");

		// after all changes, redirect to the viewAllCars servlet
		String path = "/viewAllCarsServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car itemToDelete = dao.searchForCarById(tempId);
				dao.deleteCar(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			} catch (NullPointerException n) {
				System.out.println("Error");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car itemToEdit = dao.searchForCarById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-item.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			} 
		} else if (act.equals("add")) {
			path = "/index.html";

		} 

		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
