package com.kratos.keepfit.entities;

public class Speciality {

    private final int specialityID;
    private final String  name;

    public Speciality(int specialityID, String name) {
        this.specialityID = specialityID;
        this.name = name;
    }

    public int getSpecialityID() {
        return specialityID;
    }

    public String getName() {
        return name;
    }
}
