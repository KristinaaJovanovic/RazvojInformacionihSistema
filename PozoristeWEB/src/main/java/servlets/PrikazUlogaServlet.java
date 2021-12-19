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
import model.Uloga;

/**
 * Servlet implementation class PrikazUlogaServlet
 */
@WebServlet("/PrikazUlogaServlet")
public class PrikazUlogaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazUlogaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		PredstavaManager pm=new PredstavaManager();
		
		Integer idPredstave=Integer.parseInt(request.getParameter("idPred")); //ovo je select name
		
		List<Uloga> uloge=pm.vratiSveUloge(idPredstave);
		
		//stampacemo poruku koja ce prikazati da li se metod uspesno izvrsio
		String poruka;
		if(uloge!=null)
			poruka="Uspesno je proslo!";
		else
			poruka="Nije uspesno!";
		
		request.setAttribute("poruka", poruka);
		request.getSession().setAttribute("uloge", uloge);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosGlumca.jsp");
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
