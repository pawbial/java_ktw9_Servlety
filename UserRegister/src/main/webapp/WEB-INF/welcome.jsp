<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.sdacademy.register.UserDAO" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-02
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%@include file="header.html" %>

<c:if test="${not empty param.userName}">
    <p>Welcome! Registration was successful!<br>User name: ${param.userName}</p>
</c:if>
<c:if test="${not empty requestScope.userName}">
    <p>Welcome! Login successful!<br>Username: ${requestScope.userName}</p>
</c:if>
<br>
<a href="/list">Users list</a>
<br>
<a href="/user">Add another user</a>
<br>
<a href="/login">Login to account</a>

<c:if test="${not empty sessionScope.login}">

</c:if>

</body>
</html>
