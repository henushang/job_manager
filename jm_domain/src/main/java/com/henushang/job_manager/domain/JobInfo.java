package com.henushang.job_manager.domain;

import com.henushang.job_manager.domain.base.BaseDomain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by baby on 2016/12/24.
 */
public class JobInfo extends BaseDomain {

    private String userId;
    private String jobName;
    @DateTimeFormat(pattern="yyyy-MM-dd")   
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date finishTime;
    private int schedule;
    private Date actualFinishTime;
    private String remarks;
    private int priority;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
