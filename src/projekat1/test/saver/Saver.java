
import java.util.logging.Level;
import java.util.logging.Logger;

public class Saver extends Thread {

    public String name;
    public int time;

    @Override
    public void run() {
        try {
            while(true) {
                sleep(time);
                System.out.println(name+": File saved.");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}