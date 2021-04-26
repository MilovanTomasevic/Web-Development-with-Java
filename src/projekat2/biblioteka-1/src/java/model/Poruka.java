/***********************************************************************
 * Module:  Poruka.java
 * Author:  Tomas
 * Purpose: Defines the Class Poruka
 ***********************************************************************/
package model;

public class Poruka {

    public Poruka() {
        // TODO: implement
    }

    public Poruka(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    /** @param newSadrzaj */
    public void setSadrzaj(String newSadrzaj) {
        sadrzaj = newSadrzaj;
    }
    private String sadrzaj;
}