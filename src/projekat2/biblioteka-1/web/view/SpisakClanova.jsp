<%-- 
    File  : SpisakClanova
    Autor : Milovan Tomašević, e11988
    Datum : 28.06.2009.
    Opis  : Spisak svih članova biblioteke
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="biblioteka" class="model.Biblioteka" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Pregled svih članova</h2>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th width="20%">JMBG</th>
                                        <th width="20%">Prezime</th>
                                        <th width="20%">Ime</th>
                                        <th width="20%">E-mail</th>
                                        <th width="20%">Zaduženja</th>
                                    </tr>
                                    <c:forEach var="clan" items="${biblioteka.clanovi}">
                                        <tr>
                                            <td>${clan.jmbg}</td>
                                            <td>${clan.ime}</td>
                                            <td>${clan.prezime}</td>
                                            <td>${clan.email}</td>
                                            <td><a href="/Biblioteka/ZaduzenjaClanaServlet?jmbg=${clan.jmbg}">zaduženja</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                    <%@ include file="sidebar.jsp"%>
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