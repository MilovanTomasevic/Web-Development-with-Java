// ===========================================================================
// Naziv: Zaduzenje
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Sadrzi podatke o jednom zaduzenju.
// ===========================================================================
package  e11988.biblioteka;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Zaduzenje implements Serializable {

	public Zaduzenje() {

	}

	public Zaduzenje(int id, GregorianCalendar datZaduzenja, GregorianCalendar datPovratka, Clan kojiClan, Knjiga kojaKnjiga) {
		this.id = id;
		this.datZaduzenja = datZaduzenja;
		this.datPovratka = datPovratka;
		this.kojiClan = kojiClan;
		this.kojaKnjiga = kojaKnjiga;
	}


	// Get metode

	public int getId() { return id; }
	public GregorianCalendar getDatZaduzenja() { return datZaduzenja; }
	public GregorianCalendar getDatPovratka() { return datPovratka; }
	public Clan getKojiClan() { return kojiClan; }
	public Knjiga getKojaKnjiga() { return kojaKnjiga; }


	// Set metode

	public void setId(int id) { this.id = id; }
	public void setDatZaduzenja(GregorianCalendar datZaduzenja) { this.datZaduzenja = datZaduzenja; }
	public void setDatPovratka(GregorianCalendar datPovratka) { this.datPovratka = datPovratka; }
	public void setKojiClan(Clan kojiClan) { this.kojiClan = kojiClan; }
	public void setKojaKnjiga(Knjiga kojaKnjiga) { this.kojaKnjiga = kojaKnjiga; }

    @Override
    public String toString() {
        String retVal = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy.");

        retVal = retVal
                .concat(Integer.toString(id)).concat("÷")
                .concat(kojiClan.getJmbg()).concat("÷")
                .concat(kojaKnjiga.getIsbn()).concat("÷")
                .concat(formatter.format(datZaduzenja.getTime())).concat("÷");

        if(datPovratka == null)
            retVal = retVal.concat("još nije vraćena");
        else
            retVal = retVal.concat(formatter.format(datPovratka.getTime()));

        return retVal;
    }

	private int id;
	private GregorianCalendar datZaduzenja;
	private GregorianCalendar datPovratka;
	private Clan kojiClan;
	private Knjiga kojaKnjiga;
}