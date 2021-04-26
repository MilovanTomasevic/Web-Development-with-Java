// ===========================================================================
// Naziv: Server
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Sadrzi main() metodu koja se prva poziva i ona predstavlja server
// ===========================================================================
package e11988.server;

import e11988.biblioteka.Biblioteka;
import java.net.*;


public class Server {

    public static void main(String[] args) {

        Biblioteka.getInstance().loadFromFile();

        try {
            ServerSocket ss = new ServerSocket(Podesavanja.getTCP_PORT());
            System.out.println("Server running...");
            Saver saver = new Saver(Podesavanja.getSAVE_TIME());
            while(true) {
                Socket sock = ss.accept();
                ServerThread st = new ServerThread(sock);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
