package webshop;

import java.util.*;

/** Reperezentuje korpu za kupovinu. Sadrzi vektor stavki (uredjeni par (proizvod, kolicina)). */
public class ShoppingCart {
  ArrayList <ShoppingCartItem> items;

  public ShoppingCart() {
    items = new ArrayList <ShoppingCartItem>();
  }

  public void addItem(Product product, int count) {
    items.add(new ShoppingCartItem(product, count));
  }

  public ArrayList <ShoppingCartItem> getItems() {
    return items;
  }

  public void clear() {
      items.clear();
  }
}
