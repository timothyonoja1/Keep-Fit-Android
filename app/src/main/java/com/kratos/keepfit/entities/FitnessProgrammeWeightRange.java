package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgrammeWeightRange {

    private final int fitnessProgrammeWeightRangeID;
    private final int fitnessProgrammeID;
    private final int weightRangeID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeWeightRange(int fitnessProgrammeWeightRangeID,
                                       int fitnessProgrammeID, int weightRangeID) {
        this.fitnessProgrammeWeightRangeID = fitnessProgrammeWeightRangeID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.weightRangeID = weightRangeID;
    }

    public int getFitnessProgrammeWeightRangeID() {
        return fitnessProgrammeWeightRangeID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getWeightRangeID() {
        return weightRangeID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
