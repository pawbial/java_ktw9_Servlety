<%@ page import="java.time.LocalDateTime" %>
<%@ page import="pl.sdacademy.Counter" %><%--
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
<%--<%! int counter = 0;%> //deklaracja pola w klasie--%>
<body>
<%--poniżej skryptlet--%>
    <p>Dzisiaj jest: <%= LocalDateTime.now().toString()%></p>
<%--poniżej wyrażenie--%>
    <% out.print("Licznik odwiedzin: " + Counter.INSTANCE.getCounter());%>
<P>Hello <%request.getParameter("name");%></p>
</body>
</html>
