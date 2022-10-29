package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.entities.FitnessBuddyUserProfile;
import java.util.List;

public interface FitnessBuddyUserProfileRemoteDataSource {

    FitnessBuddyUserProfile addFitnessBuddy(int fitnessBuddyID, int userProfileID);

    List<FitnessBuddyUserProfile> getAllUnrelatedFitnessBuddyUserProfiles(int userProfileID);

    List<FitnessBuddyUserProfile> getFitnessBuddyUserProfiles(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID
    );

}