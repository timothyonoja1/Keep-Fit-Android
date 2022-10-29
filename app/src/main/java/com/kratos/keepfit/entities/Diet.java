package com.kratos.keepfit.entities;

import java.util.Date;

public class Diet {

    private final int dietID;
    private final int name;
    private Date dateSavedToLocalDatabase;

    public Diet(int dietID, int name) {
        this.dietID = dietID;
        this.name = name;
    }

    public int getDietID() {
        return dietID;
    }

    public int getName() {
        return name;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}