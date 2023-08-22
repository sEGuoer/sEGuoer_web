<%@ page import="D20230818.JDBCDemo" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="D20230815.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/22
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>firstMeetJsp</title>
</head>
<body>
<%!private static volatile JDBCDemo jdbcTest;%>
<%!
    public static JDBCDemo getJdbcTest() {
        if (jdbcTest == null) {
            synchronized (JDBCDemo.class) {
                if (jdbcTest == null) {
                    jdbcTest = new JDBCDemo();
                }
            }
        }
        return jdbcTest;
    }
%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("pwd");
    System.out.println(email + " " + password);
    JDBCDemo jdbcDemo = getJdbcTest();
    Connection connection = jdbcDemo.getConnection();
    User user = jdbcDemo.getUser(connection, email);
    System.out.println(user == null);
    if (user == null) {
%>
<p><%="没有找到该用户"%>
</p>
<%
} else {
    if (user.getPassword().equals(password)) {
        if (user.getUsername().equals("admin")) {
           List<User> list = jdbcDemo.testPreparedStatement(connection);
%>
<table>
    <tr>
        <td>
            <%="username" %>
        </td>
        <td>
                <%="email" %>
        <td>
            <%="password" %>
        </td>
        <td>
            <%="account" %>
        </td>
    </tr>
    <%
        for (User useri : list) {
    %>
    <tr>
        <td><%=useri.getUsername()%></td>
        <td><%=useri.getEmail()%></td>
        <td><%=useri.getPassword()%></td>
        <td><%=useri.getAccount()%></td>
    </tr>
    <%
        }
    %>
</table>
<%
} else {
    String users = user.toString();
%>
<p><%=users%>
</p>
<%
    }
} else {
%>
<p><%="密码错误，请重新输入"%>
</p>
<%
        }
    }
%>
</body>
</html>