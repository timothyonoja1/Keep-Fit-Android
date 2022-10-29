package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgrammeAgeRange {

    private final int fitnessProgrammeAgeRangeID;
    private final int fitnessProgrammeID;
    private final int ageRangeID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeAgeRange(int fitnessProgrammeAgeRangeID,
                                    int fitnessProgrammeID, int ageRangeID) {
        this.fitnessProgrammeAgeRangeID = fitnessProgrammeAgeRangeID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.ageRangeID = ageRangeID;
    }

    public int getFitnessProgrammeAgeRangeID() {
        return fitnessProgrammeAgeRangeID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getAgeRangeID() {
        return ageRangeID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
