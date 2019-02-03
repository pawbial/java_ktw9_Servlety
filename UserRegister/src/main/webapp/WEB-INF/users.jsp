<%@ page import="pl.sdacademy.register.UserDTO" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-03
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Address name</td>
        </tr>
    </table>
</head>
<body>
<% for (UserDTO userDTO:(Collection<UserDTO>)request.getAttribute("users")){ %>
<tr>
    <td><%= userDTO.getFirstName()%></td>
    <td><%= userDTO.getLastName()%></td>
    <td><%= userDTO.getAddressDTO()%></td>
</tr>
<br>

<% } %>
</body>
</html>
