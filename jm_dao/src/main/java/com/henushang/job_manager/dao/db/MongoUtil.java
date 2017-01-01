package com.henushang.job_manager.dao.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.Document;
import com.henushang.job_manager.dao.db.MongoQuery.SortClass;
import com.henushang.job_manager.domain.MongoConstant;
import com.henushang.job_manager.util.JSONUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

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
	
	@SuppressWarnings("unchecked")
    public static <T> List<T> findList(String collName, Map<String, Object> queryMap, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		try {
			BasicDBObject query = convertMap2BasicDBObject(queryMap);
			FindIterable<Document> iterable = null;
			BasicDBObject sortObject = getSortObject(queryMap);
			if (sortObject == null) {
			    iterable = MongoInit.getColl(collName).find(query);
            } else {
                iterable = MongoInit.getColl(collName).find(query).sort(sortObject);
            }
			for (Document document : iterable) {
				list.add(JSONUtil.fromJson(document.toJson(), clazz));
			}
		} catch (Exception e) {
			logger.error("findList() occur error! error message:" + e.getMessage(), e);
		}
		return list;
	}
	
	private static BasicDBObject getSortObject(Map<String, Object> queryMap) {
	    BasicDBObject sortObject = null;
	    for (String key : queryMap.keySet()) {
            if (MongoConstant.SORT.equals(key)) {
                SortClass sortClass = (SortClass) queryMap.get(key);
                sortObject = sortClass.toDBObject();
                break;
            }
        }
	    return sortObject;
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
		    if (MongoConstant.SORT.equals(key)) {
                continue;
            }
			dbObject.put(key, map.get(key));
		}
		return dbObject;
	}
	
	public static <T> boolean upsert(String collName, Map<String, Object> whereMap, T t) {
	    String json = JSONUtil.toJson(t);
        Map<String, Object> valueMap = JSONUtil.fromJson(json, HashMap.class);
	    return upsert(collName, whereMap, valueMap);
	}
	
	public static boolean upsert(String collName, Map<String, Object> whereMap, Map<String, Object> valueMap) {
	    BasicDBObject whereObject = new BasicDBObject(whereMap);
	    BasicDBObject valueObject = new BasicDBObject(valueMap);
	    boolean result = false;
        try {
            @SuppressWarnings("unchecked")
            UpdateResult updateResult = MongoInit.getColl(collName).replaceOne(whereObject, valueObject);
            System.out.println(JSONUtil.toJson(updateResult));
            result = updateResult.getModifiedCount() > 0;
        } catch (Exception e) {
            logger.error("update data error, msg:" + e.getMessage(), e);
        }
        return result;
	}
}
