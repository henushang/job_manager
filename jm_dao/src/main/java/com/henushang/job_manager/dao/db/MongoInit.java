package com.henushang.job_manager.dao.db;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.henushang.job_manager.util.PropertiesUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInit {

	private static Logger logger = Logger.getLogger(MongoInit.class);

	private static MongoClient mongo;
	private static MongoDatabase db;
	private static String dbName = "job_manager";

	static {
		logger.info("start init MongoClient...");
		Map<String, Object> map = PropertiesUtil.getPropMap("conf/db.properties");
		String host = map.get("mongo_host").toString();
		checkEmpty(host, "host");
		logger.info("config mongo_host value:" + host);
		
		String hostName = host.split(":")[0];
		int port = Integer.parseInt(host.split(":")[1]);
		mongo = new MongoClient(hostName, port);
		logger.info("init MongoClient success!");
		
		dbName = map.get("mongo_db_name").toString();
		checkEmpty(dbName, "dbName");
		logger.info("config mongo_db_name value is :" + dbName);
	}

	
	private static void checkEmpty(String str, String strName) {
	    if (StringUtils.isEmpty(str)) {
            throw new RuntimeException(String.format("empty %s config!", strName));
        }
	}
	
	public static MongoDatabase getDB() throws Exception{
		if (StringUtils.isEmpty(dbName)) {
			throw new Exception("db name can't be empty!");
		}
		if (db == null) {
			db = mongo.getDatabase(dbName);
		}
		return db;
	}

	public static MongoClient getMongoClient() {
		return mongo;
	}

	@SuppressWarnings("rawtypes")
	public static MongoCollection getColl(String collName) throws Exception {
		if (StringUtils.isEmpty(collName)) {
			throw new Exception("collName can't be empty!");
		}
		return getDB().getCollection(collName);
	}
}
