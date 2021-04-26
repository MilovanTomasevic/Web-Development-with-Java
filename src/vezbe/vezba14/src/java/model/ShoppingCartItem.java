package model;

/** Reprezentuje stavku u korpi. Stavku cine proizvod i kolicina. */
public class ShoppingCartItem {

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSubtotal(){
	return count*product.getPrice();
  }
    private Product product;
    private int count;
}