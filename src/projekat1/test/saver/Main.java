
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main{

    public static void main(String[] args) {
        Saver s1 = new Saver();
        s1.name = "s1";
        s1.time = 1500;
        s1.start();

        try {
            System.in.read();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}