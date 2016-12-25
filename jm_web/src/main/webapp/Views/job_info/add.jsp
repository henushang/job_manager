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
<title>添加工作记录</title>
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
						<strong class="am-text-primary am-text-lg">添加工作</strong> / <small>ADD JOB RECORD</small>
					</div>
				</div>
				<hr>
                <form action="" class="am-form am-form-inline">
					<div class="am-g am-margin-top">
					        <div class="am-u-sm-4 am-u-md-2 am-text-right">任务名称</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <input type="text" name="jobName" id="doc-ipt-email-1" placeholder="填写任务简述">
	                            </div>
	                    </div>
					</div>

					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">开始日期</div>
						<div class="am-u-sm-8 am-u-md-10">
								<div class="am-form-group am-form-icon">
									<i class="am-icon-calendar"></i>
									<input type="date" name="startTime" class="am-form-field am-input-sm startTime" placeholder="开始日期">
								</div>
						</div>
					</div>
				
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">预期完成日期</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <i class="am-icon-calendar"></i>
	                                <input type="date" name="finishTime" class="am-form-field am-input-sm finishTime" placeholder="预期完成日期">
	                            </div>
	                    </div>
	                </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">当前进度</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <select name="schedule" id="schedule">
	                                    <option value="0" selected="selected">0%</option>
					                    <option value="10">10%</option>
					                    <option value="20">20%</option>
					                    <option value="30">30%</option>
					                    <option value="40">40%</option>
					                    <option value="50">50%</option>
					                    <option value="60">60%</option>
					                    <option value="70">70%</option>
					                    <option value="80">80%</option>
					                    <option value="90">90%</option>
					                    <option value="100">100%</option>
					                </select>
	                            </div>
	                    </div>
	                </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">优先级</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <select name="priority" id="priority">
	                                    <option value="1">低</option>
	                                    <option value="5" selected="selected">中</option>
	                                    <option value="10">高</option>
	                                </select>
	                            </div>
	                    </div>
                    </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">备注</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <textarea name="remarks" id="remarks" rows="3" cols="40" id="doc-ta-1"></textarea>
	                            </div>
	                    </div>
	                </div>

				<div class="am-margin">
					<button type="button" class="am-btn am-btn-primary am-btn-xs btn_submit">提交保存</button>
					<button type="button" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
				</div>
				</form>
			</div>
		</div>
	<jsp:include page="template/footer.jsp" />
	<script type="text/javascript">
	   $(".btn_submit").click(function(){
		   var jobName = $("input[name='jobName']").val();
		   var startTime = $("input[name='startTime']").val();
		   var finishTime = $("input[name='finishTime']").val();
		   var schedule = $("#schedule").val();
		   var priority = $("#priority").val();
		   var remarks = $("#remarks").val();
		   console.log(jobName + ":" + startTime + ":" + finishTime + ":" + schedule + ":" + priority + ":" + remarks);
		   $.post("${domain_name}/job_info/add", {
			   "jobName": jobName,
			   "startTime": startTime,
			   "finishTime": finishTime, 
			   "schedule": schedule,
			   "priority": priority,
			   "remarks": remarks }, function(result) {
				   if(result.success == true) {
					   alert("添加成功");
				   } else {
					   alert("添加失败");
				   }
		   });
	   });

	</script>
</body>
</html>