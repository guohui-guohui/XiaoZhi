<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="appname" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <!--在手机网站，都需要加上视口约束！！！-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
    <!--以最新的内核渲染页面-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>登录</title>
    <!--引入css文件-->
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/style.min.css"/>
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/bootstrap-theme.css"/>
    <style type="text/css">


    </style>
    <script src="${appname}/static/js/bootstrap.js" type="text/javascript"></script>
    <script src="${appname}/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="${appname}/static/js/npm.js" type="text/javascript"></script>
    <script type="text/javascript">
        function change1() {
            $("#change").attr("name", "name");
            $("#change").attr("placeholder", "用户名");
        };

        function change2() {
            $("#change").attr("name", "phone");
            $("#change").attr("placeholder", "手机号");
        };

        function change3() {
            $("#change").attr("name", "email");
            $("#change").attr("placeholder", "邮箱");
        };

    </script>
</head>
<body class="container">
<div class="col-md-4 col-md-offset-4">
    <div class="panel" style="width: 300px;">
        <div class="middle-box text-center loginscreen  animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name"><img src="${appname}/img/logo.png"></h1>

                </div>
                <h3>欢迎使用 小知</h3>

                <ol class="breadcrumb">
                    选择登录方式:
                    <li><a href="#" onclick="change1()">用户名</a></li>
                    <li><a href="#" onclick="change2()">手机号</a></li>
                    <li><a href="#" onclick="change3()">邮箱</a></li>
                </ol>


                <form class="" role="form" method="post"  action="${appname}/user/login">

                    <div class="form-group">
                        <input type="text" name="name" id="change" class="form-control" placeholder="用户名"
                               required="">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码" required="">
                    </div>
                    <p id="msg_pwd" style="margin-left: 150px" ><span style="color: orangered">${sessionScope.mesg}</span></p>
                    <c:remove var="mesg" scope="session"></c:remove>
                    <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                    <p class="text-muted text-center"><a href="${appname}/findPassword.jsp">
                        <small>忘记密码了？</small>
                    </a> | <a href="${appname}/register.jsp">注册一个新账号</a>
                    </p>

                </form>
            </div>
        </div>
    </div>
</div>
<!--引入jQuery-->
<script src="${appname}/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<!--引入js文件-->
<script src="${appname}/static/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>