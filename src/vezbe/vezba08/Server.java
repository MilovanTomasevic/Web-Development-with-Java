import java.net.*;
import java.util.*;

public class Server {

  public static final int TCP_PORT = 80;

  public static void main(String[] args) {
    // vektor stringova u kome se cuvaju imena korisnika
    // inicijalno je prazan
    Vector users = new Vector();
    try {
      // slusaj zahteve na datom portu
      ServerSocket ss = new ServerSocket(TCP_PORT);

      System.out.println("Server running...");
      while (true) {
        Socket sock = ss.accept();
        ServerThread st = new ServerThread(sock, users);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
