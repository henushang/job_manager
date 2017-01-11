package com.henushang.job_manager.enums;

public enum ESchedule {
    RATIO0(0),
    RATIO10(10),
    RATIO20(20),
    RATIO30(30),
    RATIO40(40),
    RATIO50(50),
    RATIO60(60),
    RATIO70(70),
    RATIO80(80),
    RATIO90(90),
    RATIO100(100);

    public int getValue() {
        return this.value;
    }
    
    private int value;
    private ESchedule(int value) {
        this.value = value;
    }
}
