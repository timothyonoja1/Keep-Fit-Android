package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import java.util.List;

public interface FitnessProgrammeFitnessGoalLocalDataSource {

    boolean isOutdated();

    boolean saveFitnessProgrammeFitnessGoals(
            List<FitnessProgrammeFitnessGoal> fitnessProgrammeFitnessGoals);

    List<Integer> getFitnessProgrammeIDs(int fitnessGoalID);

    List<Integer> getFitnessProgrammeIDs(List<Integer> fitnessGoalIDs);

}
