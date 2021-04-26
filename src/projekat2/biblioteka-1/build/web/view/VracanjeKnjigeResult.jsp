<%-- 
    File  : VracanjeKnjigeResult
    Autor : Milovan Tomašević, e11988
    Datum : 29.06.2009.
    Opis  :
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
                        <div class="post">
                            <div class="title">
                                <h2>Knjiga vraćena</h2>
                            </div>
                            <div class="entry">
                                <p>
                                    <b>Knjiga</b>: ${zaduzenjeInfo.isbn}, ${zaduzenjeInfo.naslov}, ${zaduzenjeInfo.autor}<br>
                                    koju je zadužio <b>član</b>: ${zaduzenjeInfo.jmbg}, ${zaduzenjeInfo.prezime}, ${zaduzenjeInfo.ime}, ${zaduzenjeInfo.email}<br>
                                    je vraćena na dan ${zaduzenjeInfo.datum}
                                </p>
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