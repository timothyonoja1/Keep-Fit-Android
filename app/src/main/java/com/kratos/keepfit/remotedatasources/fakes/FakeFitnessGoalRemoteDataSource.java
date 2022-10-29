package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessGoalRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessGoalRemoteDataSource implements FitnessGoalRemoteDataSource {

    @Inject
    public FakeFitnessGoalRemoteDataSource() {

    }

    @Override
    public List<FitnessGoal> getAllFitnessGoals() {
        return getMockFitnessGoals();
    }

    private List<FitnessGoal> getMockFitnessGoals(){
        List<FitnessGoal> fitnessGoals = new ArrayList<>();
        fitnessGoals.add(new FitnessGoal(1, "Muscular Endurance"));
        fitnessGoals.add(new FitnessGoal(2, "Muscular Strength"));
        fitnessGoals.add(new FitnessGoal(3, "Cardiovascular Endurance"));
        fitnessGoals.add(new FitnessGoal(4, "Flexibility"));
        fitnessGoals.add(new FitnessGoal(5, "Body Composition"));
        fitnessGoals.add(new FitnessGoal(6, "Fat Loss"));
        fitnessGoals.add(new FitnessGoal(6, "Improve Mental Health"));
        fitnessGoals.add(new FitnessGoal(7, "Tone Up"));
        fitnessGoals.add(new FitnessGoal(8, "Muscle Gain"));

        return fitnessGoals;
    }
}
