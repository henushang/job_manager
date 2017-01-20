package com.henushang.job_manager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:job_info/";
    }
}
