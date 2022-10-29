package com.kratos.keepfit.localdatasources.interfaces;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import java.util.List;

public interface FitnessBuddyUserProfileLocalDataSource {

    boolean isOutdated(int userProfileID);

    boolean saveFitnessBuddyUserProfile(FitnessBuddyUserProfile fitnessBuddyUserProfile);

    boolean saveFitnessBuddyUserProfiles(List<FitnessBuddyUserProfile> fitnessBuddyUserProfiles);

    List<FitnessBuddyUserProfile> getAllUnrelatedFitnessBuddyUserProfile(int userProfileID);

    List<FitnessBuddyUserProfile> getFitnessBuddyUserProfiles(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID
    );

    boolean isOutdated(FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID);

}