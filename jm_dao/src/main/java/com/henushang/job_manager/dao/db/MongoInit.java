package com.henushang.job_manager.dao.db;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

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
		
		// TODO 先使用最简单的进行开发，以后改成可配置的集群模式
		mongo = new MongoClient("localhost", 27017);

		logger.info("init MongoClient success!");
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
