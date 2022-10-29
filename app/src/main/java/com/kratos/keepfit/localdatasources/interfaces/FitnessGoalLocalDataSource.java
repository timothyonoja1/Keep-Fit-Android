package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessGoal;

import java.util.List;

public interface FitnessGoalLocalDataSource {

    boolean isOutdated();

    List<FitnessGoal> getAllFitnessGoals();

    boolean saveFitnessGoals(List<FitnessGoal> fitnessGoals);

}
