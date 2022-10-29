package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.remotedatasources.interfaces.UserFitnessGoalRemoteDataSource;
import java.util.List;

import javax.inject.Inject;

public class FakeUserFitnessGoalRemoteDataSource implements UserFitnessGoalRemoteDataSource {

    @Inject
    public FakeUserFitnessGoalRemoteDataSource() {

    }

    @Override
    public boolean postUserFitnessGoals(List<Integer> fitnessGoalIDs, int userProfileID) {
        return true;
    }
}
