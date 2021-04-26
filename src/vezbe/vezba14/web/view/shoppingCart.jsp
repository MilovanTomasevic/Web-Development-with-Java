<%-- 
    File  : shoppingCart
    Autor : Milovan Tomašević, e11988
    Datum : 03.06.2009.
    Opis  : Tabelarni prikaz sadržaja korpe
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <p>Korisnik: <b> ${user.username}</b></p>

        <table>
        <tr bgcolor="lightgrey">
            <th>Naziv</th>
            <th>Jedinicna cena</th>
            <th>Komada</th>
            <th>Ukupna cena</th>
        </tr>

        <c:forEach var="item" items="${user.shoppingCart.items}">
        <tr>
            <td> ${item.product.name} </td>
            <td> ${item.product.price} </td>
            <td> ${item.count} </td>
            <td> ${item.subtotal} </td>
        </tr>
        </c:forEach>
        </table>
        <br>
        Ukupno: ${user.shoppingCart.total} dinara.
        <br><br>
        [ <a href="view/kupovina.jsp">Kupovina</a> ]
        <br>
        [ <a href="view/webShop.jsp">Povratak</a> ]
    </body>
</html>
