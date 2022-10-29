package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class EquipmentRequirement {

    private final int equipmentRequirementID;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public EquipmentRequirement(int equipmentRequirementID, String name) {
        this.equipmentRequirementID = equipmentRequirementID;
        this.name = name;
    }

    public int getEquipmentRequirementID() {
        return equipmentRequirementID;
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
