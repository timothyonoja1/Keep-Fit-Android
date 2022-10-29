package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import com.kratos.keepfit.remotedatasources.interfaces.FitnessBuddyUserProfileRemoteDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyUserProfileRemoteDataSource implements FitnessBuddyUserProfileRemoteDataSource {

    private final List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyUserProfileRemoteDataSource() {

    }

    @Override
    public FitnessBuddyUserProfile addFitnessBuddy(int fitnessBuddyID, int userProfileID) {
        FitnessBuddyUserProfile fitnessBuddyUserProfile = new FitnessBuddyUserProfile(
                200, fitnessBuddyID, userProfileID, FitnessBuddyRequestStatus.PendingAcceptance
        );
        fitnessBuddyUserProfiles.add(fitnessBuddyUserProfile);
        return fitnessBuddyUserProfile;
    }

    @Override
    public List<FitnessBuddyUserProfile> getAllUnrelatedFitnessBuddyUserProfiles(int userProfileID) {
        List<FitnessBuddyUserProfile> result = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : fitnessBuddyUserProfiles) {
            if (fitnessBuddyUserProfile.getUserProfileID() != userProfileID) {
                result.add(fitnessBuddyUserProfile);
            }
        }
        return result;
    }

    @Override
    public List<FitnessBuddyUserProfile> getFitnessBuddyUserProfiles(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        List<FitnessBuddyUserProfile> result = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : fitnessBuddyUserProfiles) {
            if (fitnessBuddyUserProfile.getUserProfileID() == userProfileID
                    && fitnessBuddyUserProfile.getFitnessBuddyRequestStatus() == fitnessBuddyRequestStatus) {
                result.add(fitnessBuddyUserProfile);
            }
        }
        return result;
    }
}