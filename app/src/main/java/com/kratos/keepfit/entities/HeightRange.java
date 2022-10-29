package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class HeightRange {

    private final int heightRangeID;
    private final int minimumHeightInCM;
    private final int maximumHeightInCM;
    private Date dateSavedToLocalDatabase;

    public HeightRange(int heightRangeID,
                       int minimumHeightInCM, int maximumHeightInCM) {
        this.heightRangeID = heightRangeID;
        this.minimumHeightInCM = minimumHeightInCM;
        this.maximumHeightInCM = maximumHeightInCM;
    }

    public int getHeightRangeID() {
        return heightRangeID;
    }

    public int getMinimumHeightInCM() {
        return minimumHeightInCM;
    }

    public int getMaximumHeightInCM() {
        return maximumHeightInCM;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
