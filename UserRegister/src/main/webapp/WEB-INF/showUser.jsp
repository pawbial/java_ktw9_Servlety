
<%@ page import="pl.sdacademy.register.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-03
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.html" %>
<p> USER PROFILE </p>


First name: ${user.firstName}
<br>
Last name: ${user.lastName}
<br>
Address: ${user.addressDTO}
<br>


</body>
</html>
