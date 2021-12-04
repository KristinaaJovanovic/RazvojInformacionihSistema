package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Clan;
import model.Kategorija;
import model.Primerak;
import model.Zaduzenje;

public class ClanManager {
	
	/**Svaki clan pripada tacno jednoj kategoriji i prilikom unosa moramo i o ovome
	 * da vodimo racuna**/
	public Clan unesiClana(String ime, String prezime, String adresa, Date datumRodjenja, Date datumUpisa, int idKategorije) {
		
		try {
			EntityManager em=JPAUtil.getEntityManager();
			em.getTransaction().begin();
			
			Kategorija k=em.find(Kategorija.class, idKategorije);
			Clan c=new Clan();
			c.setAdresa(adresa);
			c.setDatumRodjenja(datumRodjenja);
			c.setDatumUpisa(datumUpisa);
			c.setIme(ime);
			c.setPrezime(prezime);
			c.setKategorija(k);
			em.persist(c);
			
			em.getTransaction().commit();
			return c;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**Ja sad ne zelim od korisnika da mi utipkava broj kategorije nego
	 * zelim da mu izlistam sve kategorije**/
	
	public List<Kategorija> vratiSveKategorije(){
		EntityManager em=JPAUtil.getEntityManager();
		List<Kategorija> kategorije=(List<Kategorija>) em.createQuery("select k from Kategorija k").getResultList();
		return kategorije;
	}
	
	//cuvanje zaduzenja
	public Zaduzenje cuvanjeZaduzenja(int clanskiBroj, int invBroj) {
		
		try {
			EntityManager em=JPAUtil.getEntityManager();
			em.getTransaction().begin();

			
			/**Dobavicemo Clana na osnovu clanskog broja i Primerak na osnovu invntarnog broja**/
			Clan c=em.find(Clan.class, clanskiBroj);
			Primerak p=em.find(Primerak.class, invBroj);
			
			Zaduzenje z=new Zaduzenje();
			z.setClan(c);
			z.setPrimerak(p);
			z.setDatumZaduzenja(new Date()); //danasnji datum
			
			em.persist(z);
			em.getTransaction().commit();
			return z;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public List<Zaduzenje> vratiZaduzenja(int clanskiBroj){
		EntityManager em=JPAUtil.getEntityManager();
		
		try {
			List<Zaduzenje> zaduzenja=em.createQuery("select z from Zaduzenje z where z.clan.clanskibroj=:clanskiBr").setParameter("clanskiBr", clanskiBroj).getResultList();
			return zaduzenja;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean razduzi(int id) {
		
		try {
			EntityManager em=JPAUtil.getEntityManager();
			em.getTransaction().begin();
			
			//pronalazim zaduzenje
			Zaduzenje z=em.find(Zaduzenje.class, id);
			z.setDatumVracanja(new Date());
			em.merge(z);
			
			em.getTransaction().commit();
			return true;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
