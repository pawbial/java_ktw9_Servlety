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
    <%UserDTO user = new UserDTO();
    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setStreet("");
    addressDTO.setHouseNumber("");
    addressDTO.setCity("");
    user.setFirstName("");
    user.setLastName("");
    user.setAddressDTO(addressDTO);
    %>
    <%UserDTO userDTO = (UserDTO)request.getAttribute("user");%>
    <%if (userDTO != null) {
         user = userDTO;
         request.setAttribute("id",user.getId());
    }
        ;%>

    <form method="post">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" value="<%= user.getFirstName()%>">
        <br>

        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" value="<%= user.getLastName()%>">
        <br>

        <label for="city">Cit</label>
        <input type="text" id="city" name="city"value="<%= user.getAddressDTO().getCity()%>">
        <br>

        <label for="street">Street</label>
        <input type="text" id="street" name="street"value="<%= user.getAddressDTO().getStreet()%>">
        <br>

        <label for="houseNumber">House Number</label>
        <input type="text" id="houseNumber" name="houseNumber"value="<%= user.getAddressDTO().getHouseNumber()%>">
        <br>

        <input type="submit" value="submit">

    </form>
    <%%>
</body>
</html>
