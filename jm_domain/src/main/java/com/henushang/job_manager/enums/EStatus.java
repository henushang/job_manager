package com.henushang.job_manager.enums;

public enum EStatus {
    NORMAL(0),
    DELETED(1);

    public int getValue() {
        return this.value;
    }
    
    private int value;
    private EStatus(int value) {
        this.value = value;
    }
}
