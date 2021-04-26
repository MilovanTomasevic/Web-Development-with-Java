<%-- 
    File  : ZaduzenjeResult
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  : U zavisnosti od statusa zaduzenja, ispisuje odgovarajuću poruku
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bibliotekar" class="model.Bibliotekar" scope="session"/>
<jsp:useBean id="zaduzenjeInfo" class="model.ZaduzenjeInfo" scope="session"/>

<c:choose>
    <c:when test="${bibliotekar.ulogovan==true}">
        <%@ include file="header.jsp"%>
        <div id="page">
            <div id="bgtop">
                <div id="bgbottom">
                    <div id="content">
                        <c:choose>
                            <c:when test='${zaduzenjeInfo.result=="ok"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Zaduženje sačuvano</h2>
                                    </div>
                                    <div class="entry">
                                        <p>
                                            <b>Član</b>: ${zaduzenjeInfo.jmbg}, ${zaduzenjeInfo.prezime}, ${zaduzenjeInfo.ime}, ${zaduzenjeInfo.email} je zadužio <b>knjigu</b>: ${zaduzenjeInfo.isbn}, ${zaduzenjeInfo.naslov}, ${zaduzenjeInfo.autor}.<br>
                                            <b>Datum zaduživanja</b>: ${zaduzenjeInfo.datum}
                                        </p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${zaduzenjeInfo.result=="nemaslobodnih"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Nema slobodnih knjiga</h2>
                                    </div>
                                    <div class="entry">
                                        <p>
                                            Knjigu: <b>${zaduzenjeInfo.isbn}</b>, ${zaduzenjeInfo.naslov}, ${zaduzenjeInfo.autor} je u međuvremenu zadužio drugi bibliotekar. Tek kada neko vrati ovu knjigu, moći ćete je zadužiti.<br>Hvala na razumevanju.
                                        </p>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test='${zaduzenjeInfo.result=="maxaktivnih"}'>
                                <div class="post">
                                    <div class="title">
                                        <h2>Knjiga nije zadužena</h2>
                                    </div>
                                    <div class="entry">
                                        <p>
                                            Član: <b>${zaduzenjeInfo.jmbg}</b>, ${zaduzenjeInfo.prezime} ${zaduzenjeInfo.ime}, ${zaduzenjeInfo.email} ima maksimalan broj aktivnih zaduženja, stoga nije moguće odobriti novo zaduženje.<br>
                                            Hvala na razumevanju.
                                        </p>
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