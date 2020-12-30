<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.* , com.baizhi.entity.* " isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="appname" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <!--在手机网站，都需要加上视口约束！！！-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
    <!--以最新的内核渲染页面-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>回答问题</title>
    <!--引入css文件-->
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/bootstrap.css"/>
    <style type="text/css">


    </style>
    <script type="text/javascript">

        function tiwen() {

            $("#test").attr("name", "question_title");
            var s = $("#test").val();
            $("#test").attr("placeholder", "提问");
            window.location.href="${appname}/question/add?question_title="+s+"&user_id="+${sessionScope.user.id};
        };

        function att(qid,uid){

            $.ajax({
                url:"${appname}/question/att",
                type:"post",
                data:{  "question_id":qid,
                        "user_id":uid
                    },
                dataType:"json",
                success:function(data){

                            $("#butn").attr("disabled", true);
                            $("#butn").html("已关注");

                },
                error:function () {
                    alert(qid);
                }

            });

        }

        function thumbs_up(id,count){

            $.ajax({
                url:"${appname}/question/upcount",
                type:"post",
                data:{  "id":id,
                    "q_count":count
                },
                dataType:"json",
                success:function(data){
                    $("#thsup1").html(data.q_count+"赞");
                },
                error:function () {
                    alert("失败");
                }

            });

        }
        function star(uid,qid){
            $.ajax({
                url:"${appname}/question/star",
                type:"post",
                data:{  "user_id":uid,
                    "question_id":qid
                },
                dataType:"json",
                success:function(data){
                    $("#star1").html("已收藏");
                },
                error:function () {
                    alert("失败");
                }

            });
        }


        function pin(id,count){

            $.ajax({
                url:"${appname}/comment/ccount",
                type:"post",
                data:{  "id":id,
                    "c_count":count
                },
                dataType:"json",
                success:function(data){
                    $("#tpin").html(data.c_count+"赞");
                },
                error:function () {
                    alert("失败");
                }

            });

        }
        function Exct() {
            var mrsg = confirm("确定要退出登录吗？")
            if(mrsg == true){
                window.location.href="${appname}/user/Exct"
            }
        }
    </script>
</head>
<body>
<div class="container">
    <!--顶部导航-->
    <div class="navbar navbar-default " id="navbar-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="" class="navbar-brand"><span class="glyphicon glyphicon-th-large"></span></a>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-1">
                    <span class="caret"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse" id="menu-1">

                <ul class="nav navbar-nav">
                    <li><a href="">关于小知</a></li>
                    <li><a href="${appname}/question/all">首页</a></li>
                    <li><a href="">等你来答</a></li>
                </ul>
                <form class="navbar-form navbar-left" role="search" method="post" action="${appname}/question/query">
                    <div class="form-group">
                        <input type="text" id="test" name="question_title" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>

                </form>
                <button type="button" class="navbar-btn btn btn-primary" onclick="tiwen()">提问</button>
                <div class="navbar-btn navbar-right" style="background-color: transparent">
                    <button type="button" class="btn btn-primary btn-sm" style="text-shadow: black 5px 3px 3px;" onclick="Exct()";>

                        <span class="glyphicon glyphicon-user"></span> ${sessionScope.user.name}
                    </button>&nbsp;<img src="${appname}/upload/${sessionScope.user.photo}" class="img-circle" alt="" width="30px" height="30px"></a></li>
                </div>
            </div>
        </div>
    </div>
    <!--左侧-->
    <c:forEach var="q" items="${sessionScope.query}">
    <div class="col-md-10">

        <div class="panel">
            <div class="panel-heading text-danger">
                <h3>${q.question_title}</h3>
                <%--<c:if test="${sessionScope.lst.status == 1}">
                    <button type="button" id="butn" disabled="disabled" class="btn btn-primary" onclick="att('${q.id}','${sessionScope.user.id}')">关注问题</button>
                </c:if>
                <c:if test="${sessionScope.lst.status != 1}">--%>
                <button type="button" id="butn" class="btn btn-primary" onclick="att('${q.id}','${sessionScope.user.id}')">关注问题</button>
                <%--</c:if>--%>
                <div class="page-header">
                    ${q.p_num}条评论
                </div>
            </div>
            <div class="panel-body">
                <c:forEach var="c" items="${sessionScope.common}">

                <div class="panel">
                    <div class="panel-body">
                        <%--<p>
                            <img src="${appname}/upload/${sessionScope.u.photo}" alt="" class="img-circle" width="25px" height="25px">&nbsp;&nbsp;${sessionScope.u.name}
                        </p>--%>
                        <p>${c.common_describe}</p>
                    </div>
                    <div class="panel-footer" style="background-color: white;">
                        <a id="tpin" onclick="pin('${c.id}','${c.c_count}')" style="color:gray;"><span class="glyphicon glyphicon-thumbs-up" ></span>${c.c_count}赞</a>
                        &nbsp;&nbsp;
                        <a style="color:gray;"  data-toggle="collapse" data-parent="#accordion" href="#collapse"><span class="glyphicon glyphicon-comment"></span>&nbsp;查看回复</a>
                    </div>
                        <%--回复评论--%>
                    <div id="collapse" class="panel-collapse collapse">
                        <div class="panel-body">
                            <div class="panel-body">

                                <p>
                                    <img src="${appname}/img/pkq07.jpg" alt="" class="img-circle" width="25px" height="25px">&nbsp;&nbsp;有问必答
                                </p>
                                <p>多读书，多看报，少吃饭多睡觉！</p>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <div class="panel-footer">
                <a onclick="thumbs_up('${q.id}','${q.q_count}')" ><span class="glyphicon glyphicon-thumbs-up" ></span><span id="thsup1">${q.q_count}赞</span></a>
                &nbsp;&nbsp;
                <a onclick="star('${sessionScope.user.id}','${q.id}')" id="star1"><span class="glyphicon glyphicon-star"></span>&nbsp;收藏</a>
            </div>
        </div>

        <!--回答区-->
        <div class="panel">
            <!---写回答------>
            <a name="comment"></a>
            <form role="form" method="post" action="${appname}/comment/addComm?user_id=${sessionScope.user.id}&question_id=${q.id}">
                <div class="form-group">
                    <label for="name">写回答</label>
                    <input type="text" id="name" class="form-control" placeholder="写下您的回答....">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">提交回答</button>
            </form>
        </div>
    </div>
    </c:forEach>
    <!--右侧-->
    <div class="col-md-2">
        <ul class="list-group">
            <li class="list-group-item">写回答</li>
            <li class="list-group-item">我的草稿</li>
            <li class="list-group-item">我的收藏(${sessionScope.lon})</li>
            <li class="list-group-item">我关注的问题(${sessionScope.attent})</li>
            <li class="list-group-item">我的邀请</li>
        </ul>
    </div>
</div>


<!--引入jQuery-->
<script src="${appname}/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<!--引入js文件-->
<script src="${appname}/static/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>