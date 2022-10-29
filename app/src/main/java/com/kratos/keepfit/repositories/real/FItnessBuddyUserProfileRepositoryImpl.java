package com.kratos.keepfit.repositories.real;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import com.kratos.keepfit.localdatasources.interfaces.FitnessBuddyUserProfileLocalDataSource;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessBuddyUserProfileRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyUserProfileRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FItnessBuddyUserProfileRepositoryImpl implements FitnessBuddyUserProfileRepository {

    private final FitnessBuddyUserProfileRemoteDataSource fitnessBuddyUserProfileRemoteDataSource;
    private final FitnessBuddyUserProfileLocalDataSource fitnessBuddyUserProfileLocalDataSource;

    @Inject
    public FItnessBuddyUserProfileRepositoryImpl(
            FitnessBuddyUserProfileRemoteDataSource fitnessBuddyUserProfileRemoteDataSource,
            FitnessBuddyUserProfileLocalDataSource fitnessBuddyUserProfileLocalDataSource) {
        this.fitnessBuddyUserProfileRemoteDataSource = fitnessBuddyUserProfileRemoteDataSource;
        this.fitnessBuddyUserProfileLocalDataSource = fitnessBuddyUserProfileLocalDataSource;
    }

    @Override
    public boolean addFitnessBuddy(int fitnessBuddyID, int userProfileID) {
        FitnessBuddyUserProfile fitnessBuddyUserProfile =
                fitnessBuddyUserProfileRemoteDataSource.addFitnessBuddy(fitnessBuddyID, userProfileID);
        return fitnessBuddyUserProfileLocalDataSource.saveFitnessBuddyUserProfile(fitnessBuddyUserProfile);
    }

    @Override
    public List<Integer> getAllUnrelatedFitnessBuddyIDs(int userProfileID) {
        if (fitnessBuddyUserProfileLocalDataSource.isOutdated(userProfileID)) {
            refresh(userProfileID);
        }
        List<FitnessBuddyUserProfile> unrelatedFitnessBuddyUserProfiles
                = fitnessBuddyUserProfileLocalDataSource.getAllUnrelatedFitnessBuddyUserProfile(userProfileID);
        List<Integer> unrelatedFitnessBuddyIDs = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : unrelatedFitnessBuddyUserProfiles) {
            unrelatedFitnessBuddyIDs.add(fitnessBuddyUserProfile.getFitnessBuddyID());
        }
        return unrelatedFitnessBuddyIDs;
    }

    private void refresh(int userProfileID) {
        List<FitnessBuddyUserProfile> unrelatedFitnessBuddyUserProfiles
                = fitnessBuddyUserProfileRemoteDataSource.getAllUnrelatedFitnessBuddyUserProfiles(userProfileID);
        fitnessBuddyUserProfileLocalDataSource.saveFitnessBuddyUserProfiles(unrelatedFitnessBuddyUserProfiles);
    }

    @Override
    public List<Integer> getFitnessBuddyIDs(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        if (fitnessBuddyUserProfileLocalDataSource.isOutdated(fitnessBuddyRequestStatus, userProfileID)) {
            refresh(fitnessBuddyRequestStatus, userProfileID);
        }
        List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles
                = fitnessBuddyUserProfileLocalDataSource.getFitnessBuddyUserProfiles(
                        fitnessBuddyRequestStatus, userProfileID);
        List<Integer> fitnessBuddyIDs = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : fitnessBuddyUserProfiles) {
            fitnessBuddyIDs.add(fitnessBuddyUserProfile.getFitnessBuddyID());
        }
        return fitnessBuddyIDs;
    }

    private void refresh(FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles
                = fitnessBuddyUserProfileRemoteDataSource.getFitnessBuddyUserProfiles(
                        fitnessBuddyRequestStatus, userProfileID);
        fitnessBuddyUserProfileLocalDataSource.saveFitnessBuddyUserProfiles(fitnessBuddyUserProfiles);
    }
}