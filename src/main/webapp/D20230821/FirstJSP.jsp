<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/21
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>firstMeetJsp</title>
</head>
<body>
<% System.out.println("hello jsp"); %>
<%= "hello,jsp" %>
<%!public void sout(){
    System.out.println("这是一个方法");
}  %>
<%!static int a = 1;%>
</body>
</html>
