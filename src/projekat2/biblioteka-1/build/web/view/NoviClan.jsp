<%-- 
    File  : NoviClan
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Popunjavanje podataka za unos novog člana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <div class="post">
                            <div class="title">
                                <h2>Dodavanje člana</h2>
                                <p>Unesite podatke i kliknute na dugme <b>Pošalji</b></p>
                            </div>
                            <div class="entry">
                                <form name="frmUnosClana" action="/Biblioteka/NoviClanServlet">
                                    <table class="unos">
                                        <tbody>
                                            <tr>
                                                <td>JMBG:</td>
                                                <td><input type="text" name="jmbg" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>Prezime:</td>
                                                <td><input type="text" name="prezime" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>Ime:</td>
                                                <td><input type="text" name="ime" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>E-mail:</td>
                                                <td><input type="text" name="email" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td> </td>
                                                <td><input type="submit" value="Pošalji" name="btnSend" /></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </form>
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