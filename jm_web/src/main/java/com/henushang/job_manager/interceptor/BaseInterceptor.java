package com.henushang.job_manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.henushang.job_manager.common.Constants;
import com.henushang.job_manager.common.WebConf;
import com.henushang.job_manager.domain.User;

public class BaseInterceptor implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        request.setAttribute(Constants.DOMAIN_NAME, WebConf.DOMAIN_NAME);
        request.setAttribute(Constants.BASE_STATIC, WebConf.BASE_STATIC);
        Object object = request.getSession().getAttribute(Constants.CUR_USER);
        User user = object == null ? null : (User) object;
        if (user != null) {
            request.setAttribute("cur_id", user.get_id());
        }
        return true;
    }
    
    
}
