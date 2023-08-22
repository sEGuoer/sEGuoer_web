<%@ page import="D20230818.JDBCDemo" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="D20230815.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String email = request.getParameter("email");
  String password = request.getParameter("pwd");
  JDBCDemo jdbcDemo = getJdbcTest();
  Connection connection = jdbcDemo.getConnection();
  User user = jdbcDemo.getUser(connection, email);
  System.out.println(user == null);
  if (user == null) {
    jdbcDemo.soutYourInfo(response, "没有找到该用户");
  } else {
    if (user.getPassword().equals(password)) {
      if (user.getUsername().equals("admin")) {
        jdbcDemo.soutYourInfo(response, jdbcDemo.testPreparedStatement(connection).toString());
      } else {
        jdbcDemo.soutYourInfo(response, user.toString());
      }
    }else {
      jdbcDemo.soutYourInfo(response, "密码错误，请重新输入");
    }
  }
%>
</body>
</html>
