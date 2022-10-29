package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class Allergy {

    private final int allergyID;
    private final String Name;
    private Date dateSavedToLocalDatabase;

    public Allergy(int allergyID, String name) {
        this.allergyID = allergyID;
        Name = name;
    }

    public int getAllergyID() {
        return allergyID;
    }

    public String getName() {
        return Name;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
