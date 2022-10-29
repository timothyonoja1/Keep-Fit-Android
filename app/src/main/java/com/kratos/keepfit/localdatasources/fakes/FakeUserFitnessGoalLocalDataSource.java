package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.localdatasources.interfaces.UserFitnessGoalLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeUserFitnessGoalLocalDataSource implements UserFitnessGoalLocalDataSource {

    private final List<Integer> fitnessGoalIDs = new ArrayList<>();

    @Inject
    public FakeUserFitnessGoalLocalDataSource() {

    }

    @Override
    public boolean saveUserFitnessGoal(List<Integer> fitnessGoalIDs) {
        this.fitnessGoalIDs.clear();
        this.fitnessGoalIDs.addAll(fitnessGoalIDs);
        return true;
    }

    @Override
    public List<Integer> getFitnessGoalIDs() {
        return fitnessGoalIDs;
    }
}