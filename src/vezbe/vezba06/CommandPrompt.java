// ======================================================
// Program: Command Prompt
// File:    CommandPrompt.java
// Autor:   Milovan Tomasevic, e11988
// Datum:   mart, 2009.
// Opis:    Program simulira Command Prompt
// ======================================================

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class CommandPrompt {

    public void cd(String s) {
        if(!s.equals("cd.."))
            try {
                s = (s.substring(s.indexOf(" "))).trim();
            }catch(Exception ex) {
                return;
            }
        else s = "..";
        
        File f = new File(path, s);
        if(f.isDirectory()) path = f;
        else System.out.println("The system cannot find the path specified.");
    }

    public void dir() {
        try{
            for(int i=0; i<path.list().length; i++)
                System.out.println(path.list()[i]);
        }catch(Exception ex) {
            File f = new File(path, "..");
            path = f;
            for(int i=0; i<path.list().length; i++)
                System.out.println(path.list()[i]);
        }
    }

    public void exit() {
        System.exit(0);
    }

    private File path = new File("/");

    public static void main(String args[]) {
        CommandPrompt cp = new CommandPrompt();
        while(true) {
            System.out.print(">> ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            try {
                s = in.readLine();
                if(s.equals("exit")) cp.exit();
                else if(s.equals("dir")) cp.dir();
                else if(s.startsWith("cd")) cp.cd(s);
                else System.out.println("Bad command or file name.");
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}