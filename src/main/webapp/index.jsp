
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
    <title>主页</title>
    <!--引入css文件-->
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/bootstrap.css"/>
    <style type="text/css">


    </style>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3>推荐</h3>
    </div>
    <!--问题浏览-->
    <c:forEach items="${sessionScope.recommend}" var="re">
        <div class="panel-body">
            <div class="panel">
                <div class="panel-heading text-danger">
                    <div class="page-header">
                        <h3><a href="${appname}/commen.jsp">${re.question_title}</a><small>精选评论（2）</small></h3>
                    </div>
                </div>
                <!--评论回答-->
                <div class="panel-body">
                    <div class="panel">
                        <div class="panel-body">
                            <p>
                                <img src="${appname}/img/pkq07.jpg" alt="" class="img-circle" width="25px" height="25px">&nbsp;&nbsp;有问必答
                            </p>
                            <p>多读书，多看报，少吃饭多睡觉！</p>
                        </div>
                        <div class="panel-footer" style="background-color: white;">
                            <a href="" style="color:gray;"><span class="glyphicon glyphicon-thumbs-up" ></span>191赞</a>
                            &nbsp;&nbsp;
                            <a href="" style="color:gray;"  ><span class="glyphicon glyphicon-comment"></span>&nbsp;查看回复</a>
                        </div>
                    </div>
                    <div class="panel">
                        <div class="panel-body">
                            <p>
                                <img src="${appname}/img/pkq02.jpg" alt="" class="img-circle" width="25px" height="25px">&nbsp;&nbsp;有问有答
                            </p>
                            <p>回想的过程就是从大脑中提取知识的过程，可以帮助我们记忆更久远、更牢固。当你发现有个知识回想不起来的时候，说明你该去复习它了！~</p>
                        </div>
                        <div class="panel-footer" style="background-color: white;">
                            <a href="" style="color:gray;"><span class="glyphicon glyphicon-thumbs-up" ></span>228赞</a>
                            &nbsp;&nbsp;
                            <a href="" style="color:gray;"  ><span class="glyphicon glyphicon-comment"></span>&nbsp;查看回复</a>
                        </div>
                    </div>

                </div>
                <div class="panel-footer">
                    <a href=""><span class="glyphicon glyphicon-thumbs-up"></span>${re.q_count}赞</a>
                    &nbsp;&nbsp;
                    <a href=""><span class="glyphicon glyphicon-comment"></span>&nbsp;${re.p_num}条评论</a>
                    &nbsp;&nbsp;
                    <a href=""><span class="glyphicon glyphicon-star"></span>&nbsp;收藏</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
