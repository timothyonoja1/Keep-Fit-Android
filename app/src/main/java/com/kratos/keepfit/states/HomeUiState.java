package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;

public class HomeUiState {
    private final String appropriateGreeting;
    private final boolean fetchingUiState;
    private final UserProfile userProfile;
    private final UserProfileDetail userProfileDetail;
    private final String numberOfFitnessProgrammes;

    public HomeUiState(String appropriateGreeting, boolean fetchingUiState, UserProfile userProfile,
                       UserProfileDetail userProfileDetail, String numberOfFitnessProgrammes) {
        this.appropriateGreeting = appropriateGreeting;
        this.fetchingUiState = fetchingUiState;
        this.userProfile = userProfile;
        this.userProfileDetail = userProfileDetail;
        this.numberOfFitnessProgrammes = numberOfFitnessProgrammes;
    }

    public String getAppropriateGreeting() {
        return appropriateGreeting;
    }

    public boolean isFetchingUiState() {
        return fetchingUiState;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public UserProfileDetail getUserProfileDetail() {
        return userProfileDetail;
    }

    public String getNumberOfFitnessProgrammes() {
        return numberOfFitnessProgrammes;
    }

}