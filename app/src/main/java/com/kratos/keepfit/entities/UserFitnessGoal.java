package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class UserFitnessGoal {

    private final int userFitnessGoalID;
    private final int userProfileID;
    private final int fitnessGoalID;
    private Date dateSavedToLocalDatabase;

    public UserFitnessGoal(int userFitnessGoalID, int userProfileID, int fitnessGoalID) {
        this.userFitnessGoalID = userFitnessGoalID;
        this.userProfileID = userProfileID;
        this.fitnessGoalID = fitnessGoalID;
    }

    public int getUserFitnessGoalID() {
        return userFitnessGoalID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public int getFitnessGoalID() {
        return fitnessGoalID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
