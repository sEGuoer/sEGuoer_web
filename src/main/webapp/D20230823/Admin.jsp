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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
</head>
<body class="sidebar-mini" style="height: auto;">
<div class="wrapper">

    <nav class="main-header navbar navbar-expand navbar-white navbar-light">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Content</a>
            </li>
        </ul>

        <ul class="navbar-nav ml-auto">


            <li class="nav-item dropdown">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <img src="./img/Cache_247709949bd616a9..jpg" alt="touxiang" width="20px" height="20px"> </a>

            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large">admin</i>
                </a>
            </li>
        </ul>
    </nav>


    <aside class="main-sidebar sidebar-dark-primary elevation-4">


        <div class="sidebar">

            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="./img/Cache_247709949bd616a9..jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Admin</a>
                </div>
            </div>


            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                Dashboard
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Users
                                <span class="right badge badge-danger">无语了哥们</span>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>

        </div>

    </aside>

    <div class="content-wrapper" style="min-height: 1000px;">

        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>用户列表</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right" id="UserList">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">
                                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                    <div class="btn-group me-2" role="group" aria-label="First group">
                                        <button type="button" class="btn btn-primary" onclick="inputAddUser()">+
                                        </button>
                                        <button type="button" class="btn btn-primary" onclick="previousPage()">上一页
                                        </button>
                                        <button type="button" class="btn btn-primary" onclick="nextPage()">下一页
                                        </button>
                                    </div>
                                </div>
                            </li>
                        </ol>
                    </div>
                </div>
            </div>
        </section>

        <section class="content">

            <div class="card">
                <div class="card-body">
                    <table class="table mb-0">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Email</th>
                            <th scope="col">Password</th>
                            <th scope="col">Account</th>
                            <th scope="col"></th>
                        </tr>
                        <c:forEach items="${list}" var="user" begin="0" end="8" varStatus="i">
                            <tr id="${user.getEmail()}">
                                <th scope="col">${i.count}</th>
                                <td>${user.getEmail()}</td>
                                <td>${user.getPassword()}</td>
                                <td>${user.getAccount()} </td>
                                <td>
                                    <div class="btn-group me-2" role="group" aria-label="First group">
                                        <button id="deleteUser" type="button" class="btn btn-info"
                                                onclick="deleteUser()">删除
                                        </button>
                                        <button id="updateUser" type="button" class="btn btn-info"
                                                onclick="updateUserButton()">更新
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="card-footer clearfix">
                    <ul class="pagination pagination-sm m-0 float-right">
                        <li class="page-item">共${pageSum}页</li>
                        <li class="page-item" onclick=homePage()><span class="page-link">«</span></li>
                        <li class="page-item" onclick=previousPage()><span class="page-link">«</span></li>
                        <li class="page-item" onclick=homePage()><span class="page-link">1</span></li>
                        <li class="page-item" id="pageSum" onclick=lastPage()><span class="page-link">${pageSum}</span></li>
                        <li class="page-item" onclick=nextPage()><span class="page-link">»</span></li>
                    </ul>
                </div>
            </div>

        </section>

    </div>

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>QQ:</b> 8571848
        </div>
        <strong>Desingned by <a href="https://adminlte.io">@sEGuoer</a>© 2023</strong>
    </footer>

    <div id="sidebar-overlay"></div>
</div>
<script src="./vite/build/assets/app.js"></script>
<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
<script src="./js/admin.js "></script>
</body>
</html>
