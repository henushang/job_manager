package com.henushang.job_manager.dao.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.conversions.Bson;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class MongoQuery {

    public static class SortClass {
        public static final int ASC = 1;
        public static final int DESC = -1;
        
        private List<Map<String, Integer>> sortList = new LinkedList<Map<String,Integer>>();
        
        public void addSortKey(String key, int sort) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put(key, sort);
            sortList.add(map);
        }
     
        public BasicDBObject toDBObject() {
            BasicDBObject dbObject = new BasicDBObject();
            for (Map<String, Integer> map : sortList) {
                String key = map.keySet().toArray()[0].toString();
                dbObject.append(key, map.get(key));
            }
            return dbObject;
        }
    }
}
