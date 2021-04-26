<%-- 
    File  : registerResult
    Autor : Milovan Tomašević, e11988
    Datum : 02.06.2009.
    Opis  : Registruje i loguje korisnika ili ga obaveštava o grešci
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>

<c:choose>
    <c:when test="${user.ulogovan==false}">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Registracija - WebShop</title>
            </head>
            <body>
                <h3>Registracija novog korisnika</h3>
                <p>Username je već zauzet. Izaberite drugi username.</p>
                <p>[ <a href="view/registracija.jsp">Registracija</a> ]</p>
                <p>[ <a href="index.jsp">Login</a> ]</p>
            </body>
        </html>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect("view/webShop.jsp");%>
    </c:otherwise>
</c:choose>