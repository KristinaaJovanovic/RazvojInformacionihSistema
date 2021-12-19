package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PredstavaManager;
import model.Mesto;

/**
 * Servlet implementation class VratiSlobodnaMServlet
 */
@WebServlet("/VratiSlobodnaMServlet")
public class VratiSlobodnaMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VratiSlobodnaMServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PredstavaManager pm=new PredstavaManager();
		Integer idIzvodjenja=Integer.parseInt(request.getParameter("id"));
		
		List<Mesto> mesta=pm.getSlobodnaMesta(idIzvodjenja);
		
		request.getSession().setAttribute("id", idIzvodjenja);
		request.setAttribute("mesta", mesta);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/Rezervacija.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
