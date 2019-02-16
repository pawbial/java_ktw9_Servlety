<%@ page import="pl.sdacademy.register.UserDTO" %>
<%@ page import="pl.sdacademy.register.AddressDTO" %><%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-02
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserCreate</title>
</head>
<body>
    <%@include file="header.html"%>

    <%--<%UserDTO userDTO = (UserDTO)request.getAttribute("user");%>--%>
    <%--<%if (userDTO != null) {--%>
        <%--request.setAttribute("id",userDTO.getId());--%>
    <%--}-- pozostałość wersji poprzedniej, bez znajomości EL's :)%>
        <%--;%>--%>


    <c:if></c:if>
    <form method="post">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" value="${user.firstName}">
        <br>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" value="${user.lastName}">
        <br>

        <label for="password">Password</label>
        <input type="text" id="password" name="password" value="${user.password}">
        <br>

        <label for="passwordRetype">Repeat password</label>
        <input type="text" id="passwordRetype" name="passwordRetype" value="${user.password}">
        <br>

        <label for="city">Cit</label>
        <input type="text" id="city" name="city"value="${user.addressDTO.city}">
        <br>

        <label for="street">Street</label>
        <input type="text" id="street" name="street"value="${user.addressDTO.street}">
        <br>

        <label for="houseNumber">House Number</label>
        <input type="text" id="houseNumber" name="houseNumber"value="${user.addressDTO.houseNumber}">
        <br>

        <input type="submit" value="submit">

        ${request.setAttribute("id",user.id)}

    </form>

</body>
</html>
