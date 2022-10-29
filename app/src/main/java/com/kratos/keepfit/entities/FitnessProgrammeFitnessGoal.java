package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgrammeFitnessGoal {

    private final int FitnessProgrammeFitnessGoalID;
    private final int fitnessProgrammeID;
    private final int fitnessGoalID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeFitnessGoal(int fitnessProgrammeFitnessGoalID,
                                       int fitnessProgrammeID, int fitnessGoalID) {
        FitnessProgrammeFitnessGoalID = fitnessProgrammeFitnessGoalID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.fitnessGoalID = fitnessGoalID;
    }

    public int getFitnessProgrammeFitnessGoalID() {
        return FitnessProgrammeFitnessGoalID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
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
