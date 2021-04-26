<%--
    File  : UserHome
    Autor : Milovan Tomašević, e11988
    Datum : 27.06.2009.
    Opis  : Početna stranica člana biblioteke
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="model.User" scope="session"/>
<jsp:useBean id="biblioteka" class="model.Biblioteka" scope="session"/>

<c:choose>
    <c:when test="${user.ulogovan==true}">
        <html>
        <head>
            <meta http-equiv="content-type" content="text/html; charset=utf-8" />
            <title>Biblioteka</title>
            <link href="/Biblioteka/style.css" rel="stylesheet" type="text/css" media="screen" />
        </head>
        <body>
        <div id="wrapper">
        <div id="header">
            <div id="logo">
                <h1>Biblioteka</h1>
                <h2>Fakultet Tehničkih Nauka</h2>
            </div>
            <!-- end #logo -->
            <div id="menu">
                <ul>
                    <li class="first"><a href="/Biblioteka/UserLoginServlet?logoff=true">Odjava</a></li>
                </ul>
            </div>
            <!-- end #menu -->
        </div>
        <!-- end #header -->
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Prijavljeni član</h2>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th width="25%">JMBG</th>
                                        <th width="25%">Prezime</th>
                                        <th width="25%">Ime</th>
                                        <th width="25%">E-mail</th>
                                    </tr>
                                    <tr>
                                        <td>${user.jmbg}</td>
                                        <td>${user.prezime}</td>
                                        <td>${user.ime}</td>
                                        <td>${user.email}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="post">
                            <div class="title">
                                <h2>Zaduženja</h2>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th width="25%">JMBG</th>
                                        <th width="25%">ISBN</th>
                                        <th width="25%">Datum zaduženja</th>
                                        <th width="25%">Datum vraćanja</th>
                                    </tr>
                                    <c:forEach var="zaduzenje" items="${biblioteka.zaduzenja}">
                                        <tr>
                                            <td>${zaduzenje.jmbg}</td>
                                            <td>${zaduzenje.isbn}</td>
                                            <td>${zaduzenje.datZaduzenja}</td>
                                            <td>${zaduzenje.datVracanja}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="sidebar">
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    </div>
                    <!-- end #sidebar -->
                    <div style="clear: both;">&nbsp;</div>
                </div>
            </div>
        </div>
        <!-- end #page -->
        <%@ include file="footer.jsp"%>
    </c:when>
    <c:otherwise>
        <%response.sendRedirect("/Biblioteka/index.jsp");%>
    </c:otherwise>
</c:choose>