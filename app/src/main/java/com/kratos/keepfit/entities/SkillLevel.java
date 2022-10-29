package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class SkillLevel {

    private final int skillLevelID;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public SkillLevel(int skillLevelID, String name) {
        this.skillLevelID = skillLevelID;
        this.name = name;
    }

    public int getSkillLevelID() {
        return skillLevelID;
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
