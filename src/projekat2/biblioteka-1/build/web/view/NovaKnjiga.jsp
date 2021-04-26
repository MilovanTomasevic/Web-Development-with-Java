<%-- 
    File  : NovaKnjiga
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Popunjavanje podataka za unos nove knjige
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
                                <h2>Dodavanje knjige</h2>
                                <p>Unesite podatke i kliknute na dugme <b>Pošalji</b></p>
                            </div>
                            <div class="entry">
                                <form name="frmUnosClana" action="/Biblioteka/NovaKnjigaServlet">
                                    <table class="unos">
                                        <tbody>
                                            <tr>
                                                <td>ISBN:</td>
                                                <td><input type="text" name="isbn" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>Naslov:</td>
                                                <td><input type="text" name="naslov" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>Autor:</td>
                                                <td><input type="text" name="autor" value="" /></td>
                                            </tr>
                                            <tr>
                                                <td>Broj primeraka:</td>
                                                <td><input type="text" name="brojprimeraka" value="" /></td>
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