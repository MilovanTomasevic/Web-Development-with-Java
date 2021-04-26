// ============================================================================
// Klasa: Biblioteka
// Autor: Milovan Tomašević, e11988
// Datum: 
// Opis:  
// ============================================================================
package biblioteka;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;

public class Biblioteka implements Serializable {

    public static Biblioteka getInstanca() {
        return biblioteka;
    }

    public void unesiZaduzenje(Zaduzenje z) {
        zaduzenja.put(z.getId(), z);
    }

    public void loadFromFile() {
        File filelib = new File("biblioteka.dat");

        try {
            if (filelib.isFile() && filelib.exists()) {
                ObjectInputStream in = new ObjectInputStream(
                        new BufferedInputStream(
                        new FileInputStream(filelib)));
                biblioteka = (Biblioteka) in.readObject();
                //clanovi.putAll((TreeMap<String, Clan>)in.readObject());
                in.close();
            }
        } catch (Exception e) {
        }

    }

    public void saveToFile() {
        File filelib = new File("biblioteka.dat");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                    new FileOutputStream(filelib)));
            oos.writeObject(biblioteka);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public TreeMap<Integer, Clan> clanovi = new TreeMap<Integer, Clan>();
    public TreeMap<Integer, Knjiga> knjige = new TreeMap<Integer, Knjiga>();
    public TreeMap<Integer, Zaduzenje> zaduzenja = new TreeMap<Integer, Zaduzenje>();
    private static Biblioteka biblioteka = new Biblioteka();
}
