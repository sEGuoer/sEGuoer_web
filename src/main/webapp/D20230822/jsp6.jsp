<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<c:forEach items="${list}" var="user" >
    <tr>
        <td>${user.getEmail()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getAccount()}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
