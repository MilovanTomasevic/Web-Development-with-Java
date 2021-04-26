/******************************************************************************
 * Klasa: Authorization
 * Autor: Milovan Tomašević, e11988
 * Datum: 26.06.2009.
 * Opis:  Klasa koja ostvaruje i zatvara komunikaciju sa serverom
 *****************************************************************************/
package controller;

import java.net.*;
import java.io.*;
import model.*;

public class Authorization {

    /**
     * Prijavljivanje člana biblioteke na web servis.
     * @param in za komunikaciju
     * @param out za komunikaciju
     * @param user clan biblioteke
     * @return true ako je clan uspesno ulogovan, false ako nije
     */
    public static boolean loginUser(BufferedReader in,
            PrintWriter out, User user) {
        try {
            String odgovor = "";
            out.println("loginuser÷" + user.getEmail() + "÷" + user.getJmbg());
            odgovor = in.readLine();
            if (odgovor.equals("neuspesno")) {
                return false;
            }

            if (user.getUlogovan() == false) {
                String str[] = odgovor.split("÷");
                user.setPrezime(str[1]);
                user.setIme(str[2]);
            }

            return true;
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    /**
     * Odjavljivanje člana sa sistema
     * @param in close
     * @param out close
     * @param sock close
     */
    public static void logoutUser(BufferedReader in, PrintWriter out,
            Socket sock) {
        out.println("exituser");
        try {
            in.close();
            out.close();
            sock.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 
     * @param in za komunikaciju
     * @param out za komunikaciju
     * @param b bibliotekar
     * @return true ako je ulogovan, false ako nije
     */
    public static boolean loginBibliotekar(BufferedReader in,
            PrintWriter out, Bibliotekar b) {
        try {
            String odgovor = "";
            out.println("loginbibliotekar÷" + b.getUsername() + "÷" +
                    b.getPassword());

            odgovor = in.readLine();
            if (odgovor.equals("neuspesno")) {
                return false;
            }

            return true;
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    /**
     * Odjavljivanje bibliotekara sa sistema
     * @param in close
     * @param out close
     * @param sock close
     */
    public static void logutBibliotekar(BufferedReader in, PrintWriter out,
            Socket sock) {
        out.println("exituser");
        try {
            in.close();
            out.close();
            sock.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
