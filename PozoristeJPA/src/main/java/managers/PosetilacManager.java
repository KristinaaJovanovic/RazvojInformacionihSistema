package managers;

import java.util.Date;

import javax.persistence.EntityManager;

import model.Izvodjenje;
import model.Karta;
import model.Mesto;
import model.Posetilac;

public class PosetilacManager {

	public Posetilac unesiPosetioca(String ime, String prezime) {
		EntityManager em=JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			Posetilac p=new Posetilac();
			p.setIme(ime);
			p.setPrezime(prezime);
			em.persist(p);
			em.getTransaction().commit();
			return p;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// za unetog klijenta
	public Karta rezervisiKartu(int idPosetioca,int idMesta, int idIzvodjenja) {
		EntityManager em=JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Karta k=new Karta();
			Mesto m=em.find(Mesto.class, idMesta);
			//k.setMesto(em.find(Mesto.class, idMesta));
			k.setPosetilac(em.find(Posetilac.class, idPosetioca));
			k.setIzvodjenje(em.find(Izvodjenje.class, idIzvodjenja));
			k.setDatumRezervacije(new Date());
			k.setMesto(m);
			
			em.persist(k);
			em.getTransaction().commit();
			return k;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

}
