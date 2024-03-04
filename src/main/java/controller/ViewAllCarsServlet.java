package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewAllCarsServlet")
public class ViewAllCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewAllCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CarHelper dao = new CarHelper();
		
		request.setAttribute("allCars", dao.showAllCars());
		
		String path = "/car.jsp";
		
		if(dao.showAllCars().isEmpty()){
			//if there's nothing in the list, redirect the user to the index to add an item
			System.out.println("There are no cars.");
			path = "/index.html";
		
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
