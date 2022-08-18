package com.kratos.keepfit.core;

public class Schedule {

    private final int scheduleID;
    private final String time;
    private final String scheduleStatus;

    public Schedule(int scheduleID, String time, String scheduleStatus) {
        this.scheduleID = scheduleID;
        this.time = time;
        this.scheduleStatus = scheduleStatus;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public String getTime() {
        return time;
    }

    public String getScheduleStatus() {
        return scheduleStatus;
    }
}
