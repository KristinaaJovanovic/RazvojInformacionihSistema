package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Predstava;
import model.Zanr;

public class ZanrManager {
	
	public List<Zanr> vratiSveZanrove(){
		EntityManager em=JPAUtil.getEntityManager();
		List<Zanr> zanrovi=em.createQuery("select z from Zanr z").getResultList();
		return zanrovi;
	}
	
	public List<Predstava> getPredstave(int idZanra){
		EntityManager em=JPAUtil.getEntityManager();
		List<Predstava> predstave=em.createQuery("select p from Predstava p inner join p.zanrPredstaves z where z.zanr.idZanr=:idZanra").setParameter("idZanra", idZanra).getResultList();
		return predstave;
	}
	
	public Zanr vratiZanr(int idZanra) {
		EntityManager em=JPAUtil.getEntityManager();
		Zanr z=em.find(Zanr.class, idZanra);
		return z;
	}

}
