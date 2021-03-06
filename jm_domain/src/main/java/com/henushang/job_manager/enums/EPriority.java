package com.henushang.job_manager.enums;

public enum EPriority {
    LOW(1),
    MEDIUM(5),
    HIGH(10);

    public int getValue() {
        return this.value;
    }
    
    private int value;
    private EPriority(int value) {
        this.value = value;
    }
}
