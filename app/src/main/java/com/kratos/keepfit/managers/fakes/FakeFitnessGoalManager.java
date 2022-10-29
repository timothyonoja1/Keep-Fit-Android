package com.kratos.keepfit.managers.fakes;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.managers.interfaces.FitnessGoalManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FakeFitnessGoalManager implements FitnessGoalManager {

    private final List<FitnessGoal> fitnessGoals = getMockFitnessGoals();

    @Inject
    public FakeFitnessGoalManager(){

    }

    @Override
    public List<FitnessGoal> getALlFitnessGoals() {
        return fitnessGoals;
    }

    @Override
    public List<Integer> getSavedFitnessGoalIDsOfLoggedInUser() {
        List<Integer> fitnessGoalIDs = new ArrayList<>();
        for (FitnessGoal fitnessGoal : fitnessGoals) {
            fitnessGoalIDs.add(fitnessGoal.getFitnessGoalID());
        }
        return fitnessGoalIDs;
    }

    @Override
    public boolean saveUserFitnessGoals(List<FitnessGoal> fitnessGoals) {
        return true;
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
