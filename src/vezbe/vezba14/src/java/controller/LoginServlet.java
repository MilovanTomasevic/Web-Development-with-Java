// ============================================================================
// Klasa: LoginServlet
// Autor: Milovan Tomašević, e11988
// Datum: 01.06.09.
// Opis:  Servlet login/logout korisnika na sistem ili ne
// ============================================================================
package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import model.*;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uname = request.getParameter("username");
        String passwd = request.getParameter("password");
        String logoff = request.getParameter("logoff");

        Users users = (Users) getServletContext().getAttribute("users");
        Products products = (Products) getServletContext().
                getAttribute("products");

        // inicijalizacija usera
        if (users.getUsers() == null) {
            ServletContext ctx = getServletContext();
            users = new Users(ctx.getRealPath(""));
            getServletContext().setAttribute("users", users);
        }

        // inicijalizacija products
        if (products.getProducts() == null) {
            ServletContext ctx = getServletContext();
            products = new Products(ctx.getRealPath(""));
            getServletContext().setAttribute("products", products);
        }

        User user = (User) session.getAttribute("user");

        if (user != null) {
            if (logoff != null && logoff.equals("true")) {
                // ako je poslat parametar za logoff, odjavimo se
                user.logoff();
                // i odemo na login stranicu
                RequestDispatcher disp = request.getRequestDispatcher(
                        "index.jsp");
                // redirektovacemo na login stranicu
                disp.forward(request, response);
                return;
            }

            if (uname != null && passwd != null &&
                    !uname.trim().equals("") && !passwd.trim().equals("")) {
                for (User u : users.values()) {
                    if (u.getUsername().equals(uname) &&
                            u.getPassword().equals(passwd)) {
                        user.setUsername(uname);
                        user.setPassword(passwd);
                        user.login();
                        break;
                    }
                }
                // ne postoji uname ili passwd, pa idemo na login
                RequestDispatcher disp = request.getRequestDispatcher(
                        "view/loginResult.jsp");
                disp.forward(request, response);
            } else {
                // nema username ili password
                RequestDispatcher disp = request.getRequestDispatcher(
                        "view/loginResult.jsp");
                disp.forward(request, response);
            }
        } else {
            // ako user ne postoji, neko je pokusao direktno da gadja ovaj servlet
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
            // redirektovacemo na login stranicu
            disp.forward(request, response);
        }
    }

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
    }
}
