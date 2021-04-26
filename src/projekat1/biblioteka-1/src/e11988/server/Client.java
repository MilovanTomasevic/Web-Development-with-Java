// ===========================================================================
// Naziv: Client
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Sadrzi main() metodu koja predstavlja pocetak programa za klijenta
// ===========================================================================
package e11988.server;

import e11988.userinterface.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

    // ===================================================================
    // Naziv: showmeni()
    // Opis: Prikaz i glavnog menija i izbor
    // ===================================================================
    public static void showmeni(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

        // meni
        String izbor = "";
        do{
            Util.clrscr();
            System.out.println("Izaberi opciju:");
            System.out.println("1) Clanovi");
            System.out.println("2) Knjige");
            System.out.println("3) Zaduzenja");
            System.out.println("4) Izlaz");
            try {
                System.out.print("Izbor: ");
                izbor = reader.readLine();
                if(izbor.equals("1")) new UIClanovi(in, out);
                if(izbor.equals("2")) new UIKnjige(in, out);
                if(izbor.equals("3")) new UIZaduzenja(in, out);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(!izbor.equals("4"));
    }


    public static void main(String[] args) {
        String hostname = (args.length > 0) ? args[0] : "192.168.0.158";
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
            do{
                Util.clrscr();
                System.out.print("Username: ");
                String username = reader.readLine();
                System.out.print("Password: ");
                String password = reader.readLine();
                out.println("login÷" + username + "÷" + password);
                odgovor = in.readLine();
                if(odgovor.equals("neuspesno"))
                    System.out.println("Pogresna sifra. Za izlaz pritisnuti Ctrl+C");
            }while(odgovor.equals("neuspesno"));
            showmeni(in, out);

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
