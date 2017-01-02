<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html class="js cssanimations">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑任务</title>
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
						<strong class="am-text-primary am-text-lg">编辑任务</strong> / <small>EDIT TASK</small>
					</div>
				</div>
				<hr>
                <form action="" class="am-form am-form-inline">
					<div class="am-g am-margin-top">
					        <div class="am-u-sm-4 am-u-md-2 am-text-right">任务名称</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <input type="text" name="jobName" value="${job_info.jobName}" id="doc-ipt-email-1" placeholder="填写任务简述">
	                            </div>
	                    </div>
					</div>

					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">开始日期</div>
						<div class="am-u-sm-8 am-u-md-10">
								<div class="am-form-group am-form-icon">
									<i class="am-icon-calendar"></i>
									<input type="date" name="startTime" value="<fmt:formatDate value='${job_info.startTime }' pattern='yyyy-MM-dd' />" class="am-form-field am-input-sm startTime" placeholder="开始日期">
								</div>
						</div>
					</div>
				
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">预期完成日期</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <i class="am-icon-calendar"></i>
	                                <input type="date" name="finishTime" value="<fmt:formatDate value='${job_info.finishTime }' pattern='yyyy-MM-dd' />" class="am-form-field am-input-sm finishTime" placeholder="预期完成日期">
	                            </div>
	                    </div>
	                </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">当前进度</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <select name="schedule" id="schedule">
	                                    <option value="0" ${job_info.schedule == '0' ? 'selected' : '' }>0%</option>
					                    <option value="10" ${job_info.schedule == '10' ? 'selected' : '' }>10%</option>
					                    <option value="20" ${job_info.schedule == '20' ? 'selected' : '' }>20%</option>
					                    <option value="30" ${job_info.schedule == '30' ? 'selected' : '' }>30%</option>
					                    <option value="40" ${job_info.schedule == '40' ? 'selected' : '' }>40%</option>
					                    <option value="50" ${job_info.schedule == '50' ? 'selected' : '' }>50%</option>
					                    <option value="60" ${job_info.schedule == '60' ? 'selected' : '' }>60%</option>
					                    <option value="70" ${job_info.schedule == '70' ? 'selected' : '' }>70%</option>
					                    <option value="80" ${job_info.schedule == '80' ? 'selected' : '' }>80%</option>
					                    <option value="90" ${job_info.schedule == '80' ? 'selected' : '' }>90%</option>
					                    <option value="100" ${job_info.schedule == '100' ? 'selected' : '' }>100%</option>
					                </select>
	                            </div>
	                    </div>
	                </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">优先级</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <select name="priority" id="priority">
	                                    <option value="1" ${job_info.priority == '1' ? 'selected' : '' }>低</option>
	                                    <option value="5" ${job_info.priority == '5' ? 'selected' : '' }>中</option>
	                                    <option value="10" ${job_info.priority == '10' ? 'selected' : '' }>高</option>
	                                </select>
	                            </div>
	                    </div>
                    </div>
	                <div class="am-g am-margin-top">
	                    <div class="am-u-sm-4 am-u-md-2 am-text-right">备注</div>
	                    <div class="am-u-sm-8 am-u-md-10">
	                            <div class="am-form-group am-form-icon">
	                                <textarea name="remarks"  id="remarks" rows="3" cols="40" id="doc-ta-1">${job_info.remarks }</textarea>
	                            </div>
	                    </div>
	                </div>
	                <div id="_id" data-_id="${job_info._id }"></div>
                    <div id="create_time" data-time="<fmt:formatDate value='${job_info.createTime }' pattern='yyyy-MM-dd HH:mm:ss' />"></div>
				<div class="am-margin">
					<button type="button" class="am-btn am-btn-primary am-btn-xs btn_submit">提交保存</button>
				</div>
				</form>
			</div>
			     <!-- del result alert -->
        <button style="display:none;" type="button" class="am-btn am-btn-primary edit_alert_btn" data-am-modal="{target: '#edit-alert'}">
        </button>
        <div class="am-modal am-modal-alert" tabindex="-1" id="edit-alert">
          <div class="am-modal-dialog">
            <div class="am-modal-hd">Tasks Master</div>
            <div class="am-modal-bd edit_result_content">
              Hello world！
            </div>
            <div class="am-modal-footer">
              <span class="am-modal-btn edit_result_confirm_btn" data-result="false">确定</span>
            </div>
          </div>
        </div>
		</div>
	<jsp:include page="template/footer.jsp" />
	<script type="text/javascript">
	$(function() {
	    $(".edit_result_confirm_btn").click(function(){
	        var re = $(this).data("result");
	        if (re == true) {
	            window.location = "${domain_name}/job_info/job_info_list/${cur_id}";
	        }
	    });
	   $(".btn_submit").click(function(){
		   var jobName = $("input[name='jobName']").val();
		   var startTime = $("input[name='startTime']").val();
		   var finishTime = $("input[name='finishTime']").val();
		   var createTime= $("#create_time").data("time");
		   var schedule = $("#schedule").val();
		   var priority = $("#priority").val();
		   var remarks = $("#remarks").val();
		   var _id= $("#_id").data("_id");
		   $.post("${domain_name}/job_info/edit", {
			   "_id": _id,
			   "jobName": jobName,
			   "startTime": startTime,
			   "finishTime": finishTime, 
			   "createTime": createTime,
			   "schedule": schedule,
			   "priority": priority,
			   "remarks": remarks }, function(result) {
				   if (true == result) {
                       $(".edit_result_content").html("修改成功~");
                       $(".edit_result_confirm_btn").data("result", true);
                   } else {
                       $(".result_content").html("修改失败，请重试或者刷新再试~");
                       $(".edit_result_confirm_btn").data("result", false);
                   }
                   $(".edit_alert_btn").click();
		   });
	   });
	})
	</script>
</body>
</html>