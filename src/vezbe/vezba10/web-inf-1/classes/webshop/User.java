package webshop;

public class User {

	public User() {
        this.username = "";
        this.password = "";
        this.ulogovan = false;
	}

	public User(String username, String password, boolean ulogovan) {
		this.username = username;
		this.password = password;
		this.ulogovan = ulogovan;
        this.shoppingCart = new ShoppingCart();
	}


	// Get metode

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public boolean getUlogovan() { return ulogovan; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }


	// Set metode

	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setUlogovan(boolean ulogovan) { this.ulogovan = ulogovan; }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart; }
    
    
    public boolean isUlogovan() {
        return ulogovan;
    }
    
    public boolean login() {
        if(ulogovan == false) {
            ulogovan = true;
            return true;
        }else
            return false;
    }

    public void logoff() {
        ulogovan = false;
    }

	private String username;
	private String password;
	private boolean ulogovan;
    private ShoppingCart shoppingCart;
    
}