<%--
    File  : SvaZaduzenja
    Autor : Milovan Tomašević, e11988
    Datum : 27.06.2009.
    Opis  : Prikaz svih zaduzenja
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
                                <h2>Pregled svih zaduženja</h2>
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
                                            <c:choose>
                                                <c:when test='${zaduzenje.datVracanja=="još nije vraćena"}'>
                                                    <td><a href="/Biblioteka/VracanjeKnjigeServlet?id=${zaduzenje.id}">vraćanje knjige</a></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${zaduzenje.datVracanja}</td>
                                                </c:otherwise>
                                            </c:choose>
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