package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessGoal {

    private final int fitnessGoalID;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public FitnessGoal(int fitnessGoalID, String name) {
        this.fitnessGoalID = fitnessGoalID;
        this.name = name;
    }

    public int getFitnessGoalID() {
        return fitnessGoalID;
    }

    public String getName() {
        return name;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}