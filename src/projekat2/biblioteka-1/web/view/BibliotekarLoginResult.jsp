<%-- 
    File  : BibliotekarLoginResult
    Autor : Milovan Tomašević, e11988
    Datum : 27.06.2009.
    Opis  :
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==false}">
        <html>
        <head>
            <meta http-equiv="content-type" content="text/html; charset=utf-8" />
            <title>Biblioteka</title>
            <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
        </head>
        <body>
        <div id="wrapper">
        <div id="header">
            <div id="logo">
                <h1>Biblioteka</h1>
                <h2>Fakultet Tehničkih Nauka</h2>
            </div>
            <!-- end #logo -->
        </div>
        <!-- end #header -->
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Prijavljivanje onemogućeno</h2>
                                <p>Nije uspelo prijavljivanje na web servis</p>
                            </div>
                            <div class="entry">
                                <p>Pogrešno ste uneli username ili šifru. Pokušajte ponovo.</p>
                                [ <a href="index.jsp">Login</a> ]
                                <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                            </div>
                        </div>
                    </div>
                    <div style="clear: both;">&nbsp;</div>
                </div>
            </div>
        </div>
        <!-- end #page -->
        <%@ include file="footer.jsp"%>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect("view/BibliotekarHome.jsp");%>
    </c:otherwise>
</c:choose>
