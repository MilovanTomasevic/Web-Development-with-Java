package webshop;

/** Reprezentuje stavku u korpi. Stavku cine proizvod i kolicina. */
public class ShoppingCartItem {

  private Product product;

    ShoppingCartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
    
  public void setProduct(Product p) {
    product = p;
  }
  public Product getProduct() {
    return product;
  }

  private int count;
  public void setCount(int c) {
    count = c;
  }
  public int getCount() {
    return count;
  }

  public ShoppingCartItem() {
    this.product = null;
    this.count = 0;
  }
}