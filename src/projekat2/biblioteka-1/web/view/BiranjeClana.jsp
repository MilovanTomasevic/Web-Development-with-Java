<%-- 
    File  : BiranjeClana
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Izbor člana koji zadužuje knjigu
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="biblioteka" class="model.Biblioteka" scope="session"/>
<jsp:useBean id="zaduzenje" class="model.Zaduzenje" scope="session"/>
<jsp:useBean id="knjiga" class="model.Knjiga" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Knjiga</h2>
                                <p>Knjiga koja se zadužuje</p>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Naslov</th>
                                        <th>Autor</th>
                                        <th>Broj primeraka</th>
                                    </tr>
                                    <tr>
                                        <td>${knjiga.isbn}</td>
                                        <td>${knjiga.naslov}</td>
                                        <td>${knjiga.autor}</td>
                                        <td>${knjiga.brSlobodnih}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="post">
                            <div class="title">
                                <h2>Izbor člana</h2>
                                <p>Odaberite člana koji zadužuje knjigu</p>
                            </div>
                            <div class="entry">
                                <table>
                                    <tr>
                                        <th width="20%">JMBG</th>
                                        <th width="20%">Prezime</th>
                                        <th width="20%">Ime</th>
                                        <th width="20%">E-mail</th>

                                    </tr>
                                    <c:forEach var="clan" items="${biblioteka.clanovi}">
                                        <tr>
                                            <td><a href="NovoZaduzenjeServlet?jmbg=${clan.jmbg}">${clan.jmbg}</a></td>
                                            <td>${clan.ime}</td>
                                            <td>${clan.prezime}</td>
                                            <td>${clan.email}</td>
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