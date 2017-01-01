package com.henushang.job_manager.domain.base;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.henushang.job_manager.util.UUIDUtil;

/**
 * Created by baby on 2016/12/24.
 */
public abstract class BaseDomain {
    private String _id;
    private Date createTime;
    private Date updateTime;
    
    public BaseDomain() {
        if (StringUtils.isEmpty(_id)) {
            _id = UUIDUtil.getId();
        }
        if (updateTime == null) {
            updateTime = new Date();
        }
        if (createTime == null) {
            createTime = new Date();
        }
    }

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
