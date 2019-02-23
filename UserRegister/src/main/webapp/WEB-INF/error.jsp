<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 2019-02-04
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration error</title>
</head>
<body>

<p>
    Sorry ... Please fill all the forms correctly. <br>
    Fields cannot be empty!<br>
    Thank You!
    <br>
    <a href="user">Back</a>

    <c:if test="${not empty sessionScope.login}">

    </c:if>
</p>

</body>
</html>
