// ========================================================================
// Klasa:   UserServerThread
// File:    UserServerThread.java
// Autor:   Milovan Tomasevic, e11988
// Datum:   april, 2009.
// Opis:    Jedan Client = 1 nit Servera; ovo je ta nit
// ========================================================================

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServerThread extends Thread {
    

    public UserServerThread(Socket sock) {
        this.sock = sock;
        try {
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(sock.getOutputStream())), true);
            start(); // pokreni thread
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String response = "";
        try {
            String request = in.readLine();
            response = login(request);
            out.println(response);

            while(true) {
                request = in.readLine();
                if(request.toLowerCase().startsWith("add")) response = add(request);
                else if(request.toLowerCase().trim().equalsIgnoreCase("list")) response = list();
                else if(request.toLowerCase().trim().equalsIgnoreCase("exit")) { response = exit(); break; }
                else response = "Command not recognized.\n" + Character.toString(Defs.END);
                out.println(response); // posalji odgovor
            }
            
            // zatvori konekciju
            out.println(response);
            Date todaysDate = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            System.out.println(formatter.format(todaysDate)+" "+username+" logged out.");
            in.close();
            out.close();
            sock.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public String add(String s) {
        String newUser = "";
        if(s.equals("add")) return "Missing username.\n" + Character.toString(Defs.END);
        newUser = (s.substring(s.indexOf(" "))).trim();

        if(newUser.equals("")) return "Missing username.\n" + Character.toString(Defs.END);

        if(UserServer.getInstance().addUser(newUser))
            return "User "+ newUser + " added.\n" + Character.toString(Defs.END);
        else
            return "User " + newUser + " already exists.\n" + Character.toString(Defs.END);
    }

    public String list() {
        String retVal = "";
        for(int i=0; i<UserServer.getInstance().getUsers().size(); i++) {
            String user = (String) UserServer.getInstance().getUsers().elementAt(i);
            retVal += user + "\n";
        }
        retVal += Character.toString(Defs.END);
        return retVal;
    }

    public String exit() {
        UserServer.getInstance().removeClient(this.username);
        return Character.toString(Defs.EXIT);
    }

    public String login(String request) {
        String newClient = request;
        UserServer.getInstance().addClient(newClient);
        this.username = newClient;

        Date todaysDate = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        System.out.println(formatter.format(todaysDate)+" "+newClient+" logged in.");

        return "Logged on.\n" + Character.toString(Defs.END);
    }

    private String username;
    private Socket sock;
    private BufferedReader in;
    private PrintWriter out;
}
