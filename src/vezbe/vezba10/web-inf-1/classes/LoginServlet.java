import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import webshop.*;

public class LoginServlet extends HttpServlet {

	Users users;

	@Override
	public void init(ServletConfig cfg) {
		try {
			super.init(cfg);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		ServletContext ctx = getServletContext();
		users = new Users(ctx.getRealPath(""));
		ctx.setAttribute("users", users);
	}
	
	//dodati get metodu da redirektuje na index.html
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user != null) 
			session.invalidate();
		response.sendRedirect("index.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// pogledamo da li u tekucoj sesiji postoji objekat ShoppingCart
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		ServletContext ctx = getServletContext();
		users = new Users(ctx.getRealPath(""));
		ctx.setAttribute("users", users);
		
		if (user != null) {
			//response.sendRedirect("WebShopServlet");
			session.invalidate();
			session = request.getSession();
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean provera = false;
			
		for (User u : users.values()) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				provera = true;
                System.out.println("Ulogovan: "+u.getUsername());
				user = u;
                session.setAttribute("user", user);
				break;
			}
		}
		
		PrintWriter pout = response.getWriter();
		
		if (!provera) {
			response.sendRedirect("index.html");
			
			response.setContentType("text/html");
			pout.println("<html>");
			pout.println("<head>");
			pout.println("</head>");
			pout.println("<body>");
			pout.println("Ako vas brauzer ne prebaci automatski, kliknite na link:");
			pout.println("<a href=\"/ftnkurs/login.html\"> Prijava </a>");

			pout.println("</body>");
			pout.println("</html>");
			return;
		}
		
		
        response.sendRedirect("WebShopServlet");
		
		response.setContentType("text/html");
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("Ako vas brauzer ne prebaci automatski, kliknite na link:");
		pout.println("<a href=\"WebShopServlet\"> Web kupovina </a>");

		pout.println("</body>");
		pout.println("</html>");
	}
}