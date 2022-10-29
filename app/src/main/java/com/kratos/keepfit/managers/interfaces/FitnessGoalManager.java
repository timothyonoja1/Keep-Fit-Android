package com.kratos.keepfit.managers.interfaces;

import com.kratos.keepfit.entities.FitnessGoal;
import java.util.List;

public interface FitnessGoalManager {

    List<FitnessGoal> getALlFitnessGoals();

    List<Integer> getSavedFitnessGoalIDsOfLoggedInUser();

    boolean saveUserFitnessGoals(List<FitnessGoal> fitnessGoals);

}
