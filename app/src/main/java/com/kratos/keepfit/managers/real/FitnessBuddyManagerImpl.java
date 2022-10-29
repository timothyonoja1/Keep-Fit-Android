package com.kratos.keepfit.managers.real;

import com.kratos.keepfit.entities.FitnessBuddy;
import com.kratos.keepfit.entities.FitnessBuddyRequestStatus;
import com.kratos.keepfit.managers.interfaces.FitnessBuddyManager;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyRepository;
import com.kratos.keepfit.repositories.interfaces.FitnessBuddyUserProfileRepository;
import java.util.List;
import javax.inject.Inject;

public class FitnessBuddyManagerImpl implements FitnessBuddyManager {

    private final FitnessBuddyRepository fitnessBuddyRepository;
    private final FitnessBuddyUserProfileRepository fitnessBuddyUserProfileRepository;

    @Inject
    public FitnessBuddyManagerImpl(FitnessBuddyRepository fitnessBuddyRepository,
                                   FitnessBuddyUserProfileRepository fitnessBuddyUserProfileRepository) {
        this.fitnessBuddyRepository = fitnessBuddyRepository;
        this.fitnessBuddyUserProfileRepository = fitnessBuddyUserProfileRepository;
    }

    @Override
    public boolean addFitnessBuddy(int fitnessBuddyID, int userProfileID) {
        return fitnessBuddyUserProfileRepository.addFitnessBuddy(fitnessBuddyID, userProfileID);
    }

    @Override
    public List<FitnessBuddy> getAllUnrelatedFitnessBuddies(int userProfileID) {
        List<Integer> fitnessBuddyIDs
                = fitnessBuddyUserProfileRepository.getAllUnrelatedFitnessBuddyIDs(userProfileID);
        return fitnessBuddyRepository.getFitnessBuddies(fitnessBuddyIDs);
    }

    @Override
    public List<FitnessBuddy> getFitnessBuddies(
            FitnessBuddyRequestStatus fitnessBuddyRequestStatus, int userProfileID) {
        List<Integer> fitnessBuddyIDs = fitnessBuddyUserProfileRepository
                .getFitnessBuddyIDs(fitnessBuddyRequestStatus, userProfileID);
        return fitnessBuddyRepository.getFitnessBuddies(fitnessBuddyIDs);
    }
}