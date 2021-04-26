<%-- 
    File  : KnjigeUBiblioteci
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Prikaz svih knjiga koje se nalaze u biblioteci
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
                                <h2>Pregled svih knjiga u biblioteci</h2>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Naslov</th>
                                        <th>Autor</th>
                                        <th>Broj primeraka</th>
                                    </tr>
                                    <c:forEach var="knjiga" items="${biblioteka.knjige}">
                                        <tr>
                                            <td>${knjiga.isbn}</td>
                                            <td>${knjiga.naslov}</td>
                                            <td>${knjiga.autor}</td>
                                            <td>${knjiga.brSlobodnih} (<a href="/Biblioteka/ZaduziKnjiguServlet?isbn=${knjiga.isbn}">zaduži</a>)</td>
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