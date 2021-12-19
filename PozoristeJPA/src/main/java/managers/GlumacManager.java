package managers;

import javax.persistence.EntityManager;

import model.Glumac;
import model.Glumi;
import model.Uloga;

public class GlumacManager {
	
	public Glumac unesiGlumca(String ime, String prezime) {
		EntityManager em=JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Glumac g=new Glumac();
			g.setIme(ime);
			g.setPrezime(prezime);
			em.persist(g);
			
			em.getTransaction().commit();
			return g;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Glumi poveziGlumcaIUlogu(int idGlumca, int idUloge) {
		EntityManager em=JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			Glumac glumac=em.find(Glumac.class, idGlumca);
			Uloga u=em.find(Uloga.class, idUloge);
			
			Glumi g=new Glumi();
			g.setGlumac(glumac);
			g.setUloga(u);
			
			em.persist(g);
			em.getTransaction().commit();
			return g;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
