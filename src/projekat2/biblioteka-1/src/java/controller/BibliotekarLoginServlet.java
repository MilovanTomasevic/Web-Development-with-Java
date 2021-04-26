/***********************************************************************
* Servlet: BibliotekarLoginServlet
* Autor:   Milovan Tomašević, e11988
* Datum:   27.06.2009.
* Opis:    Logovanje bibliotekara na sistem
 ***********************************************************************/

package controller;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class BibliotekarLoginServlet extends HttpServlet {
   
    /** 
     * Prijavljivanje i odjavljivanje bibliotekara.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String hostname = Defs.HOSTNAME;
        InetAddress addr = InetAddress.getByName(hostname);
        Socket sock = new Socket(addr, Defs.TCP_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                sock.getInputStream(),"UTF-8"));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(sock.getOutputStream(),"UTF-8")), true);

        String uname = request.getParameter("username");
        String passwd = request.getParameter("password");
        String logoff = request.getParameter("logoff");

        Biblioteka biblioteka = (Biblioteka) session.getAttribute("biblioteka");
        Bibliotekar bibliotekar = (Bibliotekar) session.getAttribute("bibliotekar");
        if(biblioteka == null)
            biblioteka = new Biblioteka();
        else
            biblioteka.clearAll();

        if (bibliotekar != null) {
            if (logoff != null && logoff.equals("true")) {
                // ako je poslat parametar za logoff, odjavimo se
                bibliotekar.setUlogovan(false);
                Authorization.logutBibliotekar(in, out, sock);
                // i odemo na login stranicu
                RequestDispatcher disp = request.getRequestDispatcher(
                        "index.jsp");
                // redirektovacemo na login stranicu
                disp.forward(request, response);
                return;
            }

            if (uname != null && passwd != null &&
                    !uname.trim().equals("") && !passwd.trim().equals("")) {

                bibliotekar.setUsername(uname);
                bibliotekar.setPassword(passwd);

                if (Authorization.loginBibliotekar(in, out, bibliotekar)) {

                    bibliotekar.setUlogovan(true);

                    out.println("pregledAktivnihZaduzenja");

                    String prijem = "";
                    String zaduzenje[];
                    while (!(prijem = in.readLine()).equals(Defs.END)) {
                        zaduzenje = prijem.split("÷");
                        
                        biblioteka.addZaduzenja(new Zaduzenje(
                                Integer.parseInt(zaduzenje[0]), zaduzenje[1],
                                zaduzenje[2], zaduzenje[3], zaduzenje[4]));
                    }

                    Authorization.logutBibliotekar(in, out, sock);

                    RequestDispatcher disp = request.getRequestDispatcher(
                            "view/BibliotekarHome.jsp");
                    disp.forward(request, response);

                }else{
                    // ne valjaju podaci
                    RequestDispatcher disp = request.getRequestDispatcher(
                            "view/BibliotekarLoginResult.jsp");
                    disp.forward(request, response);
                }
            }else{
                // nije ukucao jmbg ili email
                RequestDispatcher disp = request.getRequestDispatcher(
                            "view/BibliotekarLoginResult.jsp");
                    disp.forward(request, response);
            }
        }else {
            // user == null
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
            disp.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
