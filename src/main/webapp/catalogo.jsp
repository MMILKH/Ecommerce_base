<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>


<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title >Catalogo - E-Commerce</title>
    <h1 >CATALOGO</h1>
</head>
<body>

<div >
    <c:choose>

        <c:when test="${not empty utenteLoggato}">
            <span>Benvenuto, <strong>${utenteLoggato.nome} ${utenteLoggato.cognome}</strong></span>
            <a href="${pageContext.request.contextPath}/login?azione=logout" >Logout</a>
        </c:when>


        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login">Accedi</a>
        </c:otherwise>
    </c:choose>
</div>
<div>
    <form action="${pageContext.request.contextPath}/catalogo" method="get">
        <label>Categoria</label>
        <select name="categoria">
            <option value="">Tutti i prodotti</option>
            <option value="Elettronica"> Elettronica</option>
            <option value="Abbigliamento"> Abbigliamento </option>
            <option value="Accessori"> Accessori</option></select>
        <button type="submit">Filtra</button>

    </form>


    <div>
        <c:forEach items ="${listaProdotti}" var="p">
            <div >
                <h3>${p.nome}</h3>
                <p>${p.descrizioneBreve}</p>
                <p>${p.prezzo}</p>
            </div>

            <c:choose>

                <c:when test="${not empty utenteLoggato}">
                    <form action="${pageContext.request.contextPath}/aggiungiCarrello" method="post">
                        <input type="hidden" name="prodottoId" value="${p.id}" />
                        QTA:<input type="number" name="quantita" value="1" min="1"/>
                        <button type="submit" >Aggiungi al Carrello</button>
                    </form>
                </c:when>


                <c:otherwise>
                    <p >
                        <a href="${pageContext.request.contextPath}/login">Accedi</a> per aggiungere al carrello
                    </p>
                </c:otherwise>
            </c:choose>

        </c:forEach>


    </div>

</div>


</body>
</html>
