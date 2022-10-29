package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.localdatasources.interfaces.UserAllergyLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.UserAllergyRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.UserAllergyRepository;
import java.util.List;
import javax.inject.Inject;

public class UserAllergyRepositoryImpl implements UserAllergyRepository {

    private final UserDataStore userDataStore;
    private final UserAllergyLocalDataSource userAllergyLocalDataSource;
    private final UserAllergyRemoteDataSource userAllergyRemoteDataSource;

    @Inject
    public UserAllergyRepositoryImpl(
            UserDataStore userDataStore, UserAllergyLocalDataSource userAllergyLocalDataSource,
            UserAllergyRemoteDataSource userAllergyRemoteDataSource){
        this.userDataStore = userDataStore;
        this.userAllergyLocalDataSource = userAllergyLocalDataSource;
        this.userAllergyRemoteDataSource = userAllergyRemoteDataSource;
    }

    @Override
    public boolean saveUserAllergy(List<Integer> allergyIDs) {
        return userAllergyLocalDataSource.saveUserAllergy(allergyIDs);
    }

    @Override
    public boolean sendSavedUserAllergiesToBackend() {
        int userProfileID = userDataStore.getLoggedInUserProfile().getUserProfileID();
        List<Integer> allergyIDs = userAllergyLocalDataSource.getAllergyIDs();
        return userAllergyRemoteDataSource.postUserAllergies(allergyIDs, userProfileID);
    }
}