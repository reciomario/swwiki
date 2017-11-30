package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.Person;
import model.Planet;
import model.Specie;
import model.Starship;
import model.Vehicle;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/dispatcher")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispatcher() {
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
		request.getParameter("category");
		String type = request.getParameter("category");
		PrintWriter writer = response.getWriter();
		
		//For each type, different elements will be shown
		List<String> listToShow = new ArrayList<String>();
		
		//********** FILMS
		if(type.equals("films")) {
			Film film = new Film();
			for(Film a : film.getAll()) 
				listToShow.add(a.getTitle());
		} else if(type.equals("species")) {
			Specie specie = new Specie();
			for(Specie a : specie.getAll()) 
				listToShow.add(a.getName());
		} else if(type.equals("planets")) {
			Planet planet = new Planet();
			for(Planet a : planet.getAll()) 
				listToShow.add(a.getName());
		}else if (type.equals("people")) {
			Person person = new Person();
			for(Person a : person.getAll()) 
				listToShow.add(a.getName());
		} else if(type.equals("starships")) {
			Starship star = new Starship();
			for(Starship a : star.getAll()) 
				listToShow.add(a.getName());
		}else if(type.equals("vehicles")) {
			Vehicle vehi = new Vehicle();
			for(Vehicle a : vehi.getAll()) 
				listToShow.add(a.getName());
		}
		
		//Displaying in the screen
		for(String a : listToShow) 
			writer.println("<p>" + a + "<p>");

		//Closing
		writer.close();
		doGet(request, response);
	}

}
