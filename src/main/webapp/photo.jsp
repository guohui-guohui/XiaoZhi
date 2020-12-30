<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.* , com.baizhi.entity.* " isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="appname" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>头像圆形化处理</title>
	<link rel="stylesheet" href="">
	<style type="text/css" media="screen">
			#d1{
				width: 100px;
				height: 100px;
				border: 1px solid blue;
				border-radius: 100%;
				overflow: hidden;
			}
			img {
				max-height: 100%;
			}
	</style>
</head>
<body>
	点击更换头像<div id="d1">
		<img src="http://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/48540923dd54564e2d86086eb8de9c82d0584f82.jpg" alt="">
	</div>
</body>
</html>