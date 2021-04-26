public class Auto extends Vozilo implements java.io.Serializable {
	
	//private static final long serialVersionUID = 4833339643823108304L
	private static final long serialVersionUID = 3L;
	
	public Auto() {
		id = 1;
		brMesta = 0;
	}
  
	int getBrMesta() {
		return brMesta;
	}
	
	void setBrMesta(int pBrMesta) {
		brMesta = pBrMesta;
	}
	
	private int brMesta;
    
}