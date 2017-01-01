package com.henushang.job_manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.henushang.job_manager.common.Constants;
import com.henushang.job_manager.domain.ResponseCode;
import com.henushang.job_manager.domain.ResponseVO;
import com.henushang.job_manager.domain.User;

public abstract class BaseController {
    
    protected final String PAGE_404 = "404";
    protected final String PREFIX_JOB_INFO = "job_info/";
    
    protected User getCurUser(HttpServletRequest request) {
        Object object = request.getSession().getAttribute(Constants.CUR_USER);
        return object == null ? null : (User) object;
    }
    
    protected String getCurUserId(HttpServletRequest request) {
        User user = getCurUser(request);
        if (user == null) {
            return null;
        }
        return user.get_id();
    }
    
    protected boolean addUser2Session(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute(Constants.CUR_USER, user);
        return true;
    }
    
    protected boolean removeUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.CUR_USER);
        return true;
    }
    
    protected ResponseVO errorVO(String msg) {
        ResponseVO vo = new ResponseVO();
        vo.setStatus(ResponseCode.ERROR);
        vo.setMsg(msg);
        return vo;
    }
    
    protected ResponseVO successVO() {
        ResponseVO vo = new ResponseVO();
        vo.setStatus(ResponseCode.SUCCESS);
        return vo;
    }
}
