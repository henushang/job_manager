<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html class="js cssanimations">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加记录-Birth Alert</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<body>
	<jsp:include page="template/header.jsp" />

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<jsp:include page="template/sidebar.jsp" />
		<!-- sidebar end -->
		<div class="admin-content am-form">
			<div class="admin-content-body">
				<div class="am-cf am-padding am-padding-bottom-0">
					<div class="am-fl am-cf">
						<strong class="am-text-primary am-text-lg">表单</strong> / <small>form</small>
					</div>
				</div>
				<hr>
				<div class="am-g am-margin-top">
				        <div class="am-u-sm-4 am-u-md-2 am-text-right">姓名</div>
                    <div class="am-u-sm-8 am-u-md-10">
                        <form action="" class="am-form am-form-inline">
                            <div class="am-form-group am-form-icon">
                                <input type="text" class="name" id="doc-ipt-email-1" placeholder="姓名">
                            </div>
                        </form>
                    </div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">性别</div>
					<div class="am-u-sm-8 am-u-md-10">
						<div class="am-btn-group" data-am-button="">
							<label class="am-btn am-btn-default am-btn-xs">
							     <input type="radio" name="gender" value="0" id="option1"> Boy
							</label>
							<label class="am-btn am-btn-default am-btn-xs">
							     <input type="radio" name="gender" value="1" id="option2"> Girl
							</label> 
						</div>
					</div>
				</div>

				<div class="am-g am-margin-top">
					<div class="am-u-sm-4 am-u-md-2 am-text-right">生日</div>
					<div class="am-u-sm-8 am-u-md-10">
						<form action="" class="am-form am-form-inline">
							<div class="am-form-group am-form-icon">
								<i class="am-icon-calendar"></i>
								<input type="date" class="am-form-field am-input-sm birth" placeholder="日期">
							</div>
						</form>
					</div>
				</div>
				
				<div class="am-g am-margin-top">
                    <div class="am-u-sm-4 am-u-md-2 am-text-right">日期类别</div>
                    <div class="am-u-sm-8 am-u-md-10">
                        <div class="am-btn-group" data-am-button="">
                            <label class="am-btn am-btn-default am-btn-xs">
                                 <input type="radio" name="isSolar" value="1" id="option1"> 阳历
                            </label>
                            <label class="am-btn am-btn-default am-btn-xs">
                                 <input type="radio" name="isSolar" value="0" id="option2"> 农历
                            </label> 
                        </div>
                    </div>
                </div>
				
                <div class="am-g am-margin-top">
                        <div class="am-u-sm-4 am-u-md-2 am-text-right">邮箱</div>
                    <div class="am-u-sm-8 am-u-md-10">
                        <form action="" class="am-form am-form-inline">
                            <div class="am-form-group am-form-icon">
                                <input type="email" class="email" id="doc-ipt-email-1" placeholder="生日人邮箱">
                            </div>
                        </form>
                    </div>
                </div>
			<div class="am-margin">
				<button type="button" class="am-btn am-btn-primary am-btn-xs btn_submit">提交保存</button>
				<button type="button" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
			</div>
			</div>
		</div>
	<jsp:include page="template/footer.jsp" />
	<script type="text/javascript">
	   $(".btn_submit").click(function(){
		   var name = $(".name").val();
		   var gender = $("input[name='gender']:checked").val();
		   var birth = $(".birth").val();
		   var isSolar = $(".isSolar").val();
		   var email = $(".email").val();
		   console.log(name + ":" + gender + ":" + birth + ":" + email);
		   $.post("${domain_name}/birth_alert/add", { name: name, gender: gender, birthday: birth, isSolar: isSolar, toEmail: email}, function(result) {
			   alert(result.success);
		   });
	   });

	</script>
</body>
</html>