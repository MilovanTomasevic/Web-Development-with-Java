package beans;

public class Address {

  public Address() {
    street = "";
    number = -1;
  }

  public void setStreet(String x) {
    street = x;
  }
  public void setNumber(int x) {
    number = x;
  }
  public String getStreet() {
    return street;
  }
  public int getNumber() {
    return number;
  }

  public String toString() {
    return "[" + street + " " + number + "]";
  }

  private String street;
  private int number;
}
