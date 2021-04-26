package model;

/** Reprezentuje jedan proizvod. Cuva se id, naziv i jedinicna cena. */
public class Product {

    public Product() {
        this.id = "";
        this.name = "";
        this.price = 0.0;
    }

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    private String id;
    private String name;
    private double price;
}