package com.henushang.job_manager.service;

import com.henushang.job_manager.service.base.BaseService;

import java.util.List;
import java.util.Map;

import com.henushang.job_manager.domain.JobInfo;
public interface JobInfoService extends BaseService<JobInfo> {
    
    List<JobInfo> getList(String userId);
    
    List<JobInfo> getList(String userId, int schedule);
    
    List<JobInfo> getUnfinishList(String userId);
    
    List<JobInfo> getListByQuery(Map<String, Object> query);
}
