package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.PosetilacManager;
import model.Posetilac;

/**
 * Servlet implementation class UnosPosetiocaServlet
 */
@WebServlet("/UnosPosetiocaServlet")
public class UnosPosetiocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosPosetiocaServlet() {
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
		
		PosetilacManager pm=new PosetilacManager();
		
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		Posetilac p=pm.unesiPosetioca(ime, prezime);
		
		//Stampacemo poruku koja ce ispisivati da li je uspesno izvrsen metod
		String poruka;
		if(p!=null)
			poruka = "Posetilac: "+p.getIme()+" "+p.getPrezime()+" je uspesno unet u bazu";
		else
			poruka="Doslo je do greske. Posetilac nije unet u bazu!";
		
		request.setAttribute("poruka", poruka);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosPosetioca.jsp");
		rd.forward(request, response);
		
	}

}
