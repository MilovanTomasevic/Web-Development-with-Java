// ===========================================================================
// Naziv: Saver
// Autor: Milovan Tomasevic, e11988
// Datum: april, 2009.
// Opis:  Nit koja se pali svakih n msec i cuva sve podatke
// ===========================================================================
package e11988.server;

import e11988.biblioteka.Biblioteka;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Saver extends Thread{

    public Saver(int time) {
        this.time = time;
        start();
    }

    void setTime(int time) { this.time = time; }
    int getTime() { return this.time; }

    private int time;

    @Override
    public void run() {
        try {
            while(true) {
                sleep(time);
                Biblioteka.getInstance().saveToFile();
                Date todaysDate = new java.util.Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                System.out.println(formatter.format(todaysDate)+" Podaci sacuvani.");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
