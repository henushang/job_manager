<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!-- sidebar start -->
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="${domain_name}/job_info/index"><span class="am-icon-home"></span> 首页</a></li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-list"></span> 任务列表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="${domain_name}/job_info/job_info_list/${cur_id}?isFinish=0"><span class="am-icon-file-text-o"></span> 未完成</a></li>
            <li><a href="${domain_name}/job_info/job_info_list/${cur_id}?isFinish=1" class="am-cf">
                <span class="am-icon-check"></span> 已完成</a>
            </li>
          </ul>
        </li>
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
