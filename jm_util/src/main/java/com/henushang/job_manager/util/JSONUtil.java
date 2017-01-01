package com.henushang.job_manager.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONUtil {
	
    private static final Logger logger = Logger.getLogger(JSONUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();
	private static final DateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	static {
	    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setDateFormat(dateFromat);
	}
	
	public static String toJson(Object object) {
		try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("convert object to json string error!", e);
        }
		return null;
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("convert json string to object error!", e);
        }
		return null;
	}
	
}
