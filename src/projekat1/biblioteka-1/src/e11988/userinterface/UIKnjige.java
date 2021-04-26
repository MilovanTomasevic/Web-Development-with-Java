// ===========================================================================
// Naziv: UIKnjige
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Rukovanje interfejsom knjiga
// ===========================================================================
package e11988.userinterface;

import e11988.server.Podesavanja;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UIKnjige {

    public UIKnjige(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String izbor = "";
        try {
            do{
                Util.clrscr();
                System.out.println("Izaberite opciju:");
                System.out.println("1) Unos nove knjige");
                System.out.println("2) Prikaz knjige");
                System.out.println("3) Pregled svih knjiga");
                System.out.println("4) Pregled slobodnih knjiga");
                System.out.println("5) Nazad");
                System.out.print("Izbor: ");
                izbor = reader.readLine();
                if(izbor.equals("1")) unosKnjige(in, out);
                if(izbor.equals("2")) prikazKnjige(in, out);
                if(izbor.equals("3")) pregledKnjiga(in, out);
                if(izbor.equals("4")) pregledSlobodnihKnjiga(in, out);
            }while(!izbor.equals("5"));
        } catch (IOException ex) {
            Logger.getLogger(UIClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregledKnjiga(BufferedReader in, PrintWriter out) {
        Util.clrscr();
        System.out.println("Pregled svih knjiga\n");
        try {
            out.println("pregledKnjiga");
            String lista = "";
            String knjiga = "";
            int i=1;

            while(!(knjiga = in.readLine()).equals(Podesavanja.END)) {
                lista += i++ +". "+ knjiga + "\n";
            }
            if(lista.equals("1. Nema knjiga.\n"))
                System.out.println("Nema knjiga.");
            else {
                System.out.println("   ISBN           Autor                         Naslov                                Slobodnih");
                System.out.println("================================================================================================");
                System.out.print(lista);
            }
            Util.zadrska();

        } catch (IOException ex) {
            Logger.getLogger(UIClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregledSlobodnihKnjiga(BufferedReader in, PrintWriter out) {
        Util.clrscr();
        System.out.println("Pregled slobodnih knjiga\n");
        try {
            out.println("pregledSlobodnihKnjiga");
            String lista = "";
            String knjiga = "";
            int i=1;

            while(!(knjiga = in.readLine()).equals(Podesavanja.END)) {
                lista += i++ +". "+ knjiga + "\n";
            }
            if(lista.equals("1. Nema knjiga.\n"))
                System.out.println("Nema knjiga.");
            else{
                System.out.println("   ISBN           Autor                         Naslov                                Slobodnih");
                System.out.println("================================================================================================");
                System.out.print(lista);
            }
            Util.zadrska();

        } catch (IOException ex) {
            Logger.getLogger(UIClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prikazKnjige(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Util.clrscr();
        System.out.println("Prikaz knjige\n");
        try{
            String isbn = "";
            do{
                System.out.print("Unesi ISBN knjige: ");
                isbn = reader.readLine();
            }while(isbn.trim().equals(""));
            out.println("prikazKnjige÷"+isbn);
            String knjiga = "";
            String podatak = "";
            while(!(podatak = in.readLine()).equals(Podesavanja.END)) {
                knjiga += podatak + "\n";
            }
            System.out.println(knjiga);
            Util.zadrska();

        }catch(Exception ex) {

        }
    }

    private void unosKnjige(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Util.clrscr();
        System.out.println("Unos knjige\n");
        try{
            String naziv = "", autor = "", isbn = "", brPrimeraka = "";
            do{
                System.out.print("Naziv knjige:    ");
                naziv = reader.readLine();
            }while(naziv.trim().equals(""));
            do{
                System.out.print("Autor:           ");
                autor = reader.readLine();
            }while(autor.trim().equals(""));
            do{
                System.out.print("ISBN:            ");
                isbn = reader.readLine();
            }while(isbn.trim().equals(""));
            do{
                System.out.print("Broj primeraka:  ");
                brPrimeraka = reader.readLine();
            }while(brPrimeraka.trim().equals(""));
            out.println("unosKnjige÷"+naziv+"÷"+autor+"÷"+isbn+"÷"+brPrimeraka);
            System.out.println("\n"+in.readLine());
            Util.zadrska();
        }catch(Exception ex) {

        }
    }

}
