package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class User {

    public User() {
        this.username = "";
        this.password = "";
        this.ulogovan = false;
        this.shoppingCart = new ShoppingCart();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.shoppingCart = null;
        this.ulogovan = false;
        this.kupovinaUspesna = false;
    }

    // Get metode
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }


    // Set metode
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean isKupovinaUspesna() {
        return kupovinaUspesna;
    }

    public void setKupovinaUspesna(boolean kupovinaUspesna) {
        this.kupovinaUspesna = kupovinaUspesna;
    }

    public boolean login() {
        if (ulogovan == false) {
            ulogovan = true;
            return true;
        } else {
            return false;
        }
    }

    public void logoff() {
        username = "";
        password = "";
        ulogovan = false;
        shoppingCart.clear();
    }

    public boolean saveOrder(String ime, String prezime, String brKartice,
            String datIsteka, String path) throws FileNotFoundException {

        if (ime.trim().equals("") || prezime.equals("") ||
                brKartice.equals("") || datIsteka.equals("")) {
            this.kupovinaUspesna = false;
            return false;
        }

        // save order to file
        PrintWriter pout = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(
                path + "/orders.txt", true)));
        pout.println("Username: " + this.username);
        pout.println("Ime i prezime: " + ime + " " + prezime);
        pout.println("Broj kreditne kartice: " + brKartice);
        pout.println("Datum isteka kartice: " + datIsteka);
        pout.println("Naruceni proizvodi:");
        for (ShoppingCartItem i : shoppingCart.getItems()) {
            pout.println(i.getProduct().getId() + ". " +
                    i.getProduct().getName() + ", Komada: " + i.getCount());
        }
        pout.println("======================================================================");
        pout.close();

        this.kupovinaUspesna = true;
        this.shoppingCart.clear();
        return true;
    }
    private String username;
    private String password;
    private boolean ulogovan;
    private ShoppingCart shoppingCart;
    private boolean kupovinaUspesna;
}