import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread {

    public ServerThread(Socket sock, Vector users) {
        this.sock = sock;
        this.users = users;
        try {
            // inicijalizuj ulazni stream
            in = new BufferedReader(
            new InputStreamReader(
              sock.getInputStream()));

            // inicijalizuj izlazni stream
            out = new PrintWriter(
            new BufferedWriter(
              new OutputStreamWriter(
                sock.getOutputStream())), true);
            // pokreni thread
            start();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String response = "";
        try {
          // procitaj zahtev
          String request = in.readLine();

          // analiziraj zahtev: ako počinje sa GET, to je zahtev koga je
          // poslao web čitač. ako počinje nečim drugim, to je zahtev koga
          // je poslao konzolni klijent
          if (request.startsWith("GET / HTTP/1.1")) {
            newBrowserResponse();
          } else if(request.startsWith("GET /FormServlet?txtIme=&txtPrezime=&btnSubmit=Po%9Aalji")) {
              listUsers();
          }else {
              addUser(request);
          }

          // posalji odgovor
          out.println(response);

          // zatvori konekciju
          in.close();
          out.close();
          sock.close();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }

  /**
   * Slanje stranice registracija.html
   */
    private void newBrowserResponse() throws IOException {
        String resource = "registracija.html";
        OutputStream os = sock.getOutputStream();
        PrintStream ps = new PrintStream(os);
        // zamenimo web separator sistemskim separatorom
        resource = resource.replace('/', File.separatorChar);
        File file = new File(resource);

        if (!file.exists()) {
            // ako datoteka ne postoji, vratimo kod za gresku
            ps.print("HTTP/1.0 404 File not Found\r\n\r\n");
            ps.flush();
            System.out.println("Could not find resource: " + file);
            return;
        }

        // ispisemo zaglavlje HTTP odgovora
        ps.print("HTTP/1.0 200 OK\r\n\r\n");

        // a, zatim datoteku
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[8192];
        int len;

        while((len = fis.read(data)) != -1) {
            ps.write(data, 0, len);
        }

        ps.flush();
        fis.close();
    }

    private void addUser(String request) {
        // izdvajanje imena i prezimena
        request = request.substring(request.indexOf("?")+1);
        String[] podaci = request.split("&");
        String username = "";
        for(int i=0; i<podaci.length-1; i++) {
            String[] podatak = podaci[i].split("=");
            if(podatak.length > 1)
                username = username.concat(podatak[1].concat(" "));
        }
        username = username.trim();
        if(!username.equalsIgnoreCase(""))
            users.addElement(username);
        try{
            listUsers();
        }catch(Exception ex) {
            
        }
    }

    private void listUsers() throws IOException {
        OutputStream os = sock.getOutputStream();
        PrintStream ps = new PrintStream(os);
        String genHtml = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
        genHtml += "<html>\n    <head>";
        genHtml += "\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=Windows-1250\">";
        genHtml += "\n        <title>Prijavljeni korisnici</title>";
        genHtml += "\n    </head>";
        
        if(!users.isEmpty()) {
            genHtml += "<body><h1>Prijavljeni korisnici</h1><ol>\n";
            for (int i = 0; i < users.size(); i++) {
              String user = (String)users.elementAt(i);
              genHtml += "<li>" + user + "</li>\n";
            }
            genHtml += "</ol></body></html>\n";
        }else{
            genHtml += "<body><p>Nema prijavljenih korisnika.</p></body>";
            genHtml += "</html>\n";
        }

        ps.print(genHtml);

        ps.flush();
    }

    private Socket sock;
    private Vector users;
    private BufferedReader in;
    private PrintWriter out;
}
