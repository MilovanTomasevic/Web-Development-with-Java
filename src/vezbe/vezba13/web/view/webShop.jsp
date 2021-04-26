<%-- 
    File  : WebShop
    Autor : Milovan Tomašević, e11988
    Datum : 02.06.2009.
    Opis  : Prikaz mogućih proizvoda i mogućnost dodavanja proizvoda u korpu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>
<jsp:useBean id="products" class="model.Products" scope="application"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebShop</title>
    </head>
    <body>
        <h3>Korisnik: <%= user.getUsername()%></h3>
        <p>Raspoloživi proizvodi:</p>
        <table border="1">
            <tr bgcolor="lightgrey">
                <th>Naziv</th>
                <th>Cena</th>
                <th>&nbsp;</th>
            </tr>

            <% for (model.Product p : products.values()) {%>
            <tr>
                <form method="get" action="/vezba13/WebShopServlet">
                    <td> <%= p.getName()%> </td>
                    <td> <%= p.getPrice()%> </td>
                    <td>
                        <input type="text" size="3" name="itemCount">
                        <input type="hidden" name="itemId" value="<%= p.getId()%>">
                        <input type="submit" value="Dodaj">
                    </td>
                </form>
            </tr>
            <% }%>
            
        </table>
        <br>
        [ <a href="/vezba13/WebShopServlet">Pregled sadržaja korpe</a> ]
        <br>
        [ <a href="/vezba13/LoginServlet?logoff=true">Odjava</a> ]
    </body>
</html>
