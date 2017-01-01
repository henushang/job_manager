package com.henushang.job_manager.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
    
    private static final Logger LOGGER = Logger.getLogger(PropertiesUtil.class);
    private static Properties instance = null;
    private static Map<String, Object> propMap = null;
    
    private static Properties getProperties(String path) {
        if (instance == null) {
            instance = new Properties();
            try {
                @SuppressWarnings("rawtypes")
                Class clazz = Class.forName("com.henushang.job_manager.util.PropertiesUtil");
                instance.load(
                        clazz.getResourceAsStream("/" + path));
            } catch (Exception e) {
                LOGGER.error(String.format("load properties file %s error!", path), e);
            }
        }
        return instance;
    }
    
    public static synchronized Map<String, Object> getPropMap(String path) {
        if (propMap == null) {
            instance = getProperties(path);
        }
        propMap = new HashMap<String, Object>();
        for (Object key : instance.keySet()) {
            propMap.put(key.toString(), instance.get(key));
        }
        
        return propMap;
    }
}
