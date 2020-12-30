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
    <title>注册</title>
    <!--引入css文件-->
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${appname}/static/css/style.min.css"/>
    <style type="text/css">
         #upload-tip{
            border: 1px dashed #d9d9d9;
            width: 135px;
            height: 135px;
            line-height: 135px;
            cursor: pointer;
            font-size: 36px;
            color:#d9d9d9;
        }
        #img-show{
            width: 135px;
            height: 135px;
            display: block;
            margin: 0 auto;
            object-fit: cover;
        }
        label{
            display: block;
            padding-bottom:12px;
        }
        .label-text{
            width: 36%;
            float: left;
        }

    </style>
</head>
<body class="container">
<div class="col-md-4 col-md-offset-4">
    <div class="panel" style="width: 300px;">
        <div class="middle-box text-center loginscreen  animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name"><img src="${appname}/img/register.png"></h1>

                </div>
                <h3>注册</h3>

                <form class="" role="form" method="post" action="${appname}/user/register" enctype="multipart/form-data">
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" placeholder="用户名" required="required">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="phone" placeholder="手机号" required="required">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" name="email" placeholder="邮箱" required="required">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" required="required" placeholder="请输入密码" id="ipwd" onblur="nk()">
                        <script type="text/javascript">
                             function nk(){
                            //判断昵称长度
                            if(ipwd.value.length<6 || ipwd.value.length>16){
                                alert("密码长度不符合要求");
                                ipwd.value="";
                                
                            }
                        }

                       
                        </script>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="再次输入密码"  required="required" id="i2pwd">
                    </div>

                    
                     <label>
                    <div class="label-text">头像图片：</div>
                    <div style="text-align: center;padding-left: 36%">
                        <div id="upload-tip">+</div>
                        <img src="${appname}/upload" alt="" id="img-show" style="display: none">
                        <input type="file" name="file" id="imgfile" style="display: none" onchange="imgfileChange()">
                    </div>
                </label>

                    <p id="msg_pwd" style="margin-left: 150px" ><span style="color: orangered">${sessionScope.mesg}</span></p>
                    <c:remove var="mesg" scope="session"></c:remove>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            已有账号？点击<a href="${appname}/login.jsp">登录！</a>
                            <button type="submit" class="btn btn-success"  style="float: right" id="btn_register">注册</button>
                        </div>
                     </div>

                </form>
            </div>
        </div>
    </div>
</div>
<!--引入jQuery-->
<script src="${appname}/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<!--引入js文件-->
<script src="${appname}/static/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
 function imgfileChange() {
                            var upload_tip = document.getElementById("upload-tip");
                            var img_show = document.getElementById("img-show");
                            var imgfile = document.getElementById("imgfile");

                            var freader = new FileReader();
                            freader.readAsDataURL(imgfile.files[0]);
                            freader.onload = function (e) {
                                img_show.src = e.target.result;
                                img_show.style.display = "inline";
                                upload_tip.style.display = "none";
                            };
                        }

$(document).ready(function(){

   /* $('#ipwd').focus(function(){
         var pwd = $.trim($(this).val());
         //判断密码长度
         if(pwd.length < 6 || pwd.length > 16){
            $("#msg_pwd").html("<font color='green'>密码长度不符</font>");
            $("#btn_register").attr("disabled",false);
         }
    $('#ipwd').css("background-color","#FFFFCC");
  });
  $('#ipwd').blur(function(){
    $("ipwd").val("");
    $('#ipwd').css("background-color","#D6D6FF");
  });*/


    $('#ipwd').on('input propertychange', function() {                                
                               //input propertychange即实时监控键盘输入包括粘贴
        var pwd = $.trim($(this).val());                                          
                               //获取this，即ipwd的val()值，trim函数的作用是去除空格
        var rpwd = $.trim($("#i2pwd").val());
       

                if(rpwd!=""){

                if(pwd==""&&rpwd==""){                 
                        //若都为空，则提示密码不能为空，为了用户体验（在界面上用required同时做了处理）
                    $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
                }
                else{
                    if(pwd==rpwd){                                 //相同则提示密码匹配
                    $("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
                    $("#btn_register").attr("disabled",false); //使按钮无法点击
                    }else{                                          //不相同则提示密码匹配
                    $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                    $("#btn_register").attr("disabled",true);
                }
                }
            }


    })
})
 
//由于是两个输入框，所以进行两个输入框的几乎相同的判断
$(document).ready(function(){
        $('#i2pwd').on('input propertychange', function() {
            var pwd = $.trim($(this).val());
            var rpwd = $.trim($("#ipwd").val());
            if(pwd==""&&rpwd==""){
                $("#msg_pwd").html("<font color='red'>密码不能为空</font>");
            }
            else{
                if(pwd==rpwd){
                $("#msg_pwd").html("<font color='green'>两次密码匹配通过</font>");
                $("#btn_register").attr("disabled",false);
                }else{
                $("#msg_pwd").html("<font color='red'>两次密码不匹配</font>");
                $("#btn_register").attr("disabled",true);
            }
            }
        })
    })

                           
</script>

</body>
</html>