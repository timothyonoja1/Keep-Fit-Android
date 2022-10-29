package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class WeightRange {

    private final int weightRangeID;
    private final int minimumWeightInKg;
    private final int maximumWeightInKG;
    private final String description;
    private Date dateSavedToLocalDatabase;

    public WeightRange(int weightRangeID, int minimumWeightInKg,
                       int maximumWeightInKG, String description) {
        this.weightRangeID = weightRangeID;
        this.minimumWeightInKg = minimumWeightInKg;
        this.maximumWeightInKG = maximumWeightInKG;
        this.description = description;
    }

    public int getWeightRangeID() {
        return weightRangeID;
    }

    public int getMinimumWeightInKg() {
        return minimumWeightInKg;
    }

    public int getMaximumWeightInKG() {
        return maximumWeightInKG;
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
