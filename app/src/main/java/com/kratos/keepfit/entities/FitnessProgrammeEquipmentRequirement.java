package com.kratos.keepfit.entities;

import java.util.Date;

public class FitnessProgrammeEquipmentRequirement {

    private final  int fitnessProgrammeEquipmentRequirementID;
    private final int fitnessProgrammeID;
    private final int equipmentRequirementID;
    private Date dateSavedToLocalDatabase;

    public FitnessProgrammeEquipmentRequirement(int fitnessProgrammeEquipmentRequirementID,
                                                int fitnessProgrammeID, int equipmentRequirementID) {
        this.fitnessProgrammeEquipmentRequirementID = fitnessProgrammeEquipmentRequirementID;
        this.fitnessProgrammeID = fitnessProgrammeID;
        this.equipmentRequirementID = equipmentRequirementID;
    }

    public int getFitnessProgrammeEquipmentRequirementID() {
        return fitnessProgrammeEquipmentRequirementID;
    }

    public int getFitnessProgrammeID() {
        return fitnessProgrammeID;
    }

    public int getEquipmentRequirementID() {
        return equipmentRequirementID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
