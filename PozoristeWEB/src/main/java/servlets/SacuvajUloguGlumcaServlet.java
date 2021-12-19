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
import model.Glumi;

/**
 * Servlet implementation class SacuvajUloguGlumcaServlet
 */
@WebServlet("/SacuvajUloguGlumcaServlet")
public class SacuvajUloguGlumcaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajUloguGlumcaServlet() {
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
		
		GlumacManager gm=new GlumacManager();
		Glumac g=(Glumac) request.getSession().getAttribute("glumac");
		Integer idGlumca=Integer.parseInt(request.getParameter(""));
		Integer idUloge=g.getIdGlumac();
		Glumi gl=gm.poveziGlumcaIUlogu(idGlumca, idUloge);
		
		String poruka;
		if(gl!=null)
			poruka="Uspesno je povezano!";
		else
			poruka="Nije uspesno povezano!";
		
		request.setAttribute("porukica", poruka);
		request.setAttribute("glumi", gl);
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/UnosGlumca.jsp");
		rd.forward(request, response);
	}

}
