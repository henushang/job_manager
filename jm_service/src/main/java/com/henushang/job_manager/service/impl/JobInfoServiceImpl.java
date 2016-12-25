package com.henushang.job_manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henushang.job_manager.dao.JobInfoDao;
import com.henushang.job_manager.dao.db.MongoQuery.SortClass;
import com.henushang.job_manager.domain.JobInfo;
import com.henushang.job_manager.domain.MongoConstant;
import com.henushang.job_manager.service.JobInfoService;

@Service("jobInfoService")
public class JobInfoServiceImpl implements JobInfoService {

    @Autowired
    private JobInfoDao dao;

    public List<JobInfo> getList(String userId) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("userId", userId);
        SortClass sortClass = new SortClass();
        sortClass.addSortKey("priority", SortClass.DESC);
        queryMap.put(MongoConstant.SORT, sortClass);
        return dao.getListByQueryMap(queryMap);
    }

    public boolean add(JobInfo t) {
        return dao.insert(t);
    }

    public JobInfo getOne(String id) {
        return dao.getOne(id);
    }

    public boolean delete(String id) {
        return dao.delete(id);
    }
}
