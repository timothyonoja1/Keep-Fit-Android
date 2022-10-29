package com.kratos.keepfit.entities;

import java.util.Date;

public class FitnessBuddy {

    private final int fitnessBuddyID;
    private final int userProfileID;
    private Date dateSavedToLocalDatabase;

    public FitnessBuddy(int fitnessBuddyID, int userProfileID) {
        this.fitnessBuddyID = fitnessBuddyID;
        this.userProfileID = userProfileID;
    }

    public int getFitnessBuddyID() {
        return fitnessBuddyID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}