<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册-任务大师</title>
<meta name="description" content="私人助理注册页面">
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
    <h1 style="margin-top:10px;">Tasks Master</h1>
    <p>任务大师，帮你高效的管理工作任务~</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <h3>新同学注册</h3>
    <hr>

    <form method="post" class="am-form">
      <label for="email">邮箱:</label>
      <input type="email" name="email" id="email" value="" placeholder="邮箱用于登录，不区分大小写">
      <br>
      <label for="email">昵称:</label>
      <input type="text" name="username" id="nickname" placeholder="用于网站显示" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" placeholder="请输入登录密码"  value="">
      <br>
      <label for="password">确认密码:</label>
      <input type="password" name="repassword" id="repassword" placeholder="请确认密码"  value="">
      <br>
      <div class="am-cf">
        <input type="button" name="" value="提 交 注 册" class="am-btn am-btn-primary am-btn-sm am-fl btn_submit">
        <input type="button" name="" value="老 同 学 登 录" class="am-btn am-btn-default am-btn-sm am-fl login_btn">
      </div>
    </form>
    <hr>
  </div>
</div>
    <script type="text/javascript">
    $(function(){
       $(".login_btn").click(function() {
    	   window.location = "${domain_name}/user/login/"
       })
       $(".btn_submit").click(function(){
           var email = $("#email").val();
           var nickname = $("#nickname").val();
           var password = $("#password").val();
           var repassword = $("#repassword").val();
           console.log(email + ":" + nickname + ":" + password + ":" + repassword);
           $.post("${domain_name}/user/register", {"email": email, "nickname": nickname, "password": password, "repassword": repassword}, function(result) {
               if (result.status == 1) {
                   alert("亲，恭喜您，注册成功");
                   window.location.href="${domain_name}/user/login";
               } else {
                   alert(result.msg);
               }
           });
       });
    })
    </script>
</body>
</html>