<%--
    File  : index
    Autor : Milovan Tomašević, e11988
    Datum : 27.05.2009.
    Opis  : Login stranica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>
<jsp:useBean id="users" class="model.Users" scope="application"/>
<jsp:useBean id="products" class="model.Products" scope="application"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Web Shop</title>
    </head>
    <body>
        <h3>Login</h3>
        <% if (!user.isUlogovan()) {%>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type = "text" name = "username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                <td> </td>
                <td><input type = "submit" name="btnSubmit" value=" Pošalji "></td>
            </table>
        </form>
        [ <a href="view/registracija.jsp">Registracija novog korisnika</a> ]
        <% } else {%>
        Već ste se prijavili! <br>
        [ <a href="LoginServlet?logoff=true">Odjavi se</a> ]
        <% }%>
    </body>
</html>
