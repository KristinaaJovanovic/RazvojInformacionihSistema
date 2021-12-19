package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.GlumacManager;
import model.Glumac;

/**
 * Servlet implementation class UnosGlumcaServlet
 */
@WebServlet("/UnosGlumcaServlet")
public class UnosGlumcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosGlumcaServlet() {
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
		GlumacManager gm=new GlumacManager();
		
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		
		Glumac glumac=gm.unesiGlumca(ime, prezime);
		
		//Napravicemo poruku koja ce ispisivati da li je unos uspesan ili nije
		String poruka;
		if(glumac!=null)
			poruka="Uspesno ste uneli glumca!";
		else
			poruka="Doslo je do greske. Dodavanje nije uspelo!";
		
		
		request.setAttribute("poruka", poruka);
		request.getSession().setAttribute("glumac", glumac);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosGlumca.jsp");
		rd.forward(request, response);
	}

}
