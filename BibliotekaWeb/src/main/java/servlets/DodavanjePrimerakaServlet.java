package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KnjigaManager;
import model.Knjiga;

/**
 * Servlet implementation class DodavanjePrimerakaServlet
 */
@WebServlet("/DodavanjePrimerakaServlet")
public class DodavanjePrimerakaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodavanjePrimerakaServlet() {
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
		KnjigaManager km=new KnjigaManager();
		
		/**Sada iz request-a hvatamo parametre, a sta imamo u respons-u gledamo
		 * na osnovu jsp stranice i tamo imamo samo jedan name**/
		int brPrim=Integer.parseInt(request.getParameter("brPrimeraka")); //sve ono sto vadimo iz request-a dolazi kao String!!!
		/**i sad mi za metodu treba id knjige koji cu naci preko Knjige u UnosKnjigeServlet
		 * i posto name parametar "knjiga" nije vidljiva van jsp strane, zato pozivam
		 * getSession(), znaci da cu imati dostupan taj name parametar i u sledecim requestim-a 
		 * a ne na jednom nivou**/
		
		/**Sada iz sesije vadim knjigu koja mi treba**/
		Knjiga k=(Knjiga) request.getSession().getAttribute("knjiga"); //kada vadim iz session-a, dobijem neki objekat koji kastujem 
		List<Integer> invBrojevi=km.dodajPrimerke(k.getIdKnjige(), brPrim);
		
		/**sada zelim da posaljem neku povratnu informaciju da li je uspelo ili ne**/
		String porukaPrimerci;
		if(invBrojevi!=null && invBrojevi.size()>0)
			porukaPrimerci="Primerci su sacuvani. Generisani su sledeci inventarni brojevi: ";
		else
			porukaPrimerci="Primerci nisu sacuvani";
		
		request.setAttribute("porukaPrim", porukaPrimerci);
		request.setAttribute("invBrojevi", invBrojevi); /**poslacu i listu da bih mogla da ispisem**/
		
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/DodavanjePrimeraka.jsp"); //na istu stranu se vracam
		rd.forward(request, response);
		//i sada se prebacujem na jsp opet
	}

}
