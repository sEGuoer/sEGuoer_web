<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/23
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="./vite/build/assets/app.css">
</head>
<body>
<div class="mx-md-5 px-md-5 mt-5">
    <table class="table">
        <tr>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Account</th>
        </tr>
        <c:forEach items="${list}" var="user" >
            <tr>
                <td>${user.getEmail()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getAccount()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
