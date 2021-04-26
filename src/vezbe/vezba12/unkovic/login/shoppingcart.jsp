<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<% Products products = (Products)session.getAttribute("products"); %>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>Odabrani proizvodi za kupovinu ...</title>
</head>
<body>
	<% User temp = (User)session.getAttribute("user"); %>
	<% //System.out.println("\nNALAZIMO SE U SHOPPINGCART.JSP SA KORISNIKOM " + temp.getUsername());	%>
	
    <% ShoppingCart sc = temp.getKorpa();
	
    if (sc == null) {
      // ako ne postoji, kreiramo ga i dodelimo tekucoj sesiji. Na ovaj nacin, objekat klase ShoppingCart ce
      // pratiti sesiju.
      sc = new ShoppingCart();
	  temp.setKorpa(sc);
      session.setAttribute("user", temp);
    }
	%>
	
	<% if(request.getParameter("itemId") != null) {
      try {
		//System.out.println("NIJE PRAZNO, i ITEM_ID je: " + request.getParameter("itemId"));
        // probamo da ga dodamo
		//HashMap<String, Product> p = products.getProducts();
		//System.out.println("VELICINA PRODUCTS  >>>>" + p.size());
		//Product q = products.getProduct(request.getParameter("itemId"));
		//if(q == null)
		//	System.out.println("PRAZAAAAAAAAAAAAAAAAAAAANNNNNNNNNNNNNNNNNNNNNNNN");
			
        sc.addItem(products.getProduct(request.getParameter("itemId")),Integer.parseInt(request.getParameter("itemCount")));
		//System.out.println("VELICINA SC >>>>" + sc.getItems().size());
      } catch (Exception ex) {
        ex.printStackTrace();
		System.out.println("EXCEOTION");
      }
    }
	%>
    <p> Proizvodi u korpi: </p>
    <table>
		<tr bgcolor="lightgrey"><th>Naziv</th><th>Jedinicna cena</th><th>Komada</th><th>Ukupna cena</th></tr>
	<% double total = 0; %>
	<% //ArrayList<ShoppingCartItem> items = sc.getItems(); %>
	<% //System.out.println("MOJ ITEMS VELICINA: " + items.size()); %>
    <% for(ShoppingCartItem i : sc.getItems()){ %>
	<tr>
      <td> <%= i.getProduct().getName()%> </td>
      <td> <%= i.getProduct().getPrice()%> </td>
      <td> <%= i.getCount()%> </td>   
      <% double price = i.getProduct().getPrice() * i.getCount(); %>
      <td> <%= price %> </td>
    </tr>
      <% total += price; %>  
	<% } %>
    </table>

	<p>
    <p> Ukupno: <%= total %> dinara.</p>
    <p>
    <a href="webshop.jsp">Povratak</a>
</body>
</html>