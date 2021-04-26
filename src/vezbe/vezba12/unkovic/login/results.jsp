<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<jsp:setProperty name="user" property="username" param="username"/>
<jsp:setProperty name="user" property="password" param="password"/>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Izaberite opciju</TITLE>
</HEAD>
<BODY>

<% User temp = new User(); temp = user; 
System.out.println("\nResult.jsp" + temp.getUsername() + "   " + user.isLoggedIn());  
System.out.println(user.getUsername());   
System.out.println("Sad proverava da li je prijavljen" ); 
session.setAttribute("user",temp);
if (user.login()) { 
	session.setAttribute("user",temp);
	System.out.println("\nResult.jsp " + temp.getUsername() + "   " + user.isLoggedIn()); %>
	Uspešno ste se prijavili:<br>
	Username: <b><jsp:getProperty name="user" property="username"/></b><br>
	Password: <b><%= user.getPassword()%></b>
<% } else { %>
  Niste se uspešno prijavili!
<% } %>
<p>
[ <a href="login.jsp">login.jsp</a> ]
[ <a href="webshop.jsp">webshop</a> ]

</body>
</html>
