package com.kratos.keepfit.remotedatasources.interfaces;

import java.util.List;

public interface UserFitnessGoalRemoteDataSource {

    boolean postUserFitnessGoals(List<Integer> fitnessGoalIDs, int userProfileID);

}
