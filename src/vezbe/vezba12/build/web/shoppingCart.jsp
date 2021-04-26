<%-- 
    File  : shoppingCart
    Autor : Milovan Tomašević, e11988
    Datum : 28.05.2009.
    Opis  : Prikaz trenutno naručenih proizvoda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webshop.*" %>
<jsp:useBean id="user" class="webshop.User" scope="session"/>
<%
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
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Korpa - Web Shop</title>
    </head>
    <body>
        <h3>Proizvodi u korpi</h3>

        <table>
            <tr bgcolor="lightgrey">
                <th>Naziv</th>
                <th>Jedinicna cena</th>
                <th>Komada</th>
                <th>Ukupna cena</th>
            </tr>

            <%
        double total = 0;
        for (ShoppingCartItem i : user.getShoppingCart().getItems()) {
            double price = i.getProduct().getPrice() * i.getCount();
            %>
            <tr>
                <td> <%= i.getProduct().getName()%> </td>
                <td> <%= i.getProduct().getPrice()%> </td>
                <td> <%= i.getCount()%> </td>
                <td> <%= price%> </td>
            </tr>
            <% total += price;
        }%>
        </table>
        <br>
        Ukupno: <%= total%> dinara.
        <br><br>
        [ <a href="kupovina.jsp">Kupovina</a> ]
        <br>
        [ <a href="WebShop.jsp">Povratak</a> ]

    </body>
</html>
