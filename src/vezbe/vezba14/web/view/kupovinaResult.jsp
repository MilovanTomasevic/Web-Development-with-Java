<%--
    File  : kupovinaResult
    Autor : Milovan Tomašević, e11988
    Datum : 29.05.2009.
    Opis  : Čuva sadržaj korpe u file ili javlja grešku ako nije uredna forma
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kupovina - Web Shop</title>
    </head>
    <body>
        <h3>Kupovina proizvoda</h3>
        <c:choose>
            <c:when test="${user.kupovinaUspesna == true}">
                <p>Kupovina uspešna.</p>
                <p>Vaša narudžbina je sačuvana. Hvala na poverenju.</p>
            </c:when>
            <c:otherwise>
                <p>Kupovina neuspešna.</p>
                <p>Niste uredno popunili formu.</p>
                [ <a href="view/kupovina.jsp">Kupovina</a> ]
                <br>
            </c:otherwise>
        </c:choose>
        [ <a href="view/webShop.jsp">Web Shop</a> ]
    </body>
</html>
