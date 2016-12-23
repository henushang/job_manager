package com.henushang.job_manager.common;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebConf {
    
    public static String DOMAIN_NAME;
    public static String BASE_STATIC;
    
    @Value("#{web}")  
    public void setSysConf(Properties web){  
        DOMAIN_NAME= web.getProperty("domain_name");  
        BASE_STATIC= web.getProperty("base_static");  
    }
}
