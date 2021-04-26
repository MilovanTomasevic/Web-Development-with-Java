<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>kupovina proizvoda</title>
</head>
<body>

<% user = (User)session.getAttribute("user"); 
System.out.println("\nProveravamo korisnika u SHOPING-u: " + user.getUsername());%>

<% if(user.login()) { %>
	<p align="center">Narudzbina je prihvacena, molimo sacekajte par sekundi , ako se nista ne desi kliknite na link ispod</p>
	<p align="center"><a href="login.jsp?logoff=true">LOGOVANJE</a></p>
<% } %>

<% BufferedWriter pisac = new BufferedWriter(new FileWriter("C:\\apache-tomcat-6.0.18\\webapps\\ftnkurs\\Narudzbina" + user.getUsername() + ".txt",true)); 
	String temp = "";
	for(ShoppingCartItem i : user.getKorpa().getItems()){
		temp += i.getProduct().getName() + " ,komada: " + i.getCount() + "\n";
	}
	pisac.write(temp);
	pisac.close();
%>

	<script type="text/javascript">
		setTimeout('Redirect()',4500);
		function Redirect(){location.href = "login.jsp?logoff=true"}
	<!--</script>
</body>
</html>