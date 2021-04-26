package model;

import java.util.*;

/** Reperezentuje korpu za kupovinu. Sadrzi vektor stavki (uredjeni par (proizvod, kolicina)). */
public class ShoppingCart {

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
    }

    public ArrayList<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ShoppingCartItem> items) {
        this.items = items;
    }

    public void addItem(Product product, int count) {
        items.add(new ShoppingCartItem(product, count));
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = 0;
        for (ShoppingCartItem i : items) {
            total += i.getSubtotal();
        }
        return total;
    }
    ArrayList<ShoppingCartItem> items;
}
