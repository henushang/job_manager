<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作列表--工作管理</title>
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

		<!-- content start -->
		<div class="admin-content">
            <div class="admin-content-body">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg"> 任务列表</strong>
				</div>
			</div>
			
		    <div class="am-g">
		      <div class="am-u-sm-12">
		        <table class="am-table am-table-bd am-table-striped admin-content-table">
		          <thead>
		          <tr>
		            <th>序号</th>
		            <th>任务名称</th>
		            <th>开始日期</th>
		            <th>预期完成日期</th>
		            <th>当前进度</th>
		            <th>优先级</th>
		            <th>操作</th>
		          </tr>
		          </thead>
		          <tbody>
		          <% int index = 1; %>
		          <c:forEach items="${job_infos}" var="item" varStatus="status"> 
		          <tr>
		            <td><%=index %> <%index ++; %></td>
		            <td>${item.jobName }</td>
		            <td><fmt:formatDate value="${item.startTime }" pattern="yyyy-MM-dd" /></td>
		            <td><fmt:formatDate value="${item.finishTime }" pattern="yyyy-MM-dd" /></td>
		            <td>${item.schedule }%</td>
		            
			            <c:choose>
						   <c:when test="${item.priority==1}"><td>低</td></c:when>
						   <c:when test="${item.priority==5}"><td>中 </td></c:when>
						   <c:when test="${item.priority==10}"><td>高 </td></c:when>
	                    </c:choose>
	                
		            <td>
		              <div class="am-dropdown" data-am-dropdown>
		                <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
		                <ul class="am-dropdown-content" style="min-width:80px;">
		                <li><a href="javascript:;;" class="view_detail" data-id="${item._id }">详情</a></li>
		                  <li><a href="${domain_name}/job_info/edit/${item._id}">编辑</a></li>
		                  <li><a onclick="del('${item._id }')" href="javascript:;">删除</a></li>
		                </ul>
		              </div>
		            </td>
		          </tr>
		          </c:forEach>
		          </tbody>
		        </table>
		      </div>
		    </div>
		    </div>
		    <jsp:include page="template/footer.jsp" />
		</div>
		<!-- content end -->

        <!-- delete confirm -->
		<div class="am-modal am-modal-confirm" tabindex="-1" id="delete-confirm">
		  <div class="am-modal-dialog">
		    <div class="am-modal-hd">Tasks Master</div>
		    <div class="am-modal-bd">
		      你，确定要删除这条记录吗？
		    </div>
		    <div class="am-modal-footer">
		      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
		      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
		    </div>
		  </div>
		</div>
		<!-- del result alert -->
		<button style="display:none;" type="button" class="am-btn am-btn-primary alert_btn" data-am-modal="{target: '#my-alert'}">
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
	</div>
	<!-- 查看详情 -->
	<button type="button" style="display:none;" class="am-btn am-btn-primary view_detail_btn"
	   data-am-modal="{target: '#view_detail_modal', closeViaDimmer: 1, width: 450, height: 320}">
	</button>
	
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="view_detail_modal">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">查看详情
	      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
	    </div>
	    <div class="am-modal-bd">
	        <div class="detail_field">任务名称:<span class="d_job_name"></span></div>
	        <div class="detail_field">开始日期:<span class="d_start_time"></span></div>
	        <div class="detail_field">预期完成日期:<span class="d_finish_time"></span></div>
	        <div class="detail_field">当前进度:<span class="d_schedule"></span></div>
	        <div class="detail_field">优先级:<span class="d_priority"></span></div>
	        <div class="detail_field">备注:<span class="d_remarks"></span></div>
	        <div class="detail_field">创建时间:<span class="d_create_time"></span></div>
	        <div class="detail_field">最后更新时间:<span class="d_update_time"></span></div>
	    </div>
	  </div>
	  <style type="text/css">
        .detail_field {text-align: left; margin-left:15px;}
        .d_job_name {padding-left:5px;}
        .am-modal .am-modal-bd {overflow: auto;}
      </style>
	</div>

    	
	<script type="text/javascript">
	$(function() {
		$(".del_result_confirm_btn").click(function(){
			var re = $(this).data("result");
			if (re == true) {
				window.location.reload();
			}
		});
		
		function getDateStr(timestamp) {
			var newDate = new Date();
			newDate.setTime(timestamp);
			var y = newDate.getFullYear();
			var m = newDate.getMonth()+1;
			var d = newDate.getDate(); 
			return y + "-" + m + "-" + d;
		}
		
		function getDateTimeStr(timestamp) {
            var newDate = new Date();
            newDate.setTime(timestamp);
            var y = newDate.getFullYear();
            var m = newDate.getMonth()+1;
            var d = newDate.getDate();
            var h = newDate.getHours();
            var mm = newDate.getMinutes();
            var s = newDate.getSeconds();
            return y + "-" + m + "-" + d + " " + h + ":" + mm + ":" + s;
        }
		
		$(".view_detail").click(function() {
			job_id = $(this).data("id");
            $.get("${domain_name}/job_info/get/" + job_id, function(result){
                if (result != null) {
                    $(".d_job_name").html(result.jobName);
                    $(".d_start_time").html(getDateStr(result.startTime));
                    $(".d_finish_time").html(getDateStr(result.finishTime));
                    $(".d_schedule").html(result.schedule + "%");
                    $(".d_priority").html(result.priority);
                    $(".d_remarks").html(result.remarks);
                    $(".d_create_time").html(getDateTimeStr(result.createTime));
                    $(".d_update_time").html(getDateTimeStr(result.updateTime));
                }
            });
			$(".view_detail_btn").click();
		});
	});
	function del(id) {
		$('#delete-confirm').modal({
	        relatedTarget: this,
	        onConfirm: function(options) {
	           $.get("${domain_name}/job_info/delete/" + id, function(result){
	        	   if (true == result) {
	        		   $(".result_content").html("删除成功~");
	        		   $(".del_result_confirm_btn").data("result", true);
	        	   } else {
	        		   $(".result_content").html("删除失败~");
	        		   $(".del_result_confirm_btn").data("result", false);
	        	   }
	        	   $(".alert_btn").click();
	           });
	        },
	        // closeOnConfirm: false,
	        onCancel: function() {
	          //alert('算求，不弄了');
	        }
	      });

	}
	</script>
</body>
</html>