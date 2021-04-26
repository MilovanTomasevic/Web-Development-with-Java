<%-- 
    File  : kupovinaResult
    Autor : Milovan Tomašević, e11988
    Datum : 29.05.2009.
    Opis  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="webshop.User" scope="session"/>
<%
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String brKartice = request.getParameter("brKartice");
        String datIsteka = request.getParameter("datIsteka");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kupovina - Web Shop</title>
    </head>
    <body>
        <h3>Kupovina proizvoda</h3>
        <% if (user.saveOrder(ime, prezime, brKartice, datIsteka, getServletContext().getRealPath(""))) {%>
        <p>Kupovina uspešna.</p>
        <p>Vaša narudžbina je sačuvana. Hvala na poverenju.</p>
        <% } else {%>
        <p>Kupovina neuspešna.</p>
        <p>Niste uredno popunili formu.</p>
        [ <a href="kupovina.jsp">Kupovina</a> ]
        <br>
        <% }%>
        [ <a href="WebShop.jsp">Web Shop</a> ]
    </body>
</html>
