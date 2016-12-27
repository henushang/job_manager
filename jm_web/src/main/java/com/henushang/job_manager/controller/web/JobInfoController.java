package com.henushang.job_manager.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henushang.job_manager.controller.BaseController;
import com.henushang.job_manager.domain.JobInfo;
import com.henushang.job_manager.service.JobInfoService;

@Controller
@RequestMapping("job_info")
public class JobInfoController extends BaseController {

    @Autowired
    private JobInfoService service;
    
    @RequestMapping(value = {"/*", "/index"}, method = RequestMethod.GET)
    public String index() {
        return PREFIX_JOB_INFO + "index";
    }
    
    @RequestMapping(value = "job_info_list/{user_id}", method = RequestMethod.GET)
    public String jobList(@PathVariable String user_id, Model model, HttpServletRequest request) {
        List<JobInfo> list = service.getList(user_id);
        System.err.println(list.size());
        model.addAttribute("job_infos", list);
        return PREFIX_JOB_INFO + "job_info_list";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        return PREFIX_JOB_INFO + "add";
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, Object> addPost(Model model, JobInfo jobInfo, HttpServletRequest request) {
        String userId = getCurUserId(request);
        jobInfo.setUserId(userId);
        boolean result = service.add(jobInfo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", result);
        return map;
    }
    
    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET,
        headers = "Accept=*/*",produces = "application/json")
    public boolean delete(@PathVariable String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        return result;
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, HttpServletRequest request) {
        JobInfo info = service.getOne(id);
        if (info == null) {
            return PAGE_404;
        }
        request.setAttribute("birth_info", info);
        return PREFIX_JOB_INFO + "edit";
    }
    
    @ResponseBody
    @RequestMapping("/get/{id}")
    public JobInfo get(@PathVariable String id, HttpServletRequest request) {
        JobInfo info = service.getOne(id);
        return info;
    }
}
