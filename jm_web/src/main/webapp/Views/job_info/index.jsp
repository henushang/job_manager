<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页-Job Manager</title>
<meta name="description" content="这是一个 index 页面">
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
</head>
<body>

    <jsp:include page="template/header.jsp" />
	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<jsp:include page="template/sidebar.jsp"/>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">首页</strong> / <small>任务统计</small>
				</div>
			</div>
			<ul
				class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
				<li><a href="#" class="am-text-danger"><span
						class="am-icon-btn am-icon-file-text"></span><br />未完成<br /><span class="unfinish_count">敬请期待</span></a></li>
				<li><a href="#" class="am-text-success"><span
						class="am-icon-btn am-icon-briefcase"></span><br />已完成<br /><span class="finish_count">敬请期待</span></a></li>
				<!-- <li><a href="#" class="am-text-danger"><span
						class="am-icon-btn am-icon-recycle"></span><br />昨日访问<br />80082</a></li>
				<li><a href="#" class="am-text-secondary"><span
						class="am-icon-btn am-icon-user-md"></span><br />在线用户<br />3000</a></li> -->
			</ul>
		</div>
		<!-- content end -->

	</div>
	<jsp:include page="template/footer.jsp" />
	<script>
	$(function() {
	    $.get("${domain_name}/job_info/index_statics", function(result) {
            if (1 == result.status) {
                $(".unfinish_count").html(result.data.unfinishCount);
                $(".finish_count").html(result.data.finishCount);
            }
	    });
    })
	
	</script>
</body>
</html>