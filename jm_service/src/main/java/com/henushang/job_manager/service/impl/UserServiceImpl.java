package com.henushang.job_manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henushang.job_manager.dao.UserDao;
import com.henushang.job_manager.domain.User;
import com.henushang.job_manager.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public boolean add(User t) {
        t.setEmail(t.getEmail().toLowerCase());
        return dao.insert(t);
    }

    @Override
    public boolean delete(String id) {
        return dao.delete(id);
    }

    @Override
    public User getOne(String id) {
        return dao.getOne(id);
    }

    @Override
    public User getUser(String email, String password) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("email", email.toLowerCase());
        queryMap.put("password", password);
        List<User> list = dao.getListByQueryMap(queryMap);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public User getUser(String email) {
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("email", email.toLowerCase());
        List<User> list = dao.getListByQueryMap(queryMap);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean update(User t) {
        // TODO Auto-generated method stub
        return false;
    }
    

}
