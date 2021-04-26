<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="beans.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dobrodošli ....</title>
</head>
<body>
		<% BufferedWriter pisac = new BufferedWriter(new FileWriter("C:\\apache-tomcat-6.0.18\\webapps\\ftnkurs\\spisakClanova.txt",true));
			String user = (String)request.getParameter("username");
			String pass = (String)request.getParameter("password");
			System.out.println(user + " i " + pass);
			User temp = new User();
			temp.setUsername(user);
			temp.setPassword(pass);
			System.out.println(temp.toString());
			pisac.write("\n" + temp.toString());
			pisac.close();
			if(temp.login()){
				System.out.println("SKONTAO GA JE");
				session.setAttribute("user",temp);
			}
		%>

	<p>Uspešno ste prijavljeni, molimo sacekajte trenutak ...</p>
	<script type="text/javascript">
		setTimeout('Redirect()',4500);
		function Redirect(){location.href = "results.jsp"}
	<!--</script>
</body>
</html>
