package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessGoal;
import com.kratos.keepfit.localdatasources.interfaces.FitnessGoalLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessGoalRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessGoalRepository;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class FitnessGoalRepositoryImpl implements FitnessGoalRepository {

    private final FitnessGoalLocalDataSource fitnessGoalLocalDataSource;
    private final FitnessGoalRemoteDataSource fitnessGoalRemoteDataSource;

    @Inject
    public FitnessGoalRepositoryImpl(FitnessGoalLocalDataSource fitnessGoalLocalDataSource,
                                     FitnessGoalRemoteDataSource fitnessGoalRemoteDataSource) {
        this.fitnessGoalLocalDataSource = fitnessGoalLocalDataSource;
        this.fitnessGoalRemoteDataSource = fitnessGoalRemoteDataSource;
    }

    @Override
    public List<FitnessGoal> getAllFitnessGoals() {
        if (fitnessGoalLocalDataSource.isOutdated()){
            refreshFitnessGoalLocalDataSource();
        }
        return fitnessGoalLocalDataSource.getAllFitnessGoals();
    }

    private void refreshFitnessGoalLocalDataSource() {
        List<FitnessGoal> fitnessGoals = fitnessGoalRemoteDataSource.getAllFitnessGoals();
        Date currentDate = new Date();
        for (FitnessGoal fitnessGoal : fitnessGoals) {
            fitnessGoal.setDateSavedToLocalDatabase(currentDate);
        }
        fitnessGoalLocalDataSource.saveFitnessGoals(fitnessGoals);
    }
}
