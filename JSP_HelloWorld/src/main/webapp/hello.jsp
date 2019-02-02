<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-02
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HelloWorld</title>
</head>
<body>
    <p>Dzisiaj jest: <%= LocalDateTime.now().toString()%></p>
</body>
</html>
