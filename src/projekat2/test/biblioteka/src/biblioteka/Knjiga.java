// ============================================================================
// Klasa: Knjiga
// Autor: Milovan Tomašević, e11988
// Datum: 
// Opis:  
// ============================================================================
package biblioteka;

import java.io.Serializable;

public class Knjiga implements Serializable{

    public Knjiga(int id, String naziv, String autor) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return id + " " + naziv + ", " + autor;
    }
    protected int id;
    protected String naziv;
    protected String autor;
}
