import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import webshop.*;

public class RegisterServlet extends HttpServlet {
	/** Atribut products je staticki da bi se video iz klase ShoppingCartServlet. */
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user != null) 
			session.invalidate();
		response.sendRedirect("register.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		// pogledamo da li u tekucoj sesiji postoji objekat ShoppingCart
		HttpSession session = request.getSession();
		users = (Users)getServletContext().getAttribute("users");
		session.invalidate();
		session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean provera = false;
		
		System.out.println("Username: "+username+"\nPassword: "+password);
		
		for (User u : users.values()) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				provera = true;
				System.out.println(username + " vec postoji!!!");
				break;
			}
		}
		
		if (provera) {
			response.sendRedirect("register.html");
			return;
		}
        
		User user = new User(username, password, true);
		PrintWriter out = new PrintWriter(
    	    new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath("")+"/users.txt",true)));
		out.println(username+";"+password);
		out.close();
		PrintWriter pout = response.getWriter();
		
		System.out.println("Pre redirekta na WebShop.");
		response.sendRedirect("WebShopServlet");
		System.out.println("Posle redirekta na WebShop.");
		session.setAttribute("user", user);
		
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