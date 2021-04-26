<%-- 
    File  : ZaduzenjaClana
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Pregled zaduženja jednog člana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="biblioteka" class="model.Biblioteka" scope="session"/>
<jsp:useBean id="user" class="model.User" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Član</h2>
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
                                <form action="/Biblioteka/ZaduzenjaClanaServlet" method="get">
                                    <select name="filter">
                                        <option value="sva" selected>Spisak svih zaduženja</option>
                                        <option value="svaAktivna">Spisak svih aktivnih zaduženja</option>
                                        <option value="svaAktivnaProbijena">Spisak svih aktivnih zaduženja gde je rok probijen</option>
                                    </select>
                                    <input type="hidden" name="jmbg" value="${user.jmbg}">
                                    <input name="" type="submit" value="Filtriraj">
                                </form>
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