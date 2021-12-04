package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Zaduzenje;

/**
 * Servlet implementation class UnosZaduzenjaServlet
 */
@WebServlet("/UnosZaduzenjaServlet")
public class UnosZaduzenjaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosZaduzenjaServlet() {
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
		
		Integer clanskiBroj=Integer.parseInt(request.getParameter("clanskiBroj"));
		Integer invBroj=Integer.parseInt(request.getParameter("invBroj"));
		
		ClanManager cm=new ClanManager();
		Zaduzenje z=cm.cuvanjeZaduzenja(clanskiBroj, invBroj);
		
		String poruka;
		if(z!=null)
			poruka="Uspesno je uneto zaduzenje";
		else
			poruka="Zaduzenje nije sacuvano. Doslo je do greske!";
		
		request.getSession().setAttribute("poruka", poruka); //dakle ovo sada saljemo nazad na formu
		request.getSession().setAttribute("zaduzenje", z); //upakovacu i Zaduzenje da bih mogla da ispisem neke podatke
	
		//RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosZaduzenja.jsp"); //vracamo se na istu str
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/PrikazZaduzenja.jsp");
		rd.forward(request, response);
	}

}
