// ========================================================================
// Klasa:   UserServer
// File:    UserServer.java
// Autor:   Milovan Tomasevic, e11988
// Datum:   april, 2009.
// Opis:    Globalni Server
// ========================================================================

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class UserServer {

    public static UserServer getInstance() {
        if(us == null)
            us = new UserServer();
        return us;
    }
    
    public Vector getUsers() {
        return users;
    }

    public void setUsers(Vector v) {
        this.users = v;
    }

    public Vector getClients() {
        return clients;
    }

    public void addClient(String newClient) {
        clients.addElement(newClient);
    }

    public boolean addUser(String newUser) {
        if(users.contains(newUser))
            return false;

        users.addElement(newUser);

        // save to file
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream("users.dat")));
            oos.writeObject(users);
            oos.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return true;
    }

    public boolean removeClient(String client) {
        return clients.remove(client);
    }

    protected Vector clients = new Vector();
    protected Vector users = new Vector();
    
    private static UserServer us = new UserServer();

    public static void main(String args[]) {
        try{
            File file = new File("users.dat");
            if(file.isFile() && file.exists()) {
                ObjectInputStream in=new ObjectInputStream(
                        new  BufferedInputStream(
                            new FileInputStream(file)));
                UserServer.getInstance().setUsers((Vector) in.readObject());
                in.close();
            }
		}catch(Exception ex){
			ex.printStackTrace();
		}

        try {
            ServerSocket ss = new ServerSocket(Defs.TCP_PORT);
            System.out.println("Server running...");
            while(true) {
                Socket sock = ss.accept();
                UserServerThread st = new UserServerThread(sock);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
