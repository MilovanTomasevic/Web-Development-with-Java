package webshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Users {

    private HashMap<String, User> users = new HashMap<String, User>();
    
    public Users(String path) {
		BufferedReader in = null;
		try {
			File file = new File(path + "/users.txt");
			System.out.println(file.getCanonicalPath());
			in = new BufferedReader(new FileReader(file));
			readUsers(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * Cita usere iz datoteke i smesta ih u asocijativnu listu usera.
	 * Kljuc je username usera.
	 */
	private void readUsers(BufferedReader in) {
		String line, username = "", password = "";
		StringTokenizer st;
		try {
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					username = st.nextToken().trim();
					password = st.nextToken().trim();
				}
				users.put(username, new User(username, password, false));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    
    /** Vraca kolekciju usera. */
	public Collection<User> values() {
		return users.values();
	}

	/** Vraca usera na osnovu njegovog username-a. */
	public User getUser(String username) {
		return (User) users.get(username);
	}
}