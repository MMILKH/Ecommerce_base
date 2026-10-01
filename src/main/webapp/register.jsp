<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>Register - E-Commerce</title>
</head>
<body>

<div >
    <h2>Registrati</h2>

    <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <label for="nome">nome</label>
                <input id="nome"  name="nome" required>
            </div>
            <div class="form-group">
                <label for="cognome">cognome</label>
                <input id="cognome" name="cognome" required>
            </div>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>

            <div class="form-group">
                <label for="numero">Numero</label>
                <input  id="numero" name="numero" required>
            </div>
            <div class="form-group">
                <label for="indirizzo">Indirizzo</label>
                <input  id="indirizzo" name="indirizzo" >
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>

            <div class="form-group">
                <label for="passwordconf">Conferma Password</label>
                <input type="password" id="passwordconf" name="passwordconf" required>
            </div>



        <button type="submit" >Registrati</button>
    </form>

    <c:if test="${not empty errore}">
        <div  >
                ${errore}
        </div>
    </c:if>

</div>

</body>
</html>