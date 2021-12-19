package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Izvodjenje;
import model.Mesto;
import model.Predstava;
import model.Uloga;

public class PredstavaManager {
	
	public List<Izvodjenje> vratiIzvodjenja(String naziv){
		EntityManager em=JPAUtil.getEntityManager();
		List<Izvodjenje> izvodjenja=em.createQuery("select i from Izvodjenje i where i.predstava.naziv LIKE :naziv").setParameter("naziv", naziv).getResultList();
		return izvodjenja;
	}
	
	public List<Predstava> vratiPredstave(String ime, String prezime){
		EntityManager em=JPAUtil.getEntityManager();
		List<Predstava> predstave=em.createQuery("select p from Predstava p where p in(select g.uloga.predstava from Glumi g where g.glumac.ime LIKE :ime and g.glumac.prezime LIKE :prezime)").setParameter("ime", ime).setParameter("prezime", prezime).getResultList();
		return predstave;
	}
	
	public List<Mesto> vratiSlobodnaMesta(String naziv, Date datumIzvodjenja){
		EntityManager em=JPAUtil.getEntityManager();
		
		//nemamo kartu za to mesto
		List<Mesto> mesta=em.createQuery("select m from Mesto m inner join m.scena s join s.izvodjenjes i where i.predstava.naziv like :naziv and i.datum=:datumIzv and not exists(select k from Karta k where k.mesto=m and k.izvodjenje=i", Mesto.class).setParameter("datumIzv", datumIzvodjenja).setParameter("naziv", naziv).getResultList();
		return mesta;
	}
	
	public List<Predstava> vratiSvePredstave(){
		EntityManager em=JPAUtil.getEntityManager();
		List<Predstava> predstave=em.createQuery("select p from Predstava p").getResultList();
		return predstave;
		
	}
	
	public List<Uloga> vratiSveUloge(int idPredstave){
		EntityManager em=JPAUtil.getEntityManager();
		List<Uloga> uloge=em.createQuery("select u from Uloga u where u.predstava.idPredstava=:idPredstava").setParameter("idPredstava", idPredstave).getResultList();
		return uloge;
	}
	
	public List<Mesto> getSlobodnaMesta(int idIzvodjenja){
		EntityManager em=JPAUtil.getEntityManager();
		List<Mesto> m=em.createQuery("select m from Mesto m inner join m.scena s join s.izvodjenjes i where i.idIzvodjenje=:id and not exists(select k from Karta k where k.mesto=m and k.izvodjenje.idIzvodjenje=:id)").setParameter("id", idIzvodjenja).getResultList();
		return m;
	}
	
	

}
