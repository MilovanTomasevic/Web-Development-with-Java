// ============================================================================
// Klasa: KupovinaServlet
// Autor: Milovan Tomašević, e11988
// Datum: 
// Opis:
// ============================================================================


package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.User;

/**
 *
 * @author Tomas
 */
public class KupovinaServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String brKartice = request.getParameter("brKartice");
        String datIsteka = request.getParameter("datIsteka");

        User user = (User) request.getSession().getAttribute("user");
        user.saveOrder(ime, prezime, brKartice, datIsteka, getServletContext().getRealPath(""));

        RequestDispatcher disp = request.getRequestDispatcher(
                "view/kupovinaResult.jsp");
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
