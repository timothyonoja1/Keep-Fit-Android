package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgrammeHeightRange {

    private final int fitnessProgrammeHeightRangeID;
    private final int fitnessProgrammeID;
    private final int HeightRangeID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeHeightRange(int fitnessProgrammeHeightRangeID,
                                       int fitnessProgrammeID, int heightRangeID) {
        this.fitnessProgrammeHeightRangeID = fitnessProgrammeHeightRangeID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        HeightRangeID = heightRangeID;
    }

    public int getFitnessProgrammeHeightRangeID() {
        return fitnessProgrammeHeightRangeID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getHeightRangeID() {
        return HeightRangeID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
