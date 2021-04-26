<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<%! ShoppingCart sc = null; %>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<HTML>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>Dobrodosli ... </TITLE>
</HEAD>
<BODY>
<%
	user = (User)session.getAttribute("user");
  String logoff = request.getParameter("logoff");
  if ((logoff != null) && logoff.equals("true")) {
    session.invalidate();
	user.logoff();	
	System.out.println("ODLOGOVAO ME JE LOGIN.JSP");
  }
	
	
	System.out.println("\nLOGIN.jsp " + user.getUsername() + "   " + user.isLoggedIn());
	
  if (!user.isLoggedIn()) { 
  System.out.println("\nLOGINUSER>>>>>" + user.getUsername()); 
  System.out.println("login.jsp Nije prijavljen..."); %>
  <p>Unesite podatke za prijavljivanje na sistem ...</p>
  <form action="results.jsp" method="post">
  <table cellspacing=0 cellpadding=3 border=0>
    <tr>
      <td align=right>Username:</td>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td align=right>Password:</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td align=right>&nbsp;</td>
      <td><input type="submit" value=" Pošalji "></td>
    </tr>
  </table>
  </form>
  
  <p>Ako zelite da postanete novi korisnik WebShop-a kliknite na sledeci link <a href="new.html"> prijava </a></p>
<% } else { 
	System.out.println("Prijavljen je... JEEEE"); %>
	Već ste se prijavili! <br>
  [<a href="login.jsp?logoff=true">Odjavi se</a>]
<% } %>
</body>
</html>
