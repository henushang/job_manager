package com.henushang.job_manager.controller.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.henushang.job_manager.controller.BaseController;
import com.henushang.job_manager.converter.DateEditor;
import com.henushang.job_manager.domain.JobInfo;
import com.henushang.job_manager.service.JobInfoService;

@Controller
@RequestMapping("job_info")
public class JobInfoController extends BaseController {

    @Autowired
    private JobInfoService service;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        // 对于需要转换为Date类型的属性，使用DateEditor进行处理
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    @RequestMapping(value = { "/*", "/index" }, method = RequestMethod.GET)
    public String index() {
        return PREFIX_JOB_INFO + "index";
    }

    @RequestMapping(value = "job_info_list/{user_id}", method = RequestMethod.GET)
    public String jobList(@PathVariable String user_id, Model model, HttpServletRequest request) {
        List<JobInfo> list = service.getList(user_id);
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
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public boolean delete(@PathVariable String id, HttpServletRequest request) {
        boolean result = service.delete(id);
        return result;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, HttpServletRequest request) {
        JobInfo info = service.getOne(id);
        if (info == null) {
            return PAGE_404;
        }
        request.setAttribute("job_info", info);
        return PREFIX_JOB_INFO + "edit";
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public boolean edit_save(JobInfo jobInfo, @RequestParam String _id, HttpServletRequest request) {
        jobInfo.set_id(_id);
        jobInfo.setUserId(getCurUserId(request));
        boolean result = service.update(jobInfo);
        return result;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public JobInfo get(@PathVariable String id, HttpServletRequest request) {
        JobInfo info = service.getOne(id);
        return info;
    }
}
