package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Clan;
import model.Kategorija;

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

}
