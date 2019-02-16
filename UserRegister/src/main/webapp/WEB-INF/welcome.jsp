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
<%@include file="header.html"%>
<p>
    Welcome! Registration was successful!<br>

    <br>
    <a href="/list">Users list</a>
    <br>
    <a href="/user">Add another user</a>
</p>
</body>
</html>
