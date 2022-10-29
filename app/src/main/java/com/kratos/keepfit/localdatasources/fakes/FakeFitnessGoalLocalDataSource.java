package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.localdatasources.interfaces.FitnessGoalLocalDataSource;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FakeFitnessGoalLocalDataSource implements FitnessGoalLocalDataSource {

    private final List<FitnessGoal> fitnessGoals = new ArrayList<>();

    @Inject
    public FakeFitnessGoalLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public List<FitnessGoal> getAllFitnessGoals() {
        return fitnessGoals;
    }

    @Override
    public boolean saveFitnessGoals(List<FitnessGoal> fitnessGoals) {
        this.fitnessGoals.clear();
        this.fitnessGoals.addAll(fitnessGoals);
        return true;
    }
}
