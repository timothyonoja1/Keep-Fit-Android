package com.kratos.keepfit.entities;

import androidx.room.Entity;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

@Entity
public class FitnessCategory {

    @SerializedName("FitnessCategoryID")
    private final int fitnessCategoryID;

    @SerializedName("Name")
    private final String name;

    private Date dateSavedToLocalDatabase;

    public FitnessCategory(int fitnessCategoryID, String name) {
        this.fitnessCategoryID = fitnessCategoryID;
        this.name = name;
    }

    public int getFitnessCategoryID() {
        return fitnessCategoryID;
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