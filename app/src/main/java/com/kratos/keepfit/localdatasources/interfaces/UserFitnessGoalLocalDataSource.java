package com.kratos.keepfit.localdatasources.interfaces;

import java.util.List;

public interface UserFitnessGoalLocalDataSource {

    boolean saveUserFitnessGoal(List<Integer> fitnessGoalIDs);

    List<Integer> getFitnessGoalIDs();

}
