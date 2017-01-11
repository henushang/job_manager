package com.henushang.job_manager.dao.db;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.henushang.job_manager.dao.db.MongoQuery.CompareClass.ECompareType;
import com.mongodb.BasicDBObject;

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
    
    public static class CompareClass {
        private String field;
        private Map<ECompareType, Object> comparator;
        
        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Map<ECompareType, Object> getComparator() {
            return comparator;
        }

        public void setComparator(Map<ECompareType, Object> comparator) {
            this.comparator = comparator;
        }

        public static enum ECompareType {
            LT("$lt"),
            LTE("$lte"),
            EQ("$eq"),
            GT("$gt"),
            GTE("$gte");
            
            public String getValue() {
                return this.value;
            }
            
            private String value;
            private ECompareType(String value) {
                this.value = value;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ECompareType.EQ.getValue());
    }
}
