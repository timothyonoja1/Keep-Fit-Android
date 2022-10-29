package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class UserAllergy {

    private final int userAllergyID;
    private final int userProfileID;
    private final int allergyID;
    private Date dateSavedToLocalDatabase;

    public UserAllergy(int userAllergyID, int userProfileID, int allergyID) {
        this.userAllergyID = userAllergyID;
        this.userProfileID = userProfileID;
        this.allergyID = allergyID;
    }

    public int getUserAllergyID() {
        return userAllergyID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public int getAllergyID() {
        return allergyID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
