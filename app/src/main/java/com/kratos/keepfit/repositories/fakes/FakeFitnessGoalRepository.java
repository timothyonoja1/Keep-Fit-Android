package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.repositories.interfaces.FitnessGoalRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessGoalRepository implements FitnessGoalRepository {

    @Inject
    public FakeFitnessGoalRepository(){

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
