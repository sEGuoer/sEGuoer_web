<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/9/3
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="vite/build/assets/app.css">
    <style>
        html {
            height: 100%;
            width: 100%;
        }

        body {
            height: 100%;
            width: 100%;
        }

        #hoverfloat:hover {
            animation-duration: 1s;
            -webkit-animation-duration: var(--animate-duration);
        }

        #hoverfloat:hover {
            -webkit-animation-name: pulse;
            animation-name: pulse;
            -webkit-animation-timing-function: ease-in-out;
            animation-timing-function: ease-in-out
        }

        .card {
            width: 640px;
        }
    </style>
</head>

<body>
<div class="h-100 d-flex flex-column m-auto justify-content-between">
    <header>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <h1 class="d-flex align-items-center ">
                    <img src="img/Cache_247709949bd616a9..jpg" width="36" height="36" alt="MyPhoto">
                    <a class="link-underline link-underline-opacity-0 link-body-emphasis fs-6"
                       href="./index.html">我的主页</a>
                </h1>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup"
                        aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav ms-auto">
                        <a class="nav-link active" aria-current="page" href="#resume">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-file-earmark-person" viewBox="0 0 16 16">
                                <path d="M11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2v9.255S12 12 8 12s-5 1.755-5 1.755V2a1 1 0 0 1 1-1h5.5v2z"/>
                            </svg>
                            简历</a>
                        <a class="nav-link" href="#boke">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-book-half" viewBox="0 0 16 16">
                                <path d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                            </svg>
                            博客</a>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                学习仓库
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#javack">Java仓库</a></li>
                                <li><a class="dropdown-item" href="#htmlck">html仓库</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#myWebsiteck">主页仓库</a></li>
                            </ul>
                        </li>
                        <a href="./index_login.html" id="hoverfloat">
                            <button class="btn btn-danger">
                                <span class="text-center">登录</span>
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <main class="container">
        <div class="card m-auto rounded-3 shadow-sm">
            <div class="card-header py-3">
                <h4 class="my-0 fw-normal">登录</h4>
            </div>
            <div class="card-body text-center">
                <div class="small text-secondary">
                    <div class="my-2"><span class="text-danger me-2"><svg xmlns="http://www.w3.org/2000/svg" width="16"
                                                                          height="16"
                                                                          fill="currentColor"
                                                                          class="bi bi-check2-circle"
                                                                          viewBox="0 0 16 16">
  <path d="M2.5 8a5.5 5.5 0 0 1 8.25-4.764.5.5 0 0 0 .5-.866A6.5 6.5 0 1 0 14.5 8a.5.5 0 0 0-1 0 5.5 5.5 0 1 1-11 0z"/>
  <path d="M15.354 3.354a.5.5 0 0 0-.708-.708L8 9.293 5.354 6.646a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l7-7z"/>
</svg>(推荐方案)</span>建议优先使用此方案
                    </div>
                    <a href="" class="">
                        <button type="button" class="btn btn-outline-danger">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-github" viewBox="0 0 16 16">
                                <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"></path>
                            </svg>
                            GitHub
                        </button>
                    </a>
                </div>
                <form class="m-4 px-5 mx-5" method="post" action="verify">
                    <div class="small text-secondary mb-2 mt-5">邮箱登录，备选方法</div>
                    <div class="mb-3 text-start">
                        <label for="exampleInputEmail1" class="form-label">邮箱</label>
                        <input type="email" required class="form-control" name="email" id="exampleInputEmail1"
                               aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">输入的邮箱只用于登录，不会用作其他途径</div>
                    </div>
                    <div class="mb-3 text-start">
                        <label for="exampleInputPassword1" class="form-label">密码</label>
                        <input type="password" class="form-control" name="pwd" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3 form-check text-start">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Remember me</label>
                    </div>
                    <div class="text-start">
                        <button type="submit" class="btn btn-danger">登录</button>
                        <a href="./index_forgetpw.html"
                           class="link-secondary link-offset-2 link-underline link-underline-opacity-0 mx-2 small">忘记密码</a>
                        <a href="./index_register.html"
                           class="link-secondary link-offset-2 link-underline link-underline-opacity-0 mx-2 small">注册新账号</a>
                    </div>
                </form>
            </div>
            <div class="text-center">
                <% int userCount = (int) session.getAttribute("userCount"); %>
                <h2>当前有<%=userCount%>个用户在线</h2>
            </div>
        </div>
    </main>
    <footer>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-md justify-content-center justify-content-md-start align-items-center">
                <small class="my-2 text-body-secondary">Desingned by <a href="#"
                                                                        class="link-body-emphasis text-decoration-none">@sEGuoer</a>-From
                    2023 to 2033</small>
            </div>
        </nav>
    </footer>
</div>
<script src="vite/build/assets/app.js"></script>
</body>
</html>