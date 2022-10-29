package com.kratos.keepfit.entities;

import java.util.Date;

public class SessionTime {

    private final int sessionTimeID;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public SessionTime(int sessionTimeID, String name) {
        this.sessionTimeID = sessionTimeID;
        this.name = name;
    }

    public int getSessionTimeID() {
        return sessionTimeID;
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
