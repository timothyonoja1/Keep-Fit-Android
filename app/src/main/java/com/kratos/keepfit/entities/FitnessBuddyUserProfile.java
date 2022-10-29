package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessBuddyUserProfile {
    private final int fitnessBuddyUserProfileID;
    private final int fitnessBuddyID;
    private final int userProfileID;
    private final FitnessBuddyRequestStatus fitnessBuddyRequestStatus;
    private Date dateSavedToLocalDatabase;

    public FitnessBuddyUserProfile(int fitnessBuddyUserProfileID, int fitnessBuddyID, int userProfileID,
                                   FitnessBuddyRequestStatus fitnessBuddyRequestStatus) {
        this.fitnessBuddyUserProfileID = fitnessBuddyUserProfileID;
        this.fitnessBuddyID = fitnessBuddyID;
        this.userProfileID = userProfileID;
        this.fitnessBuddyRequestStatus = fitnessBuddyRequestStatus;
    }

    public int getFitnessBuddyUserProfileID() {
        return fitnessBuddyUserProfileID;
    }

    public int getFitnessBuddyID() {
        return fitnessBuddyID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public FitnessBuddyRequestStatus getFitnessBuddyRequestStatus() {
        return fitnessBuddyRequestStatus;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}