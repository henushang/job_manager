package com.henushang.job_manager.service;

import com.henushang.job_manager.domain.User;
import com.henushang.job_manager.service.base.BaseService;

public interface UserService extends BaseService<User> {
	
    User getUser(String email, String password);
    
    User getUser(String email);
    
}
