import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        if(!ime.trim().equals("")||!prezime.trim().equals(""))
            users.addElement(ime+" "+prezime);
        
        response.setContentType("text/html");
        PrintWriter pout = response.getWriter();
        pout.println("<html>");
        pout.println("<head>");
        pout.println("</head>");
        
        if(!users.isEmpty()) {
            pout.println("<body><h1>Prijavljeni korisnici</h1><ol>\n");
            for (int i = 0; i < users.size(); i++) {
              String user = users.elementAt(i);
              pout.println("<li>" + user + "</li>\n");
            }
            pout.println("</ol></body></html>\n");
        }else{
            pout.println("<body><p>Nema prijavljenih korisnika.</p></body>");
            pout.println("</html>\n");
        }
        
        pout.println("</body>");
        pout.println("</html>");
    }
    
    private Vector<String> users = new Vector<String>();

}