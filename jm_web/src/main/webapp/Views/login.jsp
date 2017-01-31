<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta name="description" content="用户登录页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${base_static}/amaze-ui/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${base_static}/amaze-ui/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${base_static}/amaze-ui/assets/css/admin.css">
<style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<jsp:include page="templ/base.jsp" />
	<div class="header">
  <div class="am-g">
    <h1>Tasks Master</h1>
    <p>任务大师，帮你高效的管理工作任务~</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>登录</h3>
    <hr>

    <form method="post" class="am-form">
      <label for="email">用户名:</label>
      <input type="email" name="email" id="email" value="" placeholder="注册邮箱">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" value="">
      <br>
      <!-- <label for="remember-me">
        <input id="remember-me" type="checkbox">
        记住密码
      </label>
      <br /> -->
      <div class="am-cf">
        <input type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl btn_submit">
        <!-- <input type="button" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr"> -->
        <input type="button" name="" value="新 同 学 注 册" class="am-btn am-btn-default am-btn-sm am-fr register_btn">
      </div>
    </form>
    <hr>
  </div>
</div>
<script src="${base_static }/js/common.js" ></script>
<script type="text/javascript">
  $(function() {
	  
	  $(".register_btn").click(function() {
		  window.location = "${domain_name}/user/register";
	  });
	  
       $(".btn_submit").click(function(){
           var email = $("#email").val();
           var re = isEmail(email);
           if(!re) {
        	   alert("invalid email!");
        	   return;
           }
           var password = $("#password").val();
           $.post("${domain_name}/user/login_post", {"email": email, "password": password}, function(result) {
               if (result.status == 1) {
                   window.location.href="${domain_name}/job_info/index";
               } else {
                   alert(result.msg);
               }
           });
       });
  })
    </script>
</body>
</html>