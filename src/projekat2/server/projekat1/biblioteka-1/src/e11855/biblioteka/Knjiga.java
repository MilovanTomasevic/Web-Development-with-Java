// ===========================================================================
// Naziv: Knjiga
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Sadrzi podatke o knjizi
// ===========================================================================
package  e11988.biblioteka;

import java.io.Serializable;

public class Knjiga implements Serializable {

	public Knjiga() {

	}

	public Knjiga(String isbn, String naslov, String autor, int brSlobodnih) {
		this.isbn = isbn;
		this.naslov = naslov;
		this.autor = autor;
		this.brSlobodnih = brSlobodnih;
	}


	// Get metode

	public String getIsbn() { return isbn; }
	public String getNaslov() { return naslov; }
	public String getAutor() { return autor; }
	public int getBrSlobodnih() { return brSlobodnih; }


	// Set metode

	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setNaslov(String naslov) { this.naslov = naslov; }
	public void setAutor(String autor) { this.autor = autor; }
	public void setBrSlobodnih(int brSlobodnih) { this.brSlobodnih = brSlobodnih; }

    @Override
    public String toString() {
        String retVal = "";

        retVal = retVal
                .concat(isbn).concat("÷")
                .concat(naslov).concat("÷")
                .concat(autor).concat("÷")
                .concat(Integer.toString(brSlobodnih));

        return retVal;
    }

    private String isbn;
	private String naslov;
	private String autor;
	private int brSlobodnih;

}