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
            <span>Carrello di <strong>${utenteLoggato.nome} ${utenteLoggato.cognome}</strong></span>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login">Accedi</a>
        </c:otherwise>
    </c:choose>
</div>
<div>

    <div>
        <c:forEach items ="${listaProdotti}" var="p">
            <div >
                <h3>${p.nome}</h3>
                <p>${p.descrizioneBreve}</p>
                <p>${p.prezzo}</p>
                <div>
                <form action="${pageContext.request.contextPath}/carrello" method="post" style="display:inline;">
                    <input type="hidden" name="prodottoId" value="${p.id}" />
                    <input type="number" name="quantita" value="${listaQuantita[p.id]}" min="1" max="99" style="width: 50px;" />
                    <button type="submit">Modifica quantita</button>
                </form>
                </div>

            </div>


        </c:forEach>

        <br>
        <br>

        <h1>TOTALE:${totale}</h1>


    </div>

</div>


</body>
</html>



