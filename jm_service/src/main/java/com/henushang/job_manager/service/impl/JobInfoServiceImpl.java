package com.henushang.job_manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henushang.job_manager.dao.JobInfoDao;
import com.henushang.job_manager.dao.db.MongoQuery.CompareClass;
import com.henushang.job_manager.dao.db.MongoQuery.CompareClass.ECompareType;
import com.henushang.job_manager.dao.db.MongoQuery.SortClass;
import com.henushang.job_manager.domain.Constants;
import com.henushang.job_manager.domain.JobInfo;
import com.henushang.job_manager.domain.MongoConstant;
import com.henushang.job_manager.enums.ESchedule;
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

    public boolean update(JobInfo t) {
        return dao.update(t);
    }

    public List<JobInfo> getList(String userId, int schedule) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("userId", userId);
        queryMap.put("schedule", schedule);
        return dao.getListByQueryMap(queryMap);
    }

    public List<JobInfo> getUnfinishList(String userId) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("userId", userId);
        CompareClass compareClass = new CompareClass();
        compareClass.setField("schedule");
        Map<ECompareType, Object> comparator = new HashMap<ECompareType, Object>();
        comparator.put(ECompareType.LT, ESchedule.RATIO100.getValue());
        compareClass.setComparator(comparator);
        queryMap.put(MongoConstant.COMPARE, compareClass);
        return dao.getListByQueryMap(queryMap);
    }

    public List<JobInfo> getFilterByQuery(Map<String, Object> query) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        for (String key : query.keySet()) {
            if (Constants.ISFINISH.equals(key)) {
                queryMap = addRatioQuery(queryMap, query.get(key).toString());
            }
            queryMap.put(key, query.get(key));
        }
        return dao.getListByQueryMap(queryMap);
    }
    
    private Map<String, Object> addRatioQuery(Map<String, Object> queryMap, String isFinish) {
        if ("0".equals(isFinish)) { // 未完成
            CompareClass compareClass = new CompareClass();
            Map<ECompareType, Object> comparator = new HashMap<ECompareType, Object>();
            comparator.put(ECompareType.LT, ESchedule.RATIO100.getValue());
            compareClass.setComparator(comparator);
            queryMap.put(MongoConstant.COMPARE, compareClass);
        } else if ("1".equals(isFinish)) {
            queryMap.put("schedule", ESchedule.RATIO100.getValue());
        }
        return queryMap;
    }
}
;