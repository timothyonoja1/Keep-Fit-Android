package com.kratos.keepfit.datastores.interfaces;

public interface WeeklyTrainingDurationDataStore {

    int getSavedWeeklyTrainingDurationIDOfLoggedInUser();

    boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID);

}
