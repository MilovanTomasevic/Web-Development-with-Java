/***********************************************************************
 * Module:  Bibliotekar.java
 * Author:  Tomas
 * Purpose: Defines the Class Bibliotekar
 ***********************************************************************/
package model;

public class Bibliotekar {

    public Bibliotekar() {
        username = "";
        password = "";
        ulogovan = false;
    }

    public String getUsername() {
        return username;
    }

    /** @param newUsername */
    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    /** @param newPassword */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public boolean getUlogovan() {
        return ulogovan;
    }

    /** @param newUlogovan */
    public void setUlogovan(boolean newUlogovan) {
        ulogovan = newUlogovan;
    }
    private String username;
    private String password;
    private boolean ulogovan;
}