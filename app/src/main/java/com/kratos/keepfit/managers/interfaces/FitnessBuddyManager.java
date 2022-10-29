package com.kratos.keepfit.managers.interfaces;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import java.util.List;

public interface FitnessBuddyManager {

    boolean addFitnessBuddy(int fitnessBuddyID, int userProfileID);

    List<FitnessBuddy> getAllUnrelatedFitnessBuddies(int userProfileID);

    List<FitnessBuddy> getFitnessBuddies(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID
    );

}
