<%-- 
    File  : shoppingCart
    Autor : Milovan Tomašević, e11988
    Datum : 03.06.2009.
    Opis  : Tabelarni prikaz sadržaja korpe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<jsp:useBean id="user" class="model.User" scope="session"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Korpa - WebShop</title>
    </head>
    <body>
        <h3>Proizvodi u korpi</h3>
        <p>Korisnik: <b> <%= user.getUsername()%></b></p>

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
        [ <a href="view/kupovina.jsp">Kupovina</a> ]
        <br>
        [ <a href="view/webShop.jsp">Povratak</a> ]
    </body>
</html>
