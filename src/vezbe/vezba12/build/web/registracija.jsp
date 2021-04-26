<%-- 
    File  : registracija
    Autor : Milovan Tomašević, e11988
    Datum : 28.05.2009.
    Opis  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija - Web Shop</title>
    </head>
    <body>
        <h3>Registracija</h3>
        Upišite vaše željeno korisničko ime (username) i šifru (password):
        <br>
        <form action="registracijaResult.jsp" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type = "text" name = "username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type = "text" name = "password"></td>
                </tr>
                <tr>
                <td> </td>
                <td><input type = "submit" name="btnSubmit" value="Prijavi se"></td>
            </table>
        </form>
    </body>
</html>
