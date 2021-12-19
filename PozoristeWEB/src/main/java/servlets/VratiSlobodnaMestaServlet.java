package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class VratiSlobodnaMestaServlet
 */
@WebServlet("/VratiSlobodnaMestaServlet")
public class VratiSlobodnaMestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VratiSlobodnaMestaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PredstavaManager pm=new PredstavaManager();
		
		String nazivPredstave=request.getParameter("nazivPredstave");
		//String datum=request.getParameter("datumIzvodjenja");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date datumIzvodjenja=sdf.parse(request.getParameter("datumIzvodjenja"));
			List<Mesto> slobodnaMesta=pm.vratiSlobodnaMesta(nazivPredstave, datumIzvodjenja);

			String poruka;
			if(slobodnaMesta!=null)
				poruka="Ima slobodnih mesta!";
			else
				poruka="Nema slobodnih mesta!";
			
			request.setAttribute("poruka", poruka);
			request.setAttribute("slobodnaMesta", slobodnaMesta);
			
			RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/VratiSlobodnaMesta.jsp");
			rd.forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
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
