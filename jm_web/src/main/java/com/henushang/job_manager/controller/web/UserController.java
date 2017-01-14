package com.henushang.job_manager.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henushang.job_manager.controller.BaseController;
import com.henushang.job_manager.domain.ResponseVO;
import com.henushang.job_manager.domain.User;
import com.henushang.job_manager.service.UserService;
import com.henushang.job_manager.util.PwdUtil;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    
    @RequestMapping(value={"/login"})
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="/login_post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO login(String email, String password, HttpServletRequest request) {
        String enPwd = PwdUtil.getPwd(password);
        if (!checkLoginParams(email, enPwd)) {
            return errorVO("邮箱或密码错误");
        }
        User user = userService.getUser(email, enPwd);
        if (user == null) {
            return errorVO("邮箱或密码不正确");
        }
        if (!addUser2Session(request, user)) {
            return errorVO("系统异常，请刷新再试");
        }
        return successVO();
    }
    
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseVO logout(HttpServletRequest request) {
        boolean result = removeUserFromSession(request);
        if (result) {
            return successVO();
        } else {
            return errorVO("登出失败，请刷新再试~");
        }
    }
    
    private boolean checkLoginParams(String email, String pwd) {
        boolean isValid = true;
        if (StringUtils.isBlank(email) || StringUtils.isBlank(pwd)) {
            isValid = false;
        }
        return isValid;
    }
    
    @RequestMapping(value={"/register"}, method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    
    @ResponseBody
    @RequestMapping(value={"/register"}, method = RequestMethod.POST)
    public ResponseVO register(User user, String repassword) {
        if (userService.getUser(user.getEmail()) != null) {
            return errorVO("该邮箱已注册，请重新输入邮箱");
        } else if (!checkPwdSame(user.getPassword(), repassword)) {
            return errorVO("两次输入的密码不一致，请重新输入密码");
        }

        user.setPassword(PwdUtil.getPwd(user.getPassword()));
        boolean addResult = userService.add(user);
        if (addResult) {
            return successVO();
        } else {
            return errorVO("系统异常，请重新提交或刷新后重新输入注册信息");
        }    
        
    }
    
    private boolean checkPwdSame(String pwd, String repwd) {
        if (StringUtils.isBlank(pwd) || StringUtils.isBlank(repwd) || !pwd.equals(repwd)) {
            return false;
        }
        return true;
    }
    
}
