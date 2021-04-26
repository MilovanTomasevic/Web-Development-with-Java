<%-- 
    File  : NovaKnjigaResult
    Autor : Milovan Tomašević, e11988
    Datum : 30.06.2009.
    Opis  : Ispisivanje odgovarajuće poruke o dodavanju nove knjige
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="poruka" class="model.Poruka" scope="session"/>
<jsp:useBean id="knjiga" class="model.Knjiga" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <c:choose>
                            <c:when test='${poruka.sadrzaj=="ok"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Knjiga dodata</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Knjiga: ${knjiga.isbn}, ${knjiga.naslov}, ${knjiga.autor} je dodata!</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${poruka.sadrzaj=="!unetapolja"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Knjiga nije dodata</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Niste popunili sva polja iz forme za dodavanje knjige.<br>Pokušajte ponovo.</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${poruka.sadrzaj=="isbnpostoji"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Knjiga nije dodata</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Knjiga: ${knjiga.isbn}, ${knjiga.naslov}, ${knjiga.autor} nije dodata jer ISBN <b>${knjiga.isbn}</b> već postoji!</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${poruka.sadrzaj=="errslobodni"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Knjiga nije dodata</h2>
                                    </div>
                                    <div class="entry">
                                        <p><b>Greška</b>: pogrešno ste uneli <b>Broj slobodnih</b> knjiga. Broj slobodnih mora biti veći ili jednak nuli i mora biti ceo broj.</p>
                                    </div>
                                </div>
                            </c:when>
                        </c:choose>
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