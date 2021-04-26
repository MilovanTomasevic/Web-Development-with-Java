<%-- 
    File  : registracijaResult
    Autor : Milovan Tomašević, e11988
    Datum : 28.05.2009.
    Opis  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*" %>

<jsp:useBean id="user" class="webshop.User" scope="session"/>
<jsp:setProperty name="user" property="username" param="username"/>
<jsp:setProperty name="user" property="password" param="password"/>
<%! webshop.Users users;%>
<% ServletContext ctx = getServletContext();%>
<% users = new webshop.Users(ctx.getRealPath(""));%>
<% ctx.setAttribute("users", users);%>
<%
        boolean uspesnaReg = true;
        if (user.getUsername().trim().equals("") || user.getUsername().trim().equals("")) {
            uspesnaReg = false;
        } else {
            for (webshop.User u : users.values()) {
                if (u.getUsername().equals(user.getUsername())) {
                    uspesnaReg = false;
                    break;
                }
            }
        }%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Shop</title>
    </head>
    <body>
        <h3>Web Shop</h3>
        <% if (uspesnaReg) {
            PrintWriter pout = new PrintWriter(
                    new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath("") + "/users.txt", true)));
            pout.println(user.getUsername() + ";" + user.getPassword());
            pout.close();
            response.sendRedirect("WebShop.jsp");
        } else {%>
        Korisničko ime već postoji.
        <br>
        [ <a href="index.jsp">Login</a> ]
        <br>
        [ <a href="registracija.jsp">Registracija</a> ]
        <% }%>
    </body>
</html>
