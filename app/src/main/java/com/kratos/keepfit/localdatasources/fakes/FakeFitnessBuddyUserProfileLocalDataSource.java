package com.kratos.keepfit.localdatasources.fakes;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import com.kratos.keepfit.localdatasources.interfaces.FitnessBuddyUserProfileLocalDataSource;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyUserProfileLocalDataSource implements FitnessBuddyUserProfileLocalDataSource {

    private final List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyUserProfileLocalDataSource() {

    }

    @Override
    public boolean isOutdated(int userProfileID) {
        return true;
    }

    @Override
    public boolean saveFitnessBuddyUserProfile(FitnessBuddyUserProfile fitnessBuddyUserProfile) {
        fitnessBuddyUserProfiles.add(fitnessBuddyUserProfile);
        return true;
    }

    @Override
    public boolean saveFitnessBuddyUserProfiles(List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles) {
        this.fitnessBuddyUserProfiles.clear();
        this.fitnessBuddyUserProfiles.addAll(fitnessBuddyUserProfiles);
        return true;
    }

    @Override
    public List<FitnessBuddyUserProfile> getAllUnrelatedFitnessBuddyUserProfile(int userProfileID) {
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

    @Override
    public boolean isOutdated(FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        return true;
    }
}