// ============================================================================
// Klasa: Zaduzenje
// Autor: Milovan Tomašević, e11988
// Datum: 
// Opis:  
// ============================================================================
package biblioteka;

import java.io.Serializable;

public class Zaduzenje implements Serializable{

    public Zaduzenje(int id, Clan kojiClan, Knjiga kojaKnjiga) {
        this.id = id;
        this.kojiClan = kojiClan;
        this.kojaKnjiga = kojaKnjiga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Knjiga getKojaKnjiga() {
        return kojaKnjiga;
    }

    public void setKojaKnjiga(Knjiga kojaKnjiga) {
        this.kojaKnjiga = kojaKnjiga;
    }

    public Clan getKojiClan() {
        return kojiClan;
    }

    public void setKojiClan(Clan kojiClan) {
        this.kojiClan = kojiClan;
    }

    @Override
    public String toString() {
        return id + " " + kojiClan.getIme() + kojiClan.getPrezime() + " - " + kojaKnjiga.getNaziv();
    }
    protected int id;
    protected Clan kojiClan;
    protected Knjiga kojaKnjiga;
}
