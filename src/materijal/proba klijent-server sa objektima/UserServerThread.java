import java.io.*;
import java.net.*;
import java.util.*;

public class UserServerThread extends Thread {

  public UserServerThread(Socket sock, Vector users) {
    this.sock = sock;
    this.users = users;
    try {
      // inicijalizuj ulazni stream
      in = new BufferedReader(
        new InputStreamReader(
          sock.getInputStream()));

      // inicijalizuj izlazni stream
      out = new PrintWriter(
        new BufferedWriter(
          new OutputStreamWriter(
            sock.getOutputStream())), true);
      // pokreni thread
      start();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void run() {
    String response = "";
    try {
	  
	  ObjectOutputStream out = new ObjectOutputStream(
          sock.getOutputStream());
	  
	  ObjectInputStream in = new ObjectInputStream(
			  sock.getInputStream());

      // procitaj odgovor
	  int n=(Integer)in.readObject();
	  String S=(String)in.readObject();
		  System.out.println(S);
	  for (int i=0; i<n; i++) {
		  Vozilo v;
		  v = (Vozilo)in.readObject();
		  System.out.println("\nVozilo br: "+ (i+1) +" sa id:" + v.id);
		  switch (v.getId()) {
			  case 0: System.out.println(" Obicno vozilo, " + (v.radi()?"RADI":"NE RADI") + ".");
				break;
			  case 1: Auto a = (Auto)v;
					System.out.println(" Auto, broj mesta: "  + a.getBrMesta() + ", " + (a.radi()?"RADI":"NE RADI") + ".");
				break;
			  case 2: Avion A = (Avion)v;
					System.out.println(" Avion, broj putnika: " + A.getBrPutnika() + ", " + (A.radi()?"RADI":"NE RADI") + ".");
				break;
			  case 3: Kamion k = (Kamion)v;
					System.out.println(" Kamion, nosivosti: " + k.getNosivost() + ", " + (k.radi()?"RADI":"NE RADI") + ".");
				break;
		  }
	  }

      // zatvori konekciju
      in.close();
      out.close();
      sock.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  private Socket sock;
  private Vector users;
  private BufferedReader in;
  private PrintWriter out;
}
