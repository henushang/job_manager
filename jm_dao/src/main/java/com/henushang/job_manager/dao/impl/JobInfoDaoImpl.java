package com.henushang.job_manager.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.henushang.job_manager.dao.JobInfoDao;
import com.henushang.job_manager.domain.JobInfo;
import org.springframework.stereotype.Repository;

import com.henushang.job_manager.dao.db.MongoUtil;

@Repository("jobInfoDao")
public class JobInfoDaoImpl implements JobInfoDao {

    private static String collName = "job_info";

    public boolean insert(JobInfo t) {
        return MongoUtil.insertOne(collName, t);
    }

    public JobInfo getOne(String _id) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("_id", _id);
        JobInfo info = MongoUtil.findOne(collName, queryMap, JobInfo.class);
        return info;
    }

    public boolean delete(String _id) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("_id", _id);
        return MongoUtil.delete(collName, queryMap);
    }

    public boolean delete(String collName, Map<String, Object> query) {
        return MongoUtil.delete(collName, query);
    }

    public List<JobInfo> getListByQueryMap(Map<String, Object> queryMap) {
        return MongoUtil.findList(collName, queryMap, JobInfo.class);
    }

    public boolean update(JobInfo t) {
        Map<String, Object> whereMap = new HashMap<String, Object>();
        whereMap.put("_id", t.get_id());
        return MongoUtil.upsert(collName, whereMap, t);
    }

}
