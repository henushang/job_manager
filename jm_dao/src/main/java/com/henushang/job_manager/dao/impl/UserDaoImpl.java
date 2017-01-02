package com.henushang.job_manager.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.henushang.job_manager.dao.UserDao;
import com.henushang.job_manager.dao.db.MongoUtil;
import com.henushang.job_manager.domain.User;
import com.henushang.job_manager.util.UUIDUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private static String collName = "user_info";

    @Override
    public boolean insert(User t) {
        if (StringUtils.isBlank(t.get_id())) {
            t.set_id(UUIDUtil.getId());
        }
        return MongoUtil.insertOne(collName, t);
    }

    @Override
    public User getOne(String _id) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("_id", _id);
        User user = MongoUtil.findOne(collName, queryMap, User.class);
        return user;
    }

    @Override
    public boolean delete(String _id) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("_id", _id);
        return MongoUtil.delete(collName, queryMap);
    }

    @Override
    public List<User> getListByQueryMap(Map<String, Object> queryMap) {
        return MongoUtil.findList(collName, queryMap, User.class);
    }

    public boolean update(User t) {
        // TODO Auto-generated method stub
        return false;
    }

}
