package beans;

import java.util.List;

import managers.ZanrManager;
import model.Zanr;

public class ZanrBean {
	List<Zanr> z;
	
	public ZanrBean() {
		ZanrManager zm=new ZanrManager();
		z=zm.vratiSveZanrove();
	}

	public List<Zanr> getZ() {
		return z;
	}

	public void setZ(List<Zanr> z) {
		this.z = z;
	}
	
	
}
