/***********************************************************************
 * Module:  Zaduzenje.java
 * Author:  Tomas
 * Purpose: Defines the Class Zaduzenje
 ***********************************************************************/
package model;

public class Zaduzenje {

    public Zaduzenje() {
        // TODO: implement
    }

    public Zaduzenje(int id, String jmbg, String isbn, String datZaduzenja, String datVracanja) {
        this.id = id;
        this.jmbg = jmbg;
        this.isbn = isbn;
        this.datZaduzenja = datZaduzenja;
        this.datVracanja = datVracanja;
    }

    public int getId() {
        return id;
    }

    /** @param newId */
    public void setId(int newId) {
        id = newId;
    }

    public String getJmbg() {
        return jmbg;
    }

    /** @param newJmbg */
    public void setJmbg(String newJmbg) {
        jmbg = newJmbg;
    }

    public String getIsbn() {
        return isbn;
    }

    /** @param newIsbn */
    public void setIsbn(String newIsbn) {
        isbn = newIsbn;
    }

    public String getDatZaduzenja() {
        return datZaduzenja;
    }

    /** @param newDatZaduzenja */
    public void setDatZaduzenja(String newDatZaduzenja) {
        datZaduzenja = newDatZaduzenja;
    }

    public String getDatVracanja() {
        return datVracanja;
    }

    /** @param newDatVracanja */
    public void setDatVracanja(String newDatVracanja) {
        datVracanja = newDatVracanja;
    }
    private int id;
    private String jmbg;
    private String isbn;
    private String datZaduzenja;
    private String datVracanja;
}