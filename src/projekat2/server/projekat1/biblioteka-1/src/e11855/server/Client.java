// ===========================================================================
// Naziv: Client
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Sadrzi main() metodu koja predstavlja pocetak programa za klijenta
// ===========================================================================
package e11988.server;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        String hostname = (args.length > 0) ? args[0] : "localhost";
        try {
            // odredi adresu racunara sa kojim se povezujemo
            InetAddress addr = InetAddress.getByName(hostname);

            // otvori socket prema drugom racunaru
            Socket sock = new Socket(addr, Podesavanja.getTCP_PORT());

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

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            String odgovor = "";
            do {
                System.out.print("Username: ");
                String username = reader.readLine();
                System.out.print("Password: ");
                String password = reader.readLine();
                out.println("login÷" + username + "÷" + password);
                odgovor = in.readLine();
                if (odgovor.equals("neuspesno")) {
                    System.out.println("Pogresna sifra. Za izlaz pritisnuti Ctrl+C");
                }
            } while (odgovor.equals("neuspesno"));

            // zatvori konekciju
            out.println("exit");
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
