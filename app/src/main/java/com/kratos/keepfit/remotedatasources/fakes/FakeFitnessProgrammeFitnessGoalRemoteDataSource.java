package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeFitnessGoalRemoteDataSource;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeFitnessGoalRemoteDataSource implements FitnessProgrammeFitnessGoalRemoteDataSource {

    @Inject
    public FakeFitnessProgrammeFitnessGoalRemoteDataSource() {

    }

    @Override
    public List<FitnessProgrammeFitnessGoal> getAllFitnessProgrammeFitnessGoals() {
        return new ArrayList<>();
    }

}