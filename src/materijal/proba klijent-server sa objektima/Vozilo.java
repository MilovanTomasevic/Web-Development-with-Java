public class Vozilo implements java.io.Serializable {
	
	//private static final long serialVersionUID = 4833339643823108304L
	private static final long serialVersionUID = 4L;
	
	public Vozilo() {
		id = 0;
		upaljen = false;
	}
  
	int getId() {
		return id;
	}
	
	
	public void upali() {
		upaljen = true;
	}
  
	public void ugasi() {
		upaljen = false;
	}

	public boolean radi() {
		return upaljen;
	}
  
	protected int id;
	private boolean upaljen;
}