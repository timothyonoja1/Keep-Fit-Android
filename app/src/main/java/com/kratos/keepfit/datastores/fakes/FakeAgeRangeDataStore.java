package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.AgeRangeDataStore;
import javax.inject.Inject;

public class FakeAgeRangeDataStore implements AgeRangeDataStore {

    private int age;
    private int ageRangeID;

    @Inject
    public FakeAgeRangeDataStore() {

    }

    @Override
    public boolean saveAgeSelectedByUser(int age) {
        this.age = age;
        return true;
    }

    @Override
    public boolean saveAgeRangeIDSelectedByUser(int ageRangeID) {
        this.ageRangeID = ageRangeID;
        return true;
    }

    @Override
    public int getAgeSelectedByUser() {
        return age;
    }

    @Override
    public int getAgeRangeIDSelectedByUser() {
        return ageRangeID;
    }

    @Override
    public boolean deleteAgeSelectedByUser() {
        age = 0;
        return true;
    }

    @Override
    public boolean deleteAgeRangeSelectedByUser() {
        ageRangeID = 0;
        return true;
    }
}
