package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class Schedule {

    private final int scheduleID;
    private final String time;
    private final String scheduleStatus;
    private Date dateSavedToLocalDatabase;

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

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
