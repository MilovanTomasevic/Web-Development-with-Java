import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import webshop.*;

/**
 * Osnovni servlet koji lista raspolozive proizvode i omogucuje njihovo
 * dodavanje u korpu.
 */
public class WebShopServlet extends HttpServlet {
	/** Atribut products je staticki da bi se video iz klase ShoppingCartServlet. */
	Products products;
    Users users;

	@Override
	public void init(ServletConfig cfg) {
		try {
			super.init(cfg);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		ServletContext ctx = getServletContext();
		products = new Products(ctx.getRealPath(""));
		ctx.setAttribute("products", products);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		User user =  (User)session.getAttribute("user");
		if (user == null) {
		  // ako ne postoji, nastupa redirekcija
			response.sendRedirect("login.html");		
			return;
		}
		
		PrintWriter pout = response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");

		pout.println("<html>");
		pout.println("<head>");
		pout.println("<title>Web kupovina</title>");
		pout.println("<meta Cache-Control=\"no-cache\">");
		pout.println("</head>");
		pout.println("<body>");
		pout.println("<h1>Prijavljeni korisnik: "+user.getUsername()+"</h1>");
		pout.println("Raspolozivi proizvodi:");
		pout.println("<table border=\"1\"><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Cena</th><th>&nbsp;</th></tr>");
		for (Product p : products.values()) {
			pout.println("<tr>");
			pout.println("<form method=\"get\" action=\"ShoppingCartServlet\">");
			pout.println("<td>" + p.getName() + "</td>");
			pout.println("<td>" + p.getPrice() + "</td>");
			pout.println("<td>");
			pout.println("<input type=\"text\" size=\"3\" name=\"itemCount\">");
			pout.println("<input type=\"hidden\" name=\"itemId\" value=\""+ p.getId() + "\">");
			pout.println("<input type=\"submit\" value=\"Dodaj\">");
			pout.println("</form>");
			pout.println("</td>");
			pout.println("</tr>");
		}
		pout.println("</table>");

		pout.println("<p>");
		pout.println("<a href=\"ShoppingCartServlet\">Pregled sadrzaja korpe</a><br>");
		pout.println("<a href=\"LoginServlet\">Odjava</a>");
		pout.println("</p>");

		pout.println("</body>");
		pout.println("</html>");
	}
}