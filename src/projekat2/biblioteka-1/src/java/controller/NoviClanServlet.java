/******************************************************************************
 * Servlet: NoviClanServlet
 * Autor:   Milovan Tomašević, e11988
 * Datum:   29.06.2009.
 * Opis:    Delimična provera podataka i slanje podataka
 *****************************************************************************/
package controller;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Bibliotekar;
import model.Clan;
import model.Poruka;

public class NoviClanServlet extends HttpServlet {

    /** 
     * Delimična provera podataka i slanje podataka
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
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

        String jmbg = request.getParameter("jmbg");
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");

        if (jmbg.trim().equals("") || ime.trim().equals("") || prezime.trim().equals("") || email.trim().equals("")) {
            Poruka poruka = new Poruka("!unetapolja");
            session.setAttribute("poruka", poruka);
            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/NoviClanResult.jsp");
            disp.forward(request, response);
            return;
        }

        out.println("unosClana÷" + jmbg + "÷" + ime + "÷" + prezime + "÷" + email);
        Poruka poruka = new Poruka(in.readLine());
        Clan clan = new Clan(jmbg, ime, prezime, email);

        session.setAttribute("poruka", poruka);
        session.setAttribute("clan", clan);
        
        RequestDispatcher disp = request.getRequestDispatcher(
                "view/NoviClanResult.jsp");
        disp.forward(request, response);
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
