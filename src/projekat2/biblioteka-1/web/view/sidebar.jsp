<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
    <ul>
        <li>
            <h2>Knjige</h2>
            <ul>
                <li><a href="/Biblioteka/KnjigeServlet?sveKnjige=true">Sve knjige</a></li>
                <li><a href="/Biblioteka/KnjigeServlet?knjigeUBiblioteci=true">Knjige u biblioteci</a></li>
                <li><a href="/Biblioteka/view/NovaKnjiga.jsp">Nova knjiga</a></li>
            </ul>
        </li>
        <li>
            <h2>Članovi</h2>
            <ul>
                <li><a href="/Biblioteka/ClanoviServlet">Pregled članova</a></li>
                <li><a href="/Biblioteka/view/NoviClan.jsp">Novi član</a></li>
            </ul>
        </li>
        <li>
            <h2>Zaduženja</h2>
            <ul>
                <li><a href="/Biblioteka/ZaduzenjaServlet?svaZaduzenja=true">Sva zaduženja</a></li>
                <li><a href="/Biblioteka/ZaduzenjaServlet?aktivnaZaduzenja=true">Aktivna zaduženja</a></li>
                <li><a href="/Biblioteka/ZaduzenjaServlet?probijeniRokovi=true">Aktivna sa probijenim rokom</a></li>
            </ul>
        </li>
    </ul>
    <br>
</div>
<!-- end #sidebar -->