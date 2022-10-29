package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.FitnessGoal;
import java.util.List;

public interface FitnessGoalRemoteDataSource {

    List<FitnessGoal> getAllFitnessGoals();
}
