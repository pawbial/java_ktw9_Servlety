<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ page isELIgnored="false" %>
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
<%@include file="header.html" %>
<table>
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Address name</td>
        <td>Action</td>
        <td>Edit</td>
    </tr>
    <%--<% for (UserDTO userDTO:(Collection<UserDTO>)request.getAttribute("users")) {%>--%>
    <%--<% request.setAttribute("userDTO", userDTO);%>-- wersja poprzednia, bez tagLibrary%>




<tr>
<%--<td><%= userDTO.getFirstName()%></td>--%>
    <c:choose>

        <c:when test="${not empty users}">

            <c:forEach var="userDTO" items="${users}">

                <tr>
                    <td>${userDTO.firstName}</td>
                        <%--<td><%= userDTO.getLastName()%></td>--%>
                    <td>${userDTO.lastName}</td>
                        <%--<td><%= userDTO.getAddressDTO()%></td>--%>
                    <td>${userDTO.addressDTO}</td>
                    <td><a href="userProfile?id=${userDTO.id}"> Show User Account</a></td>
                    <td><a href="userEdit?id=${userDTO.id}"> Edit Account</a></td>
                </tr>

            </c:forEach>
        </c:when>
        <c:otherwise>

            <p>No users in database</p>

        </c:otherwise>

    </c:choose>
    <br>
    <%--<% } %>wersja poprzednia bez tagLib i bez EL's--%>
</table>
</body>
</html>