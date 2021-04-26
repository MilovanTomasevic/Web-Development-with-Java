/***********************************************************************
 * Module:  Clan.java
 * Author:  Tomas
 * Purpose: Defines the Class Clan
 ***********************************************************************/
package model;

public class Clan {

    public Clan() {
        jmbg = "";
        ime = "";
        prezime = "";
        email = "";
    }

    public Clan(String jmbg, String ime, String prezime, String email) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    /** @param newJmbg */
    public void setJmbg(String newJmbg) {
        jmbg = newJmbg;
    }

    public String getIme() {
        return ime;
    }

    /** @param newIme */
    public void setIme(String newIme) {
        ime = newIme;
    }

    public String getPrezime() {
        return prezime;
    }

    /** @param newPrezime */
    public void setPrezime(String newPrezime) {
        prezime = newPrezime;
    }

    public String getEmail() {
        return email;
    }

    /** @param newEmail */
    public void setEmail(String newEmail) {
        email = newEmail;
    }
    private String jmbg;
    private String ime;
    private String prezime;
    private String email;
}