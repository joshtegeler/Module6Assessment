package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;


@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarHelper dao = new CarHelper();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String horsepower = request.getParameter("horsepower");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		Car carToUpdate = dao.searchForCarById(tempId);
		carToUpdate.setMake(make);
		carToUpdate.setModel(model);
		carToUpdate.setYear(year);
		carToUpdate.setHorsepower(horsepower);
				
		dao.updateCar(carToUpdate);

		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);


	}

}
