/******************************************************************************
 * Servlet: NovoZaduzenjeServlet
 * Autor:   Milovan Tomašević, e11988
 * Datum:   29.06.2009.
 * Opis:    Kreiranje novog zaduzenja ako je knjiga slobodna
 *****************************************************************************/
package controller;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class NovoZaduzenjeServlet extends HttpServlet {

    /** 
     * Kreiranje novog zaduzenja ako je knjiga slobodna
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Biblioteka biblioteka = (Biblioteka) session.getAttribute("biblioteka");
        Bibliotekar bibliotekar = (Bibliotekar) session.getAttribute("bibliotekar");

        if (bibliotekar == null || bibliotekar.getUlogovan()  == false) {
            RequestDispatcher disp = request.getRequestDispatcher(
                    "index.jsp");
            disp.forward(request, response);
            return;
        }

        String hostname = Defs.HOSTNAME;
        InetAddress addr = InetAddress.getByName(hostname);
        Socket sock = new Socket(addr, Defs.TCP_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                sock.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(sock.getOutputStream(), "UTF-8")), true);

        if (Authorization.loginBibliotekar(in, out, bibliotekar)) {

            String jmbg = request.getParameter("jmbg");
            Zaduzenje zad = (Zaduzenje) session.getAttribute("zaduzenje");

            out.println("novoZaduzenje÷" + jmbg + "÷" + zad.getIsbn());
            String z[] = in.readLine().split("÷");

            ZaduzenjeInfo zi = new ZaduzenjeInfo(z[0], z[1], z[2], z[3],
                    z[4], z[5], z[6], z[7], z[8]);

            session.setAttribute("zaduzenjeInfo", zi);

            Authorization.logutBibliotekar(in, out, sock);

            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/ZaduzenjeResult.jsp");
            disp.forward(request, response);

        } else {
            // ne valjaju podaci
            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/BibliotekarLoginResult.jsp");
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
