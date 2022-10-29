package com.kratos.keepfit.datastores.interfaces;

public interface AgeRangeDataStore {

    boolean saveAgeSelectedByUser(int age);

    boolean saveAgeRangeIDSelectedByUser(int ageRangeID);

    int getAgeSelectedByUser();

    int getAgeRangeIDSelectedByUser();

    boolean deleteAgeSelectedByUser();

    boolean deleteAgeRangeSelectedByUser();

}
