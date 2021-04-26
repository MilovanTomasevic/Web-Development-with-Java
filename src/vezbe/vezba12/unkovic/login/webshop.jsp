<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<%! Products products = new Products("C:\\apache-tomcat-6.0.18\\webapps\\ftnkurs"); %>
<% session.setAttribute("products",products); %>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Dobrodosli u WebShop</TITLE>
</HEAD>
<body>
<% user = (User)session.getAttribute("user"); 
System.out.println("\nProveravamo korisnika u webshopu: " + user.getUsername());%>

<% if(user.login()) { %>
<% ShoppingCart sc = user.getKorpa(); %>
<p> Dobrodosli: <%= user.getUsername() %> </p>
	<p>Raspolozivi proizvodi:</p>
		<table border="1"><tr bgcolor="lightgrey"><th>Naziv</th><th>Cena</th><th>&nbsp;</th></tr>
			<% for (Product p : products.values()) { 
				System.out.println(p.getName() + " ID: " + p.getId()); 
			%>
			
			<% HashMap<String, Product> q = products.getProducts(); 
				System.out.println(q.size());
			%>
				<tr>
					<form method="get" action="shoppingcart.jsp">
					<td> <%= p.getName() %> </td>
					<td> <%= p.getPrice() %> </td>
					<td>
						<input type="text" size="3" name="itemCount">
						<% String val = p.getId(); %>
						<input type="hidden" name="itemId" value=<%= p.getId()%>>
						<% System.out.println("ID PROIZVODA JE: " + val); %>
						<input type="submit" value="Dodaj">
					</form>
					</td>
				</tr>
			<%	} session.setAttribute("products",products);%>
		</table>
	<p> <a href="shoppingcart.jsp">Pregledajte sadrzaj korpe </a> </p>
<% } else { response.sendRedirect("login.jsp"); } %>
<p><a href = "shop.jsp">Kupovina proizvoda ...</a></p>
<p><a href = "login.jsp?logoff=true">Odjavite se sa WebShop-a</a></p>

</body>
</html>
