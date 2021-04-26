<%-- 
    File  : registracija
    Autor : Milovan Tomašević, e11988
    Datum : 02.06.2009.
    Opis  : Forma za registraciju
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija - WebShop</title>
    </head>
    <body>
        <h3>Registracija novog korisnika</h3>
        <p>Upišite vaše željeno korisničko ime (username) i šifru (password):</p>
        <form action="/vezba13/RegisterServlet" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type = "text" name = "username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr>
                <td> </td>
                <td><input type = "submit" name="btnSubmit" value="Prijavi se" /></td>
            </table>
        </form>
    </body>
</html>
