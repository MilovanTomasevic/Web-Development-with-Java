<%-- 
    File  : kupovina
    Autor : Milovan Tomašević, e11988
    Datum : 28.05.2009.
    Opis  :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kupovina - Web Shop</title>
    </head>
    <body>
        <h3>Kupovina proizvoda</h3>
        <p>Popunite podatke i pritisnite dugme <b>Naruči</b>:</p>
        <br>
        <form name="frmBuy" action="kupovinaResult.jsp">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Ime:</td>
                        <td><input type="text" name="ime" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prezime:</td>
                        <td><input type="text" name="prezime" value="" /></td>
                    </tr>
                    <tr>
                        <td>Broj kreditne kartice:</td>
                        <td><input type="text" name="brKartice" value="" /></td>
                    </tr>
                    <tr>
                        <td>Datum isteka kartice:</td>
                        <td><input type="text" name="datIsteka" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Naruči" name="btnOrder" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        [ <a href="WebShop.jsp">Povratak</a> ]
    </body>
</html>
