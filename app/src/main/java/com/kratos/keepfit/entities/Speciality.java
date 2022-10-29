package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class Speciality {

    private final int specialityID;
    private final String name;
    private final int userProfileID;
    private Date dateSavedToLocalDatabase;

    public Speciality(int specialityID, String name, int userProfileID) {
        this.specialityID = specialityID;
        this.name = name;
        this.userProfileID = userProfileID;
    }

    public int getSpecialityID() {
        return specialityID;
    }

    public String getName() {
        return name;
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
