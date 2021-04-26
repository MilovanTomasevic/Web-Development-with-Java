/***********************************************************************
 * Module:  Knjiga.java
 * Author:  Tomas
 * Purpose: Defines the Class Knjiga
 ***********************************************************************/
package model;

public class Knjiga {

    public Knjiga() {
        isbn = "";
        naslov = "";
        autor = "";
        brSlobodnih = -1;
    }

    public Knjiga(String isbn, String naslov, String autor, int brSlobodnih) {
        this.isbn = isbn;
        this.naslov = naslov;
        this.autor = autor;
        this.brSlobodnih = brSlobodnih;
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

    public int getBrSlobodnih() {
        return brSlobodnih;
    }

    /** @param newBrSlobodnih */
    public void setBrSlobodnih(int newBrSlobodnih) {
        brSlobodnih = newBrSlobodnih;
    }

    public String getIsbn() {
        return isbn;
    }

    /** @param newIsbn */
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }
    private String isbn;
    private String naslov;
    private String autor;
    private int brSlobodnih;
}