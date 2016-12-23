package com.henushang.pa.util;

import java.util.Properties;

public class PropertiesUtil {
    
    private static Properties instance = null;
    
    public static Properties getProperties(String path) {
        if (instance == null) {
            instance = new Properties();
            try {
                Class clazz = Class.forName("com.henushang.pa.util.PropertiesUtil");
                instance.load(
                        clazz.getResourceAsStream("/" + path));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return instance;
    }
    
    
}
