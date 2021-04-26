import java.io.Serializable;
import java.util.*;

public class Osoba implements Serializable{
	private String jmbg;
	private String ime;
	private String prezime;

	public Osoba() {
		this.jmbg = "";
		this.ime = "";
		this.prezime = "";
	}

	public Osoba(String jmbg, String ime, String prezime)
	{
		this.jmbg = jmbg;
		this.ime = ime;
		this.prezime = prezime;
	}


	// Get metode

	public String getJmbg() { return jmbg; }
	public String getIme() { return ime; }
	public String getPrezime() { return prezime; }


	// Set metode

	public void setJmbg(String jmbg) { this.jmbg = jmbg; }
	public void setIme(String ime) { this.ime = ime; }
	public void setPrezime(String prezime) { this.prezime = prezime; }

    @Override
    public String toString() {
        return this.getJmbg()+" "+this.getIme()+" "+this.getPrezime();
    }
}