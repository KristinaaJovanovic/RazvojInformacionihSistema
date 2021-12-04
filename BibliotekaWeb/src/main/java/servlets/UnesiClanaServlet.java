package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ClanManager;
import model.Clan;

/**
 * Servlet implementation class UnesiClanaServlet
 */
@WebServlet("/UnesiClanaServlet")
public class UnesiClanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnesiClanaServlet() {
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
		String ime=request.getParameter("ime");
		String prezime=request.getParameter("prezime");
		String adresa=request.getParameter("adresa");
		Integer idK=Integer.parseInt(request.getParameter("idKat"));
		
		//posto datume dobijam kao stringove, moracu ovako
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datumRodjenja=null;
		Date datumUpisa=null;
		
		try {
			datumRodjenja=sdf.parse(request.getParameter("datumRodjenja"));
			datumUpisa=sdf.parse(request.getParameter("datumUpisa"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ClanManager cm=new ClanManager();
		Clan c=cm.unesiClana(ime, prezime, adresa, datumRodjenja, datumUpisa, idK);
		
		String poruka=null;
		if(c!=null)
			System.out.println("Clan je uspesno sacuvan. ID clana je: ");
		else
			System.out.println("Doslo je do greske");
		
	
		request.setAttribute("poruka", poruka);
		request.setAttribute("clan", c);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnesiClana.jsp");
		rd.forward(request, response);
	}

}
