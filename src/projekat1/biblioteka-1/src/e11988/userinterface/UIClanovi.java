// ===========================================================================
// Naziv: UIClanovi
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Rukovanje interfejsom clanova
// ===========================================================================
package e11988.userinterface;

import e11988.server.Podesavanja;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UIClanovi {

    public UIClanovi(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String izbor = "";
        try {
            do{
                Util.clrscr();
                System.out.println("Izaberite opciju:");
                System.out.println("1) Unos novog clana");
                System.out.println("2) Prikaz clana");
                System.out.println("3) Pregled clanova");
                System.out.println("4) Nazad");
                System.out.print("Izbor: ");
                izbor = reader.readLine();
                if(izbor.equals("1")) unosClana(in, out);
                if(izbor.equals("2")) prikazClana(in, out);
                if(izbor.equals("3")) pregledClanova(in, out);
            }while(!izbor.equals("4"));
        } catch (IOException ex) {
            Logger.getLogger(UIClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pregledClanova(BufferedReader in, PrintWriter out) {
        Util.clrscr();
        System.out.println("Pregled clanova\n");
        try {
            out.println("pregledClanova");
            String lista = "";
            String clan = "";
            int i=1;

            while(!(clan = in.readLine()).equals(Podesavanja.END)) {
                lista += i++ +". "+ clan + "\n";
            }

            if(lista.equals("1. Nema clanova.\n"))
                System.out.println("Nema clanova.");
            else{
                System.out.println("   JMBG           Ime            Prezime        E-mail");
                System.out.println("===============================================================================");
                System.out.print(lista);
            }
            Util.zadrska();

        } catch (IOException ex) {
            Logger.getLogger(UIClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prikazClana(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Util.clrscr();
        System.out.println("Prikaz clanova\n");
        try{
            String jmbg = "";
            do{
                System.out.print("Unesi JMBG clana:");
                jmbg = reader.readLine();
            }while(jmbg.trim().equals(""));
            out.println("prikazClana÷"+jmbg);
            String clan = "";
            String podatak = "";
            while(!(podatak = in.readLine()).equals(Podesavanja.END)) {
                clan += podatak + "\n";
            }
            System.out.println(clan);
            Util.zadrska();

        }catch(Exception ex) {

        }
    }

    private void unosClana(BufferedReader in, PrintWriter out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Util.clrscr();
        System.out.println("Unos clana\n");
        try{
            String ime = "", prezime = "", jmbg = "", email = "";
            do{
                System.out.print("Ime:     ");
                ime = reader.readLine();
            }while(ime.trim().equals(""));
            do{
                System.out.print("Prezime: ");
                prezime = reader.readLine();
            }while(prezime.trim().equals(""));
            do{
                System.out.print("JMBG:    ");
                jmbg = reader.readLine();
            }while(jmbg.trim().equals(""));
            do{
                System.out.print("E-mail:  ");
                email = reader.readLine();
            }while(email.trim().equals(""));
            out.println("unosclana÷"+ime+"÷"+prezime+"÷"+jmbg+"÷"+email);
            System.out.println("\n"+in.readLine());
            Util.zadrska();
        }catch(Exception ex) {

        }
    }
}
