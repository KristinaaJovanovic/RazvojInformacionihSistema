package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PosetilacManager;
import managers.PredstavaManager;
import model.Karta;

/**
 * Servlet implementation class RezervacijeServlet
 */
@WebServlet("/RezervacijeServlet")
public class RezervacijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezervacijeServlet() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PosetilacManager pm=new PosetilacManager();
		
		Integer idP=Integer.parseInt(request.getParameter("idP"));
		Integer idIzvodjenja=(Integer) request.getSession().getAttribute("id");
		Integer idMesta=(Integer) request.getSession().getAttribute("idM");
			
		Karta k=pm.rezervisiKartu(idP, idMesta, idIzvodjenja);
		
		String poruka;
		if(k!=null)
			poruka="Uspesno ste rezervisali";
		else
			poruka="Desila se neka greska prilikom rezervacije";
		
		request.setAttribute("poruka", poruka);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosRezervacije.jsp");
		rd.forward(request, response);
	}

}
