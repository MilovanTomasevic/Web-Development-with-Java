/******************************************************************************
 * Servlet: ClanoviServlet
 * Autor:   Milovan Tomašević, e11988
 * Datum:   28.06.2009.
 * Opis:    Priprema spisak svih članova biblioteke
 *****************************************************************************/
package controller;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class ClanoviServlet extends HttpServlet {

    /** 
     * Priprema spisak svih članova biblioteke
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

        biblioteka.clearAll();

        String hostname = Defs.HOSTNAME;
        InetAddress addr = InetAddress.getByName(hostname);
        Socket sock = new Socket(addr, Defs.TCP_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                sock.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(sock.getOutputStream(), "UTF-8")), true);

        if (Authorization.loginBibliotekar(in, out, bibliotekar)) {

            out.println("pregledClanova");

            String prijem = "";
            String clan[];
            while (!(prijem = in.readLine()).equals(Defs.END)) {
                clan = prijem.split("÷");

                biblioteka.addClanovi(new Clan(clan[0], clan[1], clan[2], clan[3]));
            }

            Authorization.logutBibliotekar(in, out, sock);

            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/SpisakClanova.jsp");
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
