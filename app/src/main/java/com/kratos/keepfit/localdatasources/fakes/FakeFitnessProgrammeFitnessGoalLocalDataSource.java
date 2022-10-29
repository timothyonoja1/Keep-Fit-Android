package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeFitnessGoalLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessProgrammeFitnessGoalLocalDataSource
    implements FitnessProgrammeFitnessGoalLocalDataSource {

    private final List<FitnessProgrammeFitnessGoal> fitnessProgrammeFitnessGoals = new ArrayList<>();

    @Inject
    public FakeFitnessProgrammeFitnessGoalLocalDataSource() {

    }

    @Override
    public boolean isOutdated() {
        return true;
    }

    @Override
    public boolean saveFitnessProgrammeFitnessGoals(List<FitnessProgrammeFitnessGoal> fitnessProgrammeFitnessGoals) {
        this.fitnessProgrammeFitnessGoals.clear();
        this.fitnessProgrammeFitnessGoals.addAll(fitnessProgrammeFitnessGoals);
        return true;
    }

    @Override
    public List<Integer> getFitnessProgrammeIDs(int fitnessGoalID) {
        List<Integer> result = new ArrayList<>();
        for (FitnessProgrammeFitnessGoal fitnessProgrammeFitnessGoal: fitnessProgrammeFitnessGoals) {
            if (fitnessProgrammeFitnessGoal.getFitnessGoalID() == fitnessGoalID) {
                result.add(fitnessProgrammeFitnessGoal.getFitnessProgrammeID());
            }
        }
        return result;
    }

    @Override
    public List<Integer> getFitnessProgrammeIDs(List<Integer> fitnessGoalIDs) {
        List<Integer> result = new ArrayList<>();
        for (int fitnessGoalID : fitnessGoalIDs) {
            result.addAll(getFitnessProgrammeIDs(fitnessGoalID));
        }
        return result;
    }
}
