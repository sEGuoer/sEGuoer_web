<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/9/12
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../vite/build/assets/app.css">
    <link rel="stylesheet" href="../build/assets/app.css"/>
    <link href="../vendor/vditor/dist/index.css" rel="stylesheet">
    <link rel="stylesheet" href="../vendor/tocbot/dist/tocbot.css">
    <style>
        body {
            overflow-x: hidden;
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
    </style>
</head>
<body>
<div class="container"></div>
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" >
        <div class="container-fluid">
            <h1 class="d-flex align-items-center ">
                <img src="../img/Cache_247709949bd616a9..jpg" width="36" height="36" alt="MyPhoto">
                <a class="link-underline link-underline-opacity-0 link-body-emphasis fs-6" href="./index.html">我的主页</a>
            </h1>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ms-auto">
                    <a class="nav-link active" aria-current="page" href="#resume"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-person" viewBox="0 0 16 16">
                        <path d="M11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2v9.255S12 12 8 12s-5 1.755-5 1.755V2a1 1 0 0 1 1-1h5.5v2z"/>
                    </svg>简历</a>
                    <a class="nav-link" href="#boke"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-book-half" viewBox="0 0 16 16">
                        <path d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                    </svg>博客</a>
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
<section class="single-post container" id="main_content">
    <div class="row">
        <div class="col-lg-8">
            <h1 class="title">maven 加速，修改镜像源</h1>
            <p class="meta text-muted">
                <a href="#">admin</a>
                <span> - </span>
                2023-06-11 14:59:23.0
            </p>
            <div id="vditor-preview-element" class="markdown-body js-toc-content animate__animated animate__fadeInLeft vditor-reset"><h3 id="为什么慢">为什么慢</h3>
                <p>执行 mvn 各种命令的时候，默认是去 maven 官方镜像源获取需要安装的具体软件信息</p>
                <p>默认源地址在国外，从国内访问的速度肯定比较慢</p>
                <h3 id="如何修改镜像源">如何修改镜像源</h3>
                <p>阿里巴巴维护着一个国内 maven 镜像源</p>
                <h4 id="a---配置只在当前项目生效">a). 配置只在当前项目生效</h4>
                <p>在 pom.xml 文件内添加以下配置</p>
                <pre><div class="vditor-copy"><textarea></textarea><span aria-label="复制" onmouseover="this.setAttribute('aria-label', '复制')" class="vditor-tooltipped vditor-tooltipped__w" onclick="this.previousElementSibling.select();document.execCommand('copy');this.setAttribute('aria-label', '已复制')"><svg><use xlink:href="#vditor-icon-copy"></use></svg></span></div><code class="language-xml hljs" style="max-height: 921px;"><span class="hljs-tag">&lt;<span class="hljs-name">repositories</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">repository</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">id</span>&gt;</span>ali-maven<span class="hljs-tag">&lt;/<span class="hljs-name">id</span>&gt;</span>
        <span class="hljs-tag">&lt;<span class="hljs-name">url</span>&gt;</span>http://maven.aliyun.com/nexus/content/groups/public<span class="hljs-tag">&lt;/<span class="hljs-name">url</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-name">repository</span>&gt;</span>
<span class="hljs-tag">&lt;/<span class="hljs-name">repositories</span>&gt;</span>
</code></pre>
                <h4 id="b---配置全局生效">b). 配置全局生效</h4>
                <p>修改 settings.xml 文件</p>
                <p>找到 <mirrors> 标签，在里面加入以下内容</mirrors></p>
                <pre><div class="vditor-copy"><textarea></textarea><span aria-label="复制" onmouseover="this.setAttribute('aria-label', '复制')" class="vditor-tooltipped vditor-tooltipped__w" onclick="this.previousElementSibling.select();document.execCommand('copy');this.setAttribute('aria-label', '已复制')"><svg><use xlink:href="#vditor-icon-copy"></use></svg></span></div><code class="language-xml hljs" style="max-height: 921px;"><span class="hljs-tag">&lt;<span class="hljs-name">mirror</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">id</span>&gt;</span>alimaven<span class="hljs-tag">&lt;/<span class="hljs-name">id</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">name</span>&gt;</span>aliyun maven<span class="hljs-tag">&lt;/<span class="hljs-name">name</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">url</span>&gt;</span>http://maven.aliyun.com/nexus/content/groups/public/<span class="hljs-tag">&lt;/<span class="hljs-name">url</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-name">mirrorOf</span>&gt;</span>central<span class="hljs-tag">&lt;/<span class="hljs-name">mirrorOf</span>&gt;</span>
<span class="hljs-tag">&lt;/<span class="hljs-name">mirror</span>&gt;</span>
</code></pre>
                <p>可以在以下路径查找到 settings.xml 文件</p>
                <ol>
                    <li>
                        <p>(用户家目录)/.m2/settings.xml</p>
                    </li>
                    <li>
                        <p>(maven安装目录)/conf/settings.xml，</p>
                        <p>如果是 Mac 系统通过 brew 命令安装的，在这里：</p>
                        <p>/usr/local/Cellar/maven/(版本号)/libexec/conf/settings.xml</p>
                    </li>
                </ol>
            </div>
        </div>

        <div class="col-lg-3 offset-lg-1">
            <div id="outline" class="js-toc toc sticky-top d-none d-lg-block animate__animated animate__fadeInRight animate__delay-1s"></div>
        </div>
    </div>
</section>
<footer>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-md justify-content-center justify-content-md-start align-items-center">
            <small class="my-2 text-body-secondary">Desingned by <a href="#"
                                                                    class="link-body-emphasis text-decoration-none">@sEGuoer</a>-From
                2023 to 2033</small>
        </div>
    </nav>
</footer>
<script src="../build/assets/app.js"></script>
<script src="../vendor/tocbot/dist/tocbot.js"></script>
<script>
    $(function() {
        tocbot.init({
            // Where to render the table of contents.
            tocSelector: '.js-toc',
            // Where to grab the headings to build the table of contents.
            contentSelector: '.js-toc-content',
            // Which headings to grab inside of the contentSelector element.
            headingSelector: 'h1, h2, h3, h4, h5, h6',
            // For headings inside relative or absolute positioned containers within content.
            hasInnerContainers: false,
            collapseDepth: 6,
        });
        $(".js-toc a.toc-link").mouseover(function () {
            $(this).attr('title', $(this).text());
        });
        $('.js-toc a.toc-link').on('click', function(e){
            //store hash
            const href = $(this).attr("href");
            const hash = href.substr(href.indexOf("#"));
            // animate
            $(hash).animateCss('slow');
            $(hash).animateCss('flash');
        });
    });
</script>
</body>
</html>
