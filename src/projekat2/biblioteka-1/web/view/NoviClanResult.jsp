<%-- 
    File  : NoviClanResult
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : Ispisivanje odgovarajuće poruke o dodavanju novog člana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="poruka" class="model.Poruka" scope="session"/>
<jsp:useBean id="clan" class="model.Clan" scope="session"/>

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
                                        <h2>Član dodat</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Član: ${clan.jmbg}, ${clan.prezime}, ${clan.ime}, ${clan.email} je dodat!</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${poruka.sadrzaj=="!unetapolja"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Član nije dodat</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Niste popunili sva polja iz forme za dodavanje člana.<br>Pokušajte ponovo.</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${poruka.sadrzaj=="jmbgpostoji"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Član nije dodat</h2>
                                    </div>
                                    <div class="entry">
                                        <p>Član: ${clan.jmbg}, ${clan.prezime}, ${clan.ime}, ${clan.email} nije dodat jer JMBG <b>${clan.jmbg}</b> već postoji!</p>
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