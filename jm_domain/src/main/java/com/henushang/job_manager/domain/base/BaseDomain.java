package com.henushang.job_manager.domain.base;

import java.util.Date;

/**
 * Created by baby on 2016/12/24.
 */
public class BaseDomain {
    protected String _id;
    protected Date createTime;
    protected Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
