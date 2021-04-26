<%-- 
    File  : header
    Autor : Milovan Tomašević, e11988
    Datum : 28.06.2009.
    Opis  : Header svake JSP stranice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Biblioteka</title>
        <link href="/Biblioteka/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                    <h1>Biblioteka</h1>
                    <h2>Fakultet Tehničkih Nauka</h2>
                </div>
                <!-- end #logo -->
                <div id="menu">
                    <ul>
                        <li class="first"><a>Korisnik: <b>${bibliotekar.username}</b></a></li>
                        <li><a href="/Biblioteka/BibliotekarLoginServlet?logoff=true">Odjava</a></li>
                    </ul>
                </div>
                <!-- end #menu -->
            </div>
            <!-- end #header -->