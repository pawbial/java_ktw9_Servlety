<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-16
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="header.html" %>

<form method="post">

    <h1>Login</h1>

    <c:if test="${not empty requestScope.userNotFoundError}">
        <userNotFoundError>${requestScope.userNotFoundError}</userNotFoundError>
        <br>
    </c:if>

    <c:if test="${not empty requestScope.passwordMatchError}">
        <passwordMatchError>${requestScope.passwordMatchError}</passwordMatchError>
        <br>
    </c:if>


    <label for="userNameLogin">Last name ...</label>
    <input type="text" id="userNameLogin" name="userNameLogin">
    <br>
    <label for="passwordLogin">Password ...</label>
    <input type="password" id="passwordLogin" name="passwordLogin">

    <p>Otherwise create new account <a href="/user">HERE!!!</a></p>

    <input type="submit" value="submit">

</form>

</body>
</html>
