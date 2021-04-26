<%-- 
    File  : loginResult
    Autor : Milovan Tomašević, e11988
    Datum : 02.06.2009.
    Opis  : Loguje korisnika ili ga obaveštava o grešci
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>

<% if (!user.isUlogovan()) {%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - WebShop</title>
    </head>
    <body>
        <h3>Login</h3>
        <p>Pogrešan username ili password. Pokušajte ponovo.</p>
        [ <a href="index.jsp">Login</a> ]
    </body>
</html>
<% } else {
            response.sendRedirect("view/webShop.jsp");
        }%>