<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas" style="height:100%">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="${domain_name}/job_info/index"><span class="am-icon-home"></span> 首页</a></li>
        <li><a href="${domain_name}/job_info/job_info_list/${cur_id}"><span class="am-icon-list"></span> 工作列表</a></li>
        <li><a href="${domain_name}/job_info/add"><span class="am-icon-plus-square-o"></span> 添加记录</a></li>
      </ul>
        
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd">公告</div>
          <div class="am-panel-bd">
            合理安排时间，就等于节约时间。    --培根
            <br/><br/>
            而我的职责，就是帮你合理安排时间！
          </div>
        </div>
    </div>
  </div>
  <!-- sidebar end -->
