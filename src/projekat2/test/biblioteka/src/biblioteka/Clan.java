// ============================================================================
// Klasa: Clan
// Autor: Milovan Tomašević, e11988
// Datum: 
// Opis:  
// ============================================================================
package biblioteka;

import java.io.Serializable;

public class Clan implements Serializable{

    public Clan(int jmbg, String ime, String prezime) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getJmbg() {
        return jmbg;
    }

    public void setJmbg(int jmbg) {
        this.jmbg = jmbg;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return jmbg + " " + ime + " " + prezime;
    }
    protected int jmbg;
    protected String ime;
    protected String prezime;
}
