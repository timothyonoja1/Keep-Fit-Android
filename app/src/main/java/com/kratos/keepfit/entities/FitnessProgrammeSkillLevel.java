package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class FitnessProgrammeSkillLevel {

    private final int fitnessProgrammeSkillLevelID;
    private final int fitnessProgrammeID;
    private final int skillLevelID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeSkillLevel(int fitnessProgrammeSkillLevelID,
                                      int fitnessProgrammeID, int skillLevelID) {
        this.fitnessProgrammeSkillLevelID = fitnessProgrammeSkillLevelID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.skillLevelID = skillLevelID;
    }

    public int getFitnessProgrammeSkillLevelID() {
        return fitnessProgrammeSkillLevelID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getSkillLevelID() {
        return skillLevelID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
