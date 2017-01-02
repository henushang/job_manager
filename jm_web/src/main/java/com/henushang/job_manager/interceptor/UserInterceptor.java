package com.henushang.job_manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henushang.job_manager.common.Constants;
import com.henushang.job_manager.common.WebConf;
import com.henushang.job_manager.domain.User;

public class UserInterceptor extends BaseInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        Object object = request.getSession().getAttribute(Constants.CUR_USER);
        User user = object == null ? null : (User) object;
        if (user == null) {
            response.sendRedirect(WebConf.DOMAIN_NAME + "/user/login");
        }
        return true;
    }
}
