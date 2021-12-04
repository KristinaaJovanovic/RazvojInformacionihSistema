package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;

/**
 * Servlet implementation class BrisanjeClanaServlet
 */
@WebServlet("/BrisanjeClanaServlet")
public class BrisanjeClanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrisanjeClanaServlet() {
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
		
		Integer clanskiBr=Integer.parseInt(request.getParameter("clanskiBr"));
		
		ClanManager cm=new ClanManager();
		boolean ok=cm.obrisiClana(clanskiBr);
		
		String poruka;
		if(ok)
			poruka="Uspesno je obrisan clan!";
		else
			poruka="Nije uspelo brisanje clana!";
		
		request.setAttribute("poruka", poruka);
		
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/BrisanjeClana.jsp");
		rd.forward(request, response);
	}

}
