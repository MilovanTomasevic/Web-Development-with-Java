public class Avion extends Vozilo implements java.io.Serializable {
	
	//private static final long serialVersionUID = 4833339643823108304L
	private static final long serialVersionUID = 2L;

	public Avion() {
		id = 2;
		brPutnika = 0;
	}
  
	int getBrPutnika() {
		return brPutnika;
	}
	
	void setBrPutnika(int pBrPutnika) {
		brPutnika = pBrPutnika;
	}
	
	private int brPutnika;
    
}