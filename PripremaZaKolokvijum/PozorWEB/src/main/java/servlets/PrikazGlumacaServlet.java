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
import model.Glumac;
import model.Glumi;
import model.Predstava;

/**
 * Servlet implementation class PrikazGlumacaServlet
 */
@WebServlet("/PrikazGlumacaServlet")
public class PrikazGlumacaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazGlumacaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idPredstave=Integer.parseInt(request.getParameter("idP"));
		PredstavaManager pm=new PredstavaManager();
		
		List<Glumi> uloge=pm.getUlogeZaPredstavu(idPredstave);
		Predstava p=pm.getPredstava(idPredstave);
		
		request.setAttribute("uloge", uloge);
		request.setAttribute("predstava", p);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/PrikazGlumaca.jsp");
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
