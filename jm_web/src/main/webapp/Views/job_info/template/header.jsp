<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<title>任务大师-Tasks Manager</title>
<meta name="description" content="Tasks Master 是一款基于GTD思想的用于任务管理的工具。Getting Things Done! 它可以把手头的工作按照高中低优先级进行排列，并且可以记录进度，这样可以一目了然的对要做的事情做更好地安排。">
<meta name="keywords" content="Tasks Master,GTD，任务大师，任务管理，工作列表，协同工具，工作管理">
<jsp:include page="../../templ/base.jsp" />
<link rel="icon" type="image/png" href="${base_static}/amaze-ui/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="${base_static}/amaze-ui/assets/i/app-icon72x72@2x.png">
<link rel="stylesheet" href="${base_static}/amaze-ui/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${base_static}/amaze-ui/assets/css/admin.css">
<script src="${base_static}/js/common.js" ></script>
	
<header class="am-topbar admin-header">
	<div class="am-topbar-brand">
		<strong>Tasks Master</strong>
	</div>

	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
			<li class="am-dropdown" data-am-dropdown><a
				class="am-dropdown-toggle" data-am-dropdown-toggle
				href="javascript:;"> <span class="am-icon-users"></span> ${cur_user.nickname } <span
					class="am-icon-caret-down"></span>
			</a>
				<ul class="am-dropdown-content">
					<!-- <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
					<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li> -->
					<li><a href="javascript:;;" class="logout"><span class="am-icon-power-off"></span> 退出</a></li>
				</ul></li>
			<li class="am-hide-sm-only"><a href="javascript:;"
				id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span
					class="admin-fullText">开启全屏</span></a></li>
		</ul>
	</div>
	<!-- del result alert -->
        <button style="display:none;" type="button" class="am-btn am-btn-primary logout_btn" data-am-modal="{target: '#my-alert'}">
        </button>
        <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
          <div class="am-modal-dialog">
            <div class="am-modal-hd">Tasks Master</div>
            <div class="am-modal-bd result_content">
              Hello world！
            </div>
            <div class="am-modal-footer">
              <span class="am-modal-btn del_result_confirm_btn" data-result="false">确定</span>
            </div>
          </div>
        </div>
        <script>
	   $(".logout").click(function(){
           $.post("${domain_name}/user/logout", function(result) {
                if (result.status == '1') {
                	window.location = "${domain_name}/user/login"
                }
           });
       });
	   </script>
</header>
