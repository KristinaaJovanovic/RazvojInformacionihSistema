package beans;

import java.util.List;

import managers.ClanManager;
import model.Kategorija;

public class KategorijeBean {
	
	private List<Kategorija> k;
	
	public KategorijeBean() {
		ClanManager cm=new ClanManager();
		k=cm.vratiSveKategorije();
	}

	public List<Kategorija> getK() {
		return k;
	}

	public void setK(List<Kategorija> k) {
		this.k = k;
	}
	
	

}
