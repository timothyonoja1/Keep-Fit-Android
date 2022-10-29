package com.kratos.keepfit.repositories.interfaces;

import java.util.List;

public interface UserFitnessGoalRepository {

    boolean saveUserFitnessGoalID(List<Integer> fitnessGoalIDs);

    List<Integer> getSavedFitnessGoalIDsOfLoggedInUser();

    boolean sendSavedUserFitnessGoalsToBackend();

}
