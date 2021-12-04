package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.KnjigaManager;
import model.Knjiga;

/**
 * Servlet implementation class UnosKnjigeServlet
 */
@WebServlet(
		urlPatterns = { "/UnosKnjigeServlet" }, 
		initParams = { 
				@WebInitParam(name = "addresSuccess", value = "/Success.html"), 
				@WebInitParam(name = "addressError", value = "/Error.html")
		})
public class UnosKnjigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnosKnjigeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		KnjigaManager km=new KnjigaManager();
		List<Knjiga> knjige=km.listaKnjiga();
		
		PrintWriter pw=response.getWriter();
		for(Knjiga k: knjige) {
			pw.write(k.getNaslov());
		}
		pw.flush();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String naslov=request.getParameter("naslov");
		String autor=request.getParameter("autor");
		String izdavac=request.getParameter("izdavac");
		String godinaIzdanja=request.getParameter("godina");
		
		KnjigaManager km=new KnjigaManager();
		Knjiga k=km.unesiKnjigu(naslov, autor, godinaIzdanja, izdavac);
		
		//obavestenje da li sam uspesno unela
		//ServletConfig c=this.getServletConfig();
		//String path=null;
		//if(k!=null)
			//path=c.getInitParameter("addresSuccess");
		//else
			//path=c.getInitParameter("addressError");
		
		/**dodajemo poruku**/
		String poruka=null;
		if(k!=null)
			System.out.println("Knjiga je uspesno sacuvana. ID knjige je: "+k.getIdKnjige());
		else
			System.out.println("Doslo je do greske!");
		
		/**ova poruka moze da se upakuje i posalje na stranicu na koju vrsim redirekciju
		 * i tamo prikazem tu istu poruku**/
		request.setAttribute("porukaKnjiga", poruka);
		request.getSession().setAttribute("knjiga", k);
		
		/**Zapravo, sada zelim da prosledjujem kontrolu na jsp stranicu**/
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/DodavanjePrimeraka.jsp");
		rd.forward(request, response);
		
		
		
	}

}
