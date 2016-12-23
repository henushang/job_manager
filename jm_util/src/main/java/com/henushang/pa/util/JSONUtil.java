package com.henushang.pa.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtil {
	
	private static Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public static String toJson(Object object) {
		return gson.toJson(object);
	}
	
	public static <T> T fromJson(String json, Class<T> clazz) {
		return gson.fromJson(json, clazz);
	}
}
