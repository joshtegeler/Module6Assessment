package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;


@WebServlet("/addItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String horsepower = request.getParameter("horsepower");
		if (make.isEmpty() || model.isEmpty() || year.isEmpty() || horsepower.isEmpty() || make == null || model == null || year == null || horsepower == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			Car c = new Car(make, model, year, horsepower);
			CarHelper dao = new CarHelper();
			dao.insertCar(c);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
