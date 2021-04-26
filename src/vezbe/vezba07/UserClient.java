// ========================================================================
// Klasa:   UserClient
// File:    UserClient.java
// Autor:   Milovan Tomasevic, e11988
// Datum:   april, 2009.
// Opis:    Ovde je implementiran klijent u klijent-server aplikaciji
// ========================================================================

import java.io.*;
import java.net.*;


public class UserClient {

    public static void main(String args[]) {
        // direktorijum i adresa servera se zadaju iz komandne linije;
        // ako nisu definisani, ispisi poruku i prekini sa radom
        if (args.length == 0) {
          System.out.println("User Client v1.0");
          System.out.println("Usage: UserClient <username> [<hostname>]");
          System.out.println("Parameters:");
          System.out.println("  <username> Username to use for login");
          System.out.println("  <hostname> Server name; default is localhost\n\n");
          System.exit(0);
        }
        String username = args[0];
        String hostname = (args.length > 1) ? args[1] : "localhost";
        try {
            // odredi adresu racunara sa kojim se povezujemo
            InetAddress addr = InetAddress.getByName(hostname);

            // otvori socket prema drugom racunaru
            Socket sock = new Socket(addr, Defs.TCP_PORT);

            // inicijalizuj ulazni stream
            BufferedReader in =
            new BufferedReader(
                new InputStreamReader(
                    sock.getInputStream()));

            // inicijalizuj izlazni stream
            PrintWriter out =
            new PrintWriter(
                new BufferedWriter(
                    new OutputStreamWriter(
                        sock.getOutputStream())), true);

            // posalji zahtev
            System.out.println("Logging in...");
            out.println(username);
            String response;
            String list = "";
            while(!(response = in.readLine()).equals(
                    Character.toString(Defs.END)))
                        list += response + "\n";
            System.out.println(list);
            // konzola
            while(true) {
                System.out.print(">> ");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
                String s = null;
                try {
                    s = br.readLine();
                    out.println(s); // salji komandu serveru
                    
                    // procitaj odgovor
                    list = "";
                    
                    while(!(response = in.readLine()).equals(
                            Character.toString(Defs.END))) {
                        if(response.equals(Character.toString(Defs.EXIT)))break;
                        list += response + "\n";
                    }

                    if(response.equals(Character.toString(Defs.EXIT))) break;
                        
                    System.out.print(list);
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            // zatvori konekciju
            in.close();
            out.close();
            sock.close();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
