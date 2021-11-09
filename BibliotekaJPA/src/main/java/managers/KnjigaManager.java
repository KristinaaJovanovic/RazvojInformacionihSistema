package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Knjiga;

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
