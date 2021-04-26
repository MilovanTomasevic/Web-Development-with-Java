package beans;

import java.io.*;
public class User{

  public User() {
	super();
    username = "";
    password = "";
    loggedIn = false;
	citaj = "";
	korpa = new ShoppingCart();
  }

  public ShoppingCart getKorpa(){
	return korpa;
  }
  
  public void setKorpa(ShoppingCart a){
	korpa = a;
  }
  
  public String getCitaj() {
	return citaj;
  }
    
  public void setUsername(String x) {
    username = x;
  }
  public void setPassword(String x) {
    password = x;
  }
  public String getUsername() {
    return username;
  }
  public String getPassword() {
    return password;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

	@Override
	public String toString(){
		return "Username: " + this.username + " Password:  " + this.password;
	}
  
  public boolean login() {
  String s = "";
  try{
		System.out.println("POCETAK CITAJ IZ DATOTEKE");
		FileReader fr = new FileReader("C:\\apache-tomcat-6.0.18\\webapps\\ftnkurs\\spisakClanova.txt");
		BufferedReader br = new BufferedReader(fr);
		LineNumberReader lr = new LineNumberReader(br);
		
		
		while ((s = lr.readLine()) != null){
			System.out.println(s);
			int a = s.indexOf("Username: ") + 10;
			int b = s.indexOf("Password: ") - 1;
			int c = s.indexOf("Password: ") + 11;
			int d = s.length();
			String tempUser = s.substring(a,b);
			String tempPass = s.substring(c,d);
			System.out.println("MOLIM TE CITAJ IZ DATOTEKE");	
			if(tempUser.equalsIgnoreCase(username) && tempPass.equalsIgnoreCase(password)){
				citaj = "OK";
				this.loggedIn = true;
				break;
			}else
				this.loggedIn = false;
		}
		lr.close();	
		br.close();
		fr.close();
	}catch(Exception ex){
		
	}
    return loggedIn;
  }

  public void logoff() {
    username = "";
    password = "";
    loggedIn = false;
  }
  	public static void main(String[] args) {
		User a = new User();
		a.setUsername("milan");
		a.setPassword("1");
		
		System.out.println(a.login());
		System.out.println(a.getCitaj());
	}
 
  private String username;
  private String password;
  private boolean loggedIn;
  private String citaj;
	private ShoppingCart korpa;	
}
