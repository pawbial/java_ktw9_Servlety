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

    <p>Login</p>

    <label for="lastName">Last name ...</label>
    <input type="text" id="lastName" name="lastName">
    <br>
    <label for="password">Password ...</label>
    <input type="password" id="password" name="password">

    <p>Otherwise create new account <a href="/user">HERE!!!</a></p>

    <input type="submit" value="submit">

</form>

</body>
</html>
