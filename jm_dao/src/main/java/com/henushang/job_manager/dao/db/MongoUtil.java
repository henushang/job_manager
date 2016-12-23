package com.henushang.job_manager.dao.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.henushang.pa.util.JSONUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;

public class MongoUtil {
	
	private static Logger logger = Logger.getLogger(MongoUtil.class);
	
	@SuppressWarnings("unchecked")
	public static boolean insertOne(String collName, Object obj) {
		boolean result = true;
		String json = JSONUtil.toJson(obj);
		try {
			MongoInit.getColl(collName).insertOne(Document.parse(json));
		} catch (Exception e) {
			logger.error("insert data error! collName:" + collName + ", object data:"
					+ json, e);
			result = false;
		}
		return result;
	}
	
	public static <T> T findOne(String collName, Map<String, Object> queryMap, Class<T> clazz) {
		
		try {
			BasicDBObject query = convertMap2BasicDBObject(queryMap);
			@SuppressWarnings("unchecked")
			FindIterable<Document> iterable = MongoInit.getColl(collName).find(query);
			Document first = iterable.first();
			return JSONUtil.fromJson(first.toJson(), clazz);
		} catch (Exception e) {
			logger.error("findOne ocur error! error message:" + e.getMessage(), e);
		}
		return null;
	}
	
	public static <T> List<T> findList(String collName, Map<String, Object> queryMap, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		try {
			BasicDBObject query = convertMap2BasicDBObject(queryMap);
			@SuppressWarnings("unchecked")
			FindIterable<Document> iterable = MongoInit.getColl(collName).find(query);
			for (Document document : iterable) {
				list.add(JSONUtil.fromJson(document.toJson(), clazz));
			}
		} catch (Exception e) {
			logger.error("findList() occur error! error message:" + e.getMessage(), e);
		}
		return list;
	}
	
	public static boolean delete(String collName, Map<String, Object> queryMap) {
		try {
			BasicDBObject query = convertMap2BasicDBObject(queryMap);
			DeleteResult result = MongoInit.getColl(collName).deleteMany(query);
			return result.getDeletedCount() > 0;
		} catch (Exception e) {
			logger.error("delete data error!", e);
		}
		return false;
	}
	
	private static BasicDBObject convertMap2BasicDBObject(Map<String, Object> map) {
		BasicDBObject dbObject = new BasicDBObject();
		for (String key : map.keySet()) {
			dbObject.put(key, map.get(key));
		}
		return dbObject;
	}
}
