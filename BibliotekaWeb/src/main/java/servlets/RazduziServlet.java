package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Zaduzenje;

/**
 * Servlet implementation class RazduziServlet
 */
@WebServlet("/RazduziServlet")
public class RazduziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RazduziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		ClanManager cm=new ClanManager();
		
		boolean ok=cm.razduzi(id);
		//hajde da update-ujemo tabelu tkd umesto linka sada prikazujemo datum razduzenja
		//zelim ponovo da dovucem ona zaduzenja clana
		if(ok) {
			Integer clanskiBroj=(Integer) request.getSession().getAttribute("clanskiBroj");
			//i sad ponovo pozivam sva zaduzenja i tako update-ujem
			List<Zaduzenje> zad=cm.vratiZaduzenja(clanskiBroj);
			request.setAttribute("zaduzenja", zad); //mora isto da se zove kao u preth stranici "zaduzenja"
			
			RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/PrikazZaduzenja.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
