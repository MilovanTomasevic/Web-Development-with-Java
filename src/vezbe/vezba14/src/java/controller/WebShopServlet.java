// ============================================================================
// Klasa: WebShopServlet
// Autor: Milovan Tomašević, e11988
// Datum: 03.06.2009.
// Opis:  Dodaje proizvod u korpu ukoliko je dobijen parametar itemId
// ============================================================================
package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import model.*;

public class WebShopServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        
        if (request.getParameter("itemId") != null) {
            try {
                Products products = (Products) getServletContext().getAttribute("products");
                user.getShoppingCart().addItem(
                        products.getProduct(request.getParameter("itemId")),
                        Integer.parseInt(request.getParameter("itemCount")));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        RequestDispatcher disp = request.getRequestDispatcher(
                "view/shoppingCart.jsp");
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
