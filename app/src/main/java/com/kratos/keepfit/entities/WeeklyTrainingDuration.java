package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class WeeklyTrainingDuration {

    private final int weeklyTrainingDurationID;
    private final int minimumNumberOfDays;
    private final int maximumNumberOfDays;
    private final String description;
    private Date dateSavedToLocalDatabase;

    public WeeklyTrainingDuration(int weeklyTrainingDurationID, int minimumNumberOfDays,
                                  int maximumNumberOfDays, String description) {
        this.weeklyTrainingDurationID = weeklyTrainingDurationID;
        this.minimumNumberOfDays = minimumNumberOfDays;
        this.maximumNumberOfDays = maximumNumberOfDays;
        this.description = description;
    }

    public int getWeeklyTrainingDurationID() {
        return weeklyTrainingDurationID;
    }

    public int getMinimumNumberOfDays() {
        return minimumNumberOfDays;
    }

    public int getMaximumNumberOfDays() {
        return maximumNumberOfDays;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}