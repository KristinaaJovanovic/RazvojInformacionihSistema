package managers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Knjiga;
import model.Primerak;

public class KnjigaManager {
	
	public Knjiga unesiKnjigu(String naslov, String autor,String godinaIzdavanja, String izdavac) {
		EntityManager em=JPAUtil.getEntityManager();
		EntityTransaction et=null;
		
		try {
			Knjiga k=new Knjiga();
			k.setNaslov(naslov);
			k.setAutor(autor);
			k.setIzdavac(izdavac);
			k.setGodinaIzdanja(godinaIzdavanja);
			
			et=em.getTransaction();
			et.begin();
			
			em.persist(k);
			
			em.flush();
			et.commit();
			return k;
			
		}catch(Exception e) {
			e.printStackTrace();
			if(et!=null) {
				et.rollback();
			}
			return null;
		}finally {
			if(em.isOpen() && em!=null)
				em.close();
		}
		
		
		
	}
	
	public List<Knjiga> listaKnjiga(){
		EntityManager em=JPAUtil.getEntityManager();
		List<Knjiga> knjige=em.createQuery("select k from Knjiga k", Knjiga.class).getResultList();
		return knjige;
		
	}
	/**Za odgovarajuci id knjige, pronalazi knjigu u bazi*/
	public List<Integer> dodajPrimerke(int idKnjige, int brPrimeraka){
		ArrayList<Integer> invBrojevi=new ArrayList<Integer>();
		
		try {
			EntityManager em=JPAUtil.getEntityManager();
			Knjiga k=em.find(Knjiga.class, idKnjige);
			if(k!=null) {
				em.getTransaction().begin();
				for(int i=0;i<brPrimeraka;i++) {
					Primerak p=new Primerak();
					p.setKnjiga(k);
					em.persist(p);
					invBrojevi.add(p.getInvBroj());
				}
				em.getTransaction().commit();
			}
			return invBrojevi;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		KnjigaManager km=new KnjigaManager();
		//Knjiga k=km.unesiKnjigu("Zov Andjela", "Gijom Muso", "2009", "Laguna");
		
		/*if(k!=null)
			System.out.println("Knjiga je uspesno sacuvana!");
		else
			System.out.println("Greska!");*/
		
		List<Knjiga> knjige=km.listaKnjiga();
		for(Knjiga k: knjige)
			System.out.println(k);
		
		
		
	}

}
