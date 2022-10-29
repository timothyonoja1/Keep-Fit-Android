package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class UserDiet {

    private final int userDietID;
    private final int userProfileID;
    private final int dietID;
    private Date dateSavedToLocalDatabase;

    public UserDiet(int userDietID, int userProfileID, int dietID) {
        this.userDietID = userDietID;
        this.userProfileID = userProfileID;
        this.dietID = dietID;
    }

    public int getUserDietID() {
        return userDietID;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public int getDietID() {
        return dietID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
