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
    <title>jsp tl</title>
</head>
<body>
<c:if test="${type == 1}">
    admin
</c:if>
<c:if test="${type != 1}">
    user
</c:if>
</body>
</html>
