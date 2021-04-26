package e11988.userinterface;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static void clrscr() {
        for(int i=0; i<75; i++)
            System.out.println();
    }

    public static void zadrska() {
        System.out.print("\n\nPritisnite ENTER za nastavak...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
