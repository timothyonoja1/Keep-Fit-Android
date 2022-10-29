package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class AgeRange {

    private final int ageRangeID;
    private final int minimumAge;
    private final int maximumAge;
    private final int description;
    private Date dateSavedToLocalDatabase;

    public AgeRange(int ageRangeID, int minimumAge, int maximumAge, int description) {
        this.ageRangeID = ageRangeID;
        this.minimumAge = minimumAge;
        this.maximumAge = maximumAge;
        this.description = description;
    }

    public int getAgeRangeID() {
        return ageRangeID;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public int getDescription() {
        return description;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
