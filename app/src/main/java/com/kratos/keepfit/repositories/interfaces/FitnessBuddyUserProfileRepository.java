package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import java.util.List;

public interface FitnessBuddyUserProfileRepository {

    boolean addFitnessBuddy(int fitnessBuddyID, int userProfileID);

    List<Integer> getAllUnrelatedFitnessBuddyIDs(int userProfileID);

    List<Integer> getFitnessBuddyIDs(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID
    );

}