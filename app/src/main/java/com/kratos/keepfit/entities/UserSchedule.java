package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class UserSchedule {

    private final int userScheduleID;
    private final int userProfileID;
    private final int scheduleID;
    private Date dateSavedToLocalDatabase;

    public UserSchedule(int userScheduleID, int userProfileID, int scheduleID) {
        this.userScheduleID = userScheduleID;
        this.userProfileID = userProfileID;
        this.scheduleID = scheduleID;
    }

    public int getUserScheduleID() {
        return userScheduleID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
