// ===========================================================================
// Naziv: Bibliotekar
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Opisuje bibliotekara kao usera
// ===========================================================================
package e11988.biblioteka;

public class Bibliotekar {

	public Bibliotekar() {

	}

	public Bibliotekar(String username, String password, boolean ulogovan) {
		this.username = username;
		this.password = password;
		this.ulogovan = ulogovan;
	}


	// Get metode

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public boolean getUlogovan() { return ulogovan; }


	// Set metode

	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setUlogovan(boolean ulogovan) { this.ulogovan = ulogovan; }

    public String toString() {
        return username + ":" + password;
    }

	private String username;
	private String password;
	private boolean ulogovan;

}