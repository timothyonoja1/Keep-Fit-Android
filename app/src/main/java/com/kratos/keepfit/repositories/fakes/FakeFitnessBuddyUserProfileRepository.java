package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyUserProfileRepository;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class FakeFitnessBuddyUserProfileRepository implements FitnessBuddyUserProfileRepository {

    private final List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles = new ArrayList<>();

    @Inject
    public FakeFitnessBuddyUserProfileRepository() {

    }

    @Override
    public boolean addFitnessBuddy(int fitnessBuddyID, int userProfileID) {
        FitnessBuddyUserProfile fitnessBuddyUserProfile = new FitnessBuddyUserProfile(
                200, fitnessBuddyID, userProfileID, FitnessBuddyRequestStatus.PendingAcceptance
        );
        fitnessBuddyUserProfiles.add(fitnessBuddyUserProfile);
        return true;
    }

    @Override
    public List<Integer> getAllUnrelatedFitnessBuddyIDs(int userProfileID) {
        List<Integer> result = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : fitnessBuddyUserProfiles) {
            if (fitnessBuddyUserProfile.getUserProfileID() != userProfileID) {
                result.add(fitnessBuddyUserProfile.getFitnessBuddyID());
            }
        }
        return result;
    }

    @Override
    public List<Integer> getFitnessBuddyIDs(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        List<Integer> result = new ArrayList<>();
        for (FitnessBuddyUserProfile fitnessBuddyUserProfile : fitnessBuddyUserProfiles) {
            if (fitnessBuddyUserProfile.getUserProfileID() == userProfileID
                    && fitnessBuddyUserProfile.getFitnessBuddyRequestStatus() == fitnessBuddyRequestStatus) {
                result.add(fitnessBuddyUserProfile.getFitnessBuddyID());
            }
        }
        return result;
    }
}