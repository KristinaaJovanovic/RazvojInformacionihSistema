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
import model.Izvodjenje;

/**
 * Servlet implementation class UnosPredstaveServlet
 */
@WebServlet("/UnosPredstaveServlet")
public class UnosPredstaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosPredstaveServlet() {
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
		PredstavaManager pm=new PredstavaManager();
		
		String nazivPredstave=request.getParameter("nazivPredstave");
		List<Izvodjenje> izvodjenja=pm.vratiIzvodjenja(nazivPredstave);
		
		String poruka;
		if(izvodjenja!=null)
			poruka="Uspesno smo dobavili izvodjenja predstave sa nazivom: "+nazivPredstave;
		else
			poruka="Desila se greska!";
		
		request.setAttribute("poruka", poruka);
		request.setAttribute("izvodjenja", izvodjenja);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosPredstave.jsp");
		rd.forward(request, response);
		
	}

}
