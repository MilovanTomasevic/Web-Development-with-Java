/***********************************************************************
 * Module:  User.java
 * Author:  Tomas
 * Purpose: Defines the Class User
 ***********************************************************************/
package model;

public class User {

    public User() {
        ime = "";
        prezime = "";
        jmbg = "";
        email = "";
        ulogovan = false;
    }

    public String getEmail() {
        return email;
    }

    /** @param newEmail */
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public String getJmbg() {
        return jmbg;
    }

    /** @param newJmbg */
    public void setJmbg(String newJmbg) {
        jmbg = newJmbg;
    }

    public boolean getUlogovan() {
        return ulogovan;
    }

    /** @param newUlogovan */
    public void setUlogovan(boolean newUlogovan) {
        ulogovan = newUlogovan;
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
    private String ime;
    private String prezime;
    private String email;
    private String jmbg;
    private boolean ulogovan;
}