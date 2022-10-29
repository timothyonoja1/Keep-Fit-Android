package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.localdatasources.interfaces.UserFitnessGoalLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserFitnessGoalRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.UserFitnessGoalRepository;
import java.util.List;
import javax.inject.Inject;

public class UserFitnessGoalRepositoryImpl implements UserFitnessGoalRepository {

    private final UserDataStore userDataStore;
    private final UserFitnessGoalLocalDataSource userFitnessGoalLocalDataSource;
    private final UserFitnessGoalRemoteDataSource userFitnessGoalRemoteDataSource;

    @Inject
    public UserFitnessGoalRepositoryImpl(UserDataStore userDataStore,
                                         UserFitnessGoalLocalDataSource userFitnessGoalLocalDataSource,
                                         UserFitnessGoalRemoteDataSource userFitnessGoalRemoteDataSource) {
        this.userDataStore = userDataStore;
        this.userFitnessGoalLocalDataSource = userFitnessGoalLocalDataSource;
        this.userFitnessGoalRemoteDataSource = userFitnessGoalRemoteDataSource;
    }

    @Override
    public boolean saveUserFitnessGoalID(List<Integer> fitnessGoalIDs) {
        return userFitnessGoalLocalDataSource.saveUserFitnessGoal(fitnessGoalIDs);
    }

    @Override
    public List<Integer> getSavedFitnessGoalIDsOfLoggedInUser() {
        return userFitnessGoalLocalDataSource.getFitnessGoalIDs();
    }

    @Override
    public boolean sendSavedUserFitnessGoalsToBackend() {
        int userProfileID = userDataStore.getLoggedInUserProfile().getUserProfileID();
        List<Integer> fitnessGoalIDs = userFitnessGoalLocalDataSource.getFitnessGoalIDs();
        return userFitnessGoalRemoteDataSource.postUserFitnessGoals(fitnessGoalIDs, userProfileID);
    }

}