// ===========================================================================
// Naziv: Clan
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Podaci o clanu biblioteke (osobi)
// ===========================================================================
package  e11988.biblioteka;

import java.io.Serializable;

public class Clan implements Serializable{

	public Clan() {

	}

	public Clan(String jmbg, String ime, String prezime, String eMail) {
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
		this.eMail = eMail;
	}


	// Get metode

	public String getJmbg() { return jmbg; }
	public String getIme() { return ime; }
	public String getPrezime() { return prezime; }
	public String getEMail() { return eMail; }


	// Set metode

	public void setJmbg(String jmbg) { this.jmbg = jmbg; }
	public void setIme(String ime) { this.ime = ime; }
	public void setPrezime(String prezime) { this.prezime = prezime; }
	public void setEMail(String eMail) { this.eMail = eMail; }

    @Override
    public String toString() {
        String retVal = "";
        String wjmbg = this.jmbg; // w kao wide
        String wime = this.ime;
        String wprezime = this.prezime;

        for(int i=wjmbg.length(); i<15; i++)
            wjmbg = wjmbg.concat(" ");
        for(int i=wime.length(); i<15; i++)
            wime = wime.concat(" ");
        for(int i=wprezime.length(); i<15; i++)
            wprezime = wprezime.concat(" ");

        retVal = retVal.concat(wjmbg).concat(wime).concat(wprezime).concat(eMail);
        
        return retVal;
    }

	private String jmbg;
	private String ime;
	private String prezime;
	private String eMail;

}