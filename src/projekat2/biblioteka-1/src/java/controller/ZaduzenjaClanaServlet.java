/******************************************************************************
 * Servlet: ZaduzenjaClanaServlet
 * Autor:   Milovan Tomašević, e11988
 * Datum:   29.06.2009.
 * Opis:    Prikaz zaduženja jednog člana
 *****************************************************************************/
package controller;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class ZaduzenjaClanaServlet extends HttpServlet {

    /** 
     * Prikaz zaduženja jednog člana
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Biblioteka biblioteka = (Biblioteka) session.getAttribute("biblioteka");
        Bibliotekar bibliotekar = (Bibliotekar) session.getAttribute("bibliotekar");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            user = new User();
        }

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

            System.out.println(request.getQueryString());
            String jmbg = request.getParameter("jmbg");
            out.println("prikazClana÷" + jmbg);
            String clan[] = in.readLine().split("÷");
            user.setJmbg(jmbg);
            user.setIme(clan[0]);
            user.setPrezime(clan[1]);
            user.setEmail(clan[2]);

            if (request.getParameter("filter") == null) {
                out.println("pregledZaduzenjaClana÷" + jmbg);
            } else if (request.getParameter("filter").equals("sva")) {
                out.println("pregledZaduzenjaClana÷" + jmbg);
            } else if (request.getParameter("filter").equals("svaAktivna")) {
                out.println("pregledAktivnihZaduzenjaClana÷" + jmbg);
            } else if (request.getParameter("filter").equals("svaAktivnaProbijena")) {
                out.println("pregledAktivnihProbijenihZaduzenjaClana÷" + jmbg);
            }

            String prijem = "";
            String zaduzenje[];
            while (!(prijem = in.readLine()).equals(Defs.END)) {
                zaduzenje = prijem.split("÷");

                biblioteka.addZaduzenja(new Zaduzenje(
                        Integer.parseInt(zaduzenje[0]), zaduzenje[1],
                        zaduzenje[2], zaduzenje[3], zaduzenje[4]));
            }

            Authorization.logoutUser(in, out, sock);

            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/ZaduzenjaClana.jsp");
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
