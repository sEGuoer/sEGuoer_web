<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/23
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>YourMessage</title>
    <link rel="stylesheet" href="./vite/build/assets/app.css">
</head>
<body>
<div class="mx-md-5 px-md-5 mt-5">
    <ul class="list-group">
        <li class="list-group-item text-center"><%="YourEmail="%>${user.getEmail()}</li>
        <li class="list-group-item text-center"><%="YourPassword="%>${user.getPassword()}</li>
        <li class="list-group-item text-center"><%="YourAccount="%>${user.getAccount()}</li>
    </ul>
</div>

</body>
</html>
