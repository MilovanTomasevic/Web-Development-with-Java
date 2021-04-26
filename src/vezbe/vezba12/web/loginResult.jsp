<%-- 
    File  : loginResult
    Autor : Milovan Tomašević, e11988
    Datum : 27.05.2009.
    Opis  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="webshop.User" scope="session"/>
<jsp:setProperty name="user" property="username" param="username"/>
<jsp:setProperty name="user" property="password" param="password"/>
<%! webshop.Users users;%>
<% ServletContext ctx = getServletContext();%>
<% users = new webshop.Users(ctx.getRealPath(""));%>
<% ctx.setAttribute("users", users);%>
<% boolean provera = false;
        for (webshop.User u : users.values()) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                provera = true;
                break;
            }
        }%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Shop</title>
    </head>
    <body>
        <h3>Web Shop</h3>

        <% if (provera) {
            response.sendRedirect("WebShop.jsp");
        %>
        <% } else {%>
        Niste se uspešno prijavili!
        <% }%>
        <p>
        [ <a href="index.jsp">Login</a> ]

    </body>
</html>
