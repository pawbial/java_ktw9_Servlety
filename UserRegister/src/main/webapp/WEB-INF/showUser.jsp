<%@ page import="pl.sdacademy.register.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-03
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.html" %>
<p> USER PROFILE </p>


First name: <${user.firstname}/>
<br>
Last name: <${user.lastname}/>
<br>
Address: <jsp:getProperty name="user" property="addressDTO"/>
<br>


</body>
</html>
