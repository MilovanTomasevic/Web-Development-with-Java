// ===========================================================================
// Naziv: Podesavanja
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Rukovanje podesavanjima bitnim za biblioteku
// ===========================================================================
package e11988.server;

public class Podesavanja {

    // Get metode

	public static int getMAX_BROJ_KNJIGA() { return MAX_BROJ_KNJIGA; }
	public static int getROK() { return ROK; }
	public static int getSAVE_TIME() { return SAVE_TIME; }
	public static int getTCP_PORT() { return TCP_PORT; }


	// Set metode

	public static void setMAX_BROJ_KNJIGA(int MAX_BROJ_KNJIGA) { Podesavanja.MAX_BROJ_KNJIGA = MAX_BROJ_KNJIGA; }
	public static void setROK(int ROK) { Podesavanja.ROK = ROK; }
	public static void setSAVE_TIME(int SAVE_TIME) { Podesavanja.SAVE_TIME = SAVE_TIME; }
	public static void setTCP_PORT(int TCP_PORT) { Podesavanja.TCP_PORT = TCP_PORT; }

    public static String END = "Î";     // Alt + 0206
    public static String EXIT = "Í";    // Alt + 0205

    
    private static int MAX_BROJ_KNJIGA = 5;
    private static int ROK = 14;
    private static int SAVE_TIME = 60000; // 1 min
    private static int TCP_PORT = 9000;

}