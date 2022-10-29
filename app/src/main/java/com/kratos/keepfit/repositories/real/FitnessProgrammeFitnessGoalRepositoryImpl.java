package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessProgrammeFitnessGoal;
import com.kratos.keepfit.localdatasources.interfaces.FitnessProgrammeFitnessGoalLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessProgrammeFitnessGoalRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessProgrammeFitnessGoalRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FitnessProgrammeFitnessGoalRepositoryImpl implements FitnessProgrammeFitnessGoalRepository {

    private final FitnessProgrammeFitnessGoalLocalDataSource fitnessProgrammeFitnessGoalLocalDataSource;
    private final FitnessProgrammeFitnessGoalRemoteDataSource fitnessProgrammeFitnessGoalRemoteDataSource;

    @Inject
    public FitnessProgrammeFitnessGoalRepositoryImpl(
            FitnessProgrammeFitnessGoalLocalDataSource fitnessProgrammeFitnessGoalLocalDataSource,
            FitnessProgrammeFitnessGoalRemoteDataSource fitnessProgrammeFitnessGoalRemoteDataSource) {
        this.fitnessProgrammeFitnessGoalLocalDataSource = fitnessProgrammeFitnessGoalLocalDataSource;
        this.fitnessProgrammeFitnessGoalRemoteDataSource = fitnessProgrammeFitnessGoalRemoteDataSource;
    }


    @Override
    public List<Integer> getFitnessProgrammeIDs(List<Integer> fitnessGoalIDs) {
        if (fitnessProgrammeFitnessGoalLocalDataSource.isOutdated()) {
            refreshFitnessProgrammeFitnessGoalLocalDataSource();
        }
        return fitnessProgrammeFitnessGoalLocalDataSource.getFitnessProgrammeIDs(fitnessGoalIDs);
    }

    private void refreshFitnessProgrammeFitnessGoalLocalDataSource() {
        List<FitnessProgrammeFitnessGoal> result
                = fitnessProgrammeFitnessGoalRemoteDataSource.getAllFitnessProgrammeFitnessGoals();
        Date currentDate = new Date();
        for (FitnessProgrammeFitnessGoal fitnessProgrammeFitnessGoal : result) {
            fitnessProgrammeFitnessGoal.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessProgrammeFitnessGoalLocalDataSource.saveFitnessProgrammeFitnessGoals(result);
    }
}
