package com.henushang.job_manager.domain;

import java.util.Map;

public class ResponseVO {
    private int status;
    private String msg;
    private Map<String, Object> data;
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Map<String, Object> getData() {
        return data;
    }
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    
    
}
