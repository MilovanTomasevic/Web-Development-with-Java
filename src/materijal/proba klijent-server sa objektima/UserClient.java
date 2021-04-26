import java.io.*;
import java.net.*;

public class UserClient {

  public static final int TCP_PORT = 80;

  public static void main(String[] args) {
	try {
      Socket sock = new Socket("127.0.0.1", TCP_PORT);

      // inicijalizuj ulazni stream
      /*BufferedReader in =
        new BufferedReader(
          new InputStreamReader(
            sock.getInputStream()));

      // inicijalizuj izlazni stream
      PrintWriter outW =
        new PrintWriter(
          new BufferedWriter(
            new OutputStreamWriter(
              sock.getOutputStream())), true);*/

      // posalji zahtev
		  
	  ObjectOutputStream out = new ObjectOutputStream(
          sock.getOutputStream());
	  
	  ObjectInputStream in = new ObjectInputStream(
			  sock.getInputStream());
	  
	  int i=12;
	  String S="Malka da ubacimo i tekst!\n";
	  
    out.writeObject(i);
	  out.writeObject(S);
	  
	  Vozilo v = new Vozilo();
	  Auto a = new Auto();
	  Avion A = new Avion();
	  Kamion k = new Kamion();
	  
      out.writeObject(v); //1
      out.writeObject(k); //2
	  a.upali();
      out.writeObject(a); //3
	  A.upali();
      out.writeObject(A); //4
      out.writeObject(v); //5
	  A = new Avion();
	  A.setBrPutnika(50);
      out.writeObject(A); //6
	  a = new Auto();
	  a.setBrMesta(5);
      out.writeObject(a); //7
      out.writeObject(k); //8
	  k = new Kamion();
	  k.setNosivost(45);
      out.writeObject(k); //9
	  k = new Kamion();
	  k.upali();
	  k.setNosivost(42);
      out.writeObject(a); //10
      out.writeObject(v); //11
      out.writeObject(k); //11
	  

      // procitaj odgovor
      String response;

      // zatvori konekciju
      in.close();
      out.close();
      sock.close();
    } catch (Exception e2) {
      e2.printStackTrace();
    }
  }

}
