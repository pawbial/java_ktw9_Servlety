<%--
  Created by IntelliJ IDEA.
  User: adam
  Date: 02/02/2019
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Collection" %>
<%@ page import="pl.sdacademy.register.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <style>
        body {
            background-color: powderblue;
        }
        h1 {
            color: red;
        }
        p {
            color: blue;
        }
        td {
            border: solid black 2px;
            border-radius: 5px
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Address name</td>
        <td>Action</td>
    </tr>
    <% for (UserDTO userDTO:(Collection<UserDTO>)request.getAttribute("users")){ %>
    <tr>
        <td><%= userDTO.getFirstName()%></td>
        <td><%= userDTO.getLastName()%></td>
        <td><%= userDTO.getAddressDTO()%></td>
        <td><a href="userProfile?id=<%= userDTO.getId()%>"> Show User Account</a></td>
    </tr>
    <br>
    <% } %>
</table>
</body>
</html>