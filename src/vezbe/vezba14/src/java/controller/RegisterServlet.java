// ============================================================================
// Klasa: RegisterServlet
// Autor: Milovan Tomašević, e11988
// Datum: 02.06.09.
// Opis:  Registruje i loguje korisnika na sistem osim ako username već postoji
// ============================================================================
package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import model.*;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String passwd = request.getParameter("password");

        User user = (User) request.getSession().getAttribute("user");
        Users users = (Users) getServletContext().getAttribute("users");
        Products products = (Products) getServletContext().
                getAttribute("products");

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

        if (uname == null || passwd == null ||
                uname.trim().equals("") || passwd.trim().equals("")) {
            RequestDispatcher disp = request.getRequestDispatcher(
                    "view/registracija.jsp");
            disp.forward(request, response);
            return;
        }

        for (User u : users.values()) {
            if (uname.equals(u.getUsername())) {
                RequestDispatcher disp = request.getRequestDispatcher(
                        "view/registerResult.jsp");
                disp.forward(request, response);
                return;
            }
        }


        user.setUsername(uname);
        user.setPassword(passwd);
        user.setUlogovan(true);

        // dodavanje novog korisnika u file i mapu
        users.addUser(getServletContext().getRealPath(""), user);

        RequestDispatcher disp = request.getRequestDispatcher(
                "view/registerResult.jsp");
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
