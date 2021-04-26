<%-- 
    File  : WebShop
    Autor : Milovan Tomašević, e11988
    Datum : 28.05.2009.
    Opis  : Lista proizvoda koji se kupuju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="webshop.User" scope="session"/>
<%! webshop.Products products;%>
<%
        ServletContext ctx = getServletContext();
        products = new webshop.Products(ctx.getRealPath(""));
        ctx.setAttribute("products", products);
        response.setHeader("Cache-Control", "no-cache");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Shop</title>
    </head>
    <body>
        <h3>Korisnik: <%= user.getUsername()%></h3>

        Raspoloživi proizvodi:

        <table border="1">
            <tr bgcolor="lightgrey">
                <th>Naziv</th>
                <th>Cena</th>
                <th>&nbsp;</th>
            </tr>

            <%
        for (webshop.Product p : products.values()) {
            %>
            <tr>
                <form method="get" action="shoppingCart.jsp">
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
        [ <a href="shoppingCart.jsp">Pregled sadržaja korpe</a> ]
        <br>
        [ <a href="index.jsp?logoff=true">Odjava</a> ]

    </body>
</html>
