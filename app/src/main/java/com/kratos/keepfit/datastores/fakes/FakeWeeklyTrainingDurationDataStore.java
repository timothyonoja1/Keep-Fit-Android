package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.WeeklyTrainingDurationDataStore;
import javax.inject.Inject;

public class FakeWeeklyTrainingDurationDataStore implements WeeklyTrainingDurationDataStore {

    private int weeklyTrainingDurationID;

    @Inject
    public FakeWeeklyTrainingDurationDataStore() {

    }

    @Override
    public int getSavedWeeklyTrainingDurationIDOfLoggedInUser() {
        return weeklyTrainingDurationID;
    }

    @Override
    public boolean saveWeeklyTrainingDurationIDofUser(int weeklyTrainingDurationID) {
        this.weeklyTrainingDurationID = weeklyTrainingDurationID;
        return true;
    }
}