package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ZanrManager;
import model.Predstava;
import model.Zanr;

/**
 * Servlet implementation class PrikazPredstavaZaZanrServlet
 */
@WebServlet("/PrikazPredstavaZaZanrServlet")
public class PrikazPredstavaZaZanrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazPredstavaZaZanrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ZanrManager zm=new ZanrManager();
		Integer idZanra=Integer.parseInt(request.getParameter("idZ"));
		
		List<Predstava> predstave=zm.getPredstave(idZanra);
		
		//treba Zanr da sacuvam 
		Zanr z=zm.vratiZanr(idZanra);
		request.setAttribute("odabraniZanr", z);
		request.setAttribute("predstave", predstave);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/PrikazZanrova.jsp");
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
