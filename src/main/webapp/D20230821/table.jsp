<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/8/21
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="D20230815.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<User> list = new ArrayList<>();
    User user1 = new User();
    user1.setUser("1", "1@qq.com", "123", "zcy1");
    list.add(user1);
    User user2 = new User();
    user2.setUser("2", "2@qq.com", "321", "zcy2");
    list.add(user2);
    User user3 = new User();
    user3.setUser("3", "3@qq.com", "222", "zcy3");
    list.add(user3);
%>
<%= "<table>\n" %>
<%= "<tr\n>"%>
<%= "<td\n>"%>
<%="username" %>
<%= "</td\n>"%>
<%= "<td\n>"%>
<%="email" %>
<%= "</td\n>"%>
<%= "<td\n>"%>
<%="password" %>
<%= "</td\n>"%>
<%= "<td\n>"%>
<%="account" %>
<%= "</td\n>"%>
<%= "</tr\n>"%>
<% String sout = "";
    for (User user : list) {
        sout = sout + "<tr\n>" + "<td\n>" + user.getUsername() +
                "</td\n>" + "<td\n>" + user.getEmail() + "</td\n>" +
                "<td\n>" + user.getPassword() + "</td\n>" + "</td\n>" +
                "<td\n>" + user.getAccount() + "</td\n>" + "</tr\n>";
    }
%>
<%=sout %>
<%= "</table>\n" %>
</body>
</html>
