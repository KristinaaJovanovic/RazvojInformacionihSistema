package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Glumac;
import model.Glumi;
import model.Predstava;

public class PredstavaManager {
	
	public List<Glumi> getUlogeZaPredstavu(int idPredstave){
		EntityManager em=JPAUtil.getEntityManager();
		List<Glumi> uloge=em.createQuery("select g from Glumi g where g.uloga.predstava.idPredstava=:id").setParameter("id", idPredstave).getResultList();
		return uloge;
	}
	
	//TREBA DA STOJI IZNAD TABELE NAZIV PREDSTAVE
	public Predstava getPredstava(int idP) {
		EntityManager em=JPAUtil.getEntityManager();
		Predstava p=em.find(Predstava.class, idP);
		return p;
	}

}
