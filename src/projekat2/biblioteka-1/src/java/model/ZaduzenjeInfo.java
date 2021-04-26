/***********************************************************************
 * Module:  ZaduzenjeInfo.java
 * Author:  Tomas
 * Purpose: Defines the Class ZaduzenjeInfo
 ***********************************************************************/
package model;

public class ZaduzenjeInfo {

    public ZaduzenjeInfo() {
        // TODO: implement
    }

    public ZaduzenjeInfo(String jmbg, String ime, String prezime, String email, String isbn, String naslov, String autor, String datum, String result) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.isbn = isbn;
        this.naslov = naslov;
        this.autor = autor;
        this.datum = datum;
        this.result = result;
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

    public String getIsbn() {
        return isbn;
    }

    /** @param newIsbn */
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    public String getNaslov() {
        return naslov;
    }

    /** @param newNaslov */
    public void setNaslov(String newNaslov) {
        naslov = newNaslov;
    }

    public String getAutor() {
        return autor;
    }

    /** @param newAutor */
    public void setAutor(String newAutor) {
        autor = newAutor;
    }

    public String getDatum() {
        return datum;
    }

    /** @param newDatum */
    public void setDatum(String newDatum) {
        datum = newDatum;
    }

    public String getResult() {
        return result;
    }

    /** @param newResult */
    public void setResult(String newResult) {
        result = newResult;
    }
    private String jmbg;
    private String ime;
    private String prezime;
    private String email;
    private String isbn;
    private String naslov;
    private String autor;
    private String datum;
    private String result;
}