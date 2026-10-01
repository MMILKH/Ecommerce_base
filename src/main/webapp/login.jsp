<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>Login - E-Commerce</title>
</head>
<body>

<div >
    <h2>Accedi</h2>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div >
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div >
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit" >Accedi</button>
    </form>

    <c:if test="${not empty errore}">
        <div >
                ${errore}
        </div>
    </c:if>

</div>

</body>
</html>