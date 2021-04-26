
import java.io.*;

class RadSaKnjigama {

    public RadSaKnjigama() {

    }

    RadSaKnjigama(PrintWriter out) {
        System.out.println("pokrenuto");
        this.out = out;
        //meni();
    }

    public void meni() {
        System.out.println("Rad sa knjigama ");
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String s = null;
        try {
            s = br.readLine();
            out.println(s); // salji komandu serveru
        }catch(Exception ex){

        }
    }

    private PrintWriter out;
}

