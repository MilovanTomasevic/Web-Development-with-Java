import java.io.*;
import java.util.*;

public class Imenik {

    private TreeMap<String, Osoba> osobe = new TreeMap<String, Osoba>();
    private Set entries = osobe.entrySet();
    private Iterator it;
    
    public static Imenik imenik;

    public Imenik() {
        osobe.clear();
    }
 
    public synchronized boolean dodaj(Osoba o) {
        if(osobe.containsKey(o.getJmbg()))
            return false;
        else{
            osobe.put(o.getJmbg(), o);
            return true;
        }
    }

    public void list() {
        it = entries.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            Osoba o = (Osoba) entry.getValue();
            System.out.println(o);
        }
    }

    public void nadjiPoImenu(String ime) {
        it = entries.iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            Osoba o = (Osoba) entry.getValue();
            if(o.getIme().equalsIgnoreCase(ime))
                System.out.println(o);
        }
    }

    public void saveToFile(String filename) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                        new FileOutputStream(filename)));
            oos.writeObject(osobe);
            oos.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try{
            File file = new File(filename);
            if(file.isFile() && file.exists()) {
                ObjectInputStream in = new ObjectInputStream(
                        new  BufferedInputStream(
                            new FileInputStream(file)));
                //osobe = (TreeMap<String, Osoba>) in.readObject();
                osobe.putAll((TreeMap<String, Osoba>)in.readObject());
                //UserServer.getInstance().setUsers((Vector) in.readObject());
                in.close();
            }
		}catch(Exception ex){
			ex.printStackTrace();
		}
    }


}