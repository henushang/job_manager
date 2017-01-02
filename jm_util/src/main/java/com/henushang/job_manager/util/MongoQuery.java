package com.henushang.job_manager.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        
    }
}
