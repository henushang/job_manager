package com.henushang.job_manager.enums;

public enum EResponseStatus {
    FAIL(0),
    SUCCESS(1);

    public int getValue() {
        return this.value;
    }
    
    private int value;
    private EResponseStatus(int value) {
        this.value = value;
    }
}
