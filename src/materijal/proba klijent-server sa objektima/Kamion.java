public class Kamion extends Vozilo implements java.io.Serializable {
	
	//private static final long serialVersionUID = 4833339643823108304L
	private static final long serialVersionUID = 1L;
	
	public Kamion() {
		id = 3;
		nosivost = 0;
	}
  
	int getNosivost() {
		return nosivost;
	}
	
	void setNosivost(int pNosivost) {
		nosivost = pNosivost;
	}
	
	private int nosivost;
    
}