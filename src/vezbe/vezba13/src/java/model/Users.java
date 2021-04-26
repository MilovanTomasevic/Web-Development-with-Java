package model;

import java.io.*;
import java.util.*;

public class Users {

    public Users() {
        this.users = null;
    }

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

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
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
                if (line.equals("") || line.indexOf('#') == 0) {
                    continue;
                }
                st = new StringTokenizer(line, ";");
                while (st.hasMoreTokens()) {
                    username = st.nextToken().trim();
                    password = st.nextToken().trim();
                }
                users.put(username, new User(username, password));
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

    public void addUser(String path, User newUser) {
        PrintWriter pout = null;
        try {
            pout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
                    path + "/users.txt", true)));
            pout.println(newUser.getUsername() + ";" + newUser.getPassword());
            pout.close();
            users.put(newUser.getUsername(), new User(newUser.getUsername(),
                    newUser.getPassword()));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            pout.close();
        }
    }
    private HashMap<String, User> users = new HashMap<String, User>();
}