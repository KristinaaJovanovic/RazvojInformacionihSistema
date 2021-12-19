package beans;

import java.util.List;

import managers.PredstavaManager;
import model.Predstava;

public class PredstaveBean {
	List<Predstava> p;
	
	public PredstaveBean() {
		PredstavaManager pm=new PredstavaManager();
		p=pm.vratiSvePredstave();
	}

	public List<Predstava> getP() {
		return p;
	}

	public void setP(List<Predstava> p) {
		this.p = p;
	}
	
	

}
