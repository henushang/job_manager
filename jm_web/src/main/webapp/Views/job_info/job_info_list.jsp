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

			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">工作任务列表</strong>
				</div>
			</div>
			
		    <div class="am-g">
		      <div class="am-u-sm-12">
		        <table class="am-table am-table-bd am-table-striped admin-content-table">
		          <thead>
		          <tr>
		            <th>序号</th>
		            <th>任务名</th>
		            <th>开始日期</th>
		            <th>预期完成日期</th>
		            <th>当前进度</th>
		            <th>优先级</th>
		            <th>管理</th>
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
		              <div class="am-dropdown" data-am-dropdown style="z-index:99">
		                <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
		                <ul class="am-dropdown-content">
		                  <li><a href="${domain_name}/birth_alert/edit/${item._id}">编辑</a></li>
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
		<!-- content end -->

	</div>
	<script type="text/javascript">
			function del(id) {
			    $.get("${domain_name}/birth_alert/delete/" + id, function(result){
			    	window.location.reload();
			    });
			}
	</script>
	<jsp:include page="template/footer.jsp" />
</body>
</html>