package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;

public class ProfileUiState {
    private final boolean fetchingUiState;
    private final String skillLevel;
    private final UserProfile userProfile;
    private final UserProfileDetail userProfileDetail;
    private final boolean loggedOut;

    public ProfileUiState(boolean fetchingUiState,
                          String skillLevel, UserProfile userProfile,
                          UserProfileDetail userProfileDetail,
                          boolean loggedOut) {
        this.fetchingUiState = fetchingUiState;
        this.skillLevel = skillLevel;
        this.userProfile = userProfile;
        this.userProfileDetail = userProfileDetail;
        this.loggedOut = loggedOut;
    }

    public boolean isFetchingUiState() {
        return fetchingUiState;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public UserProfileDetail getUserProfileDetail() {
        return userProfileDetail;
    }

    public boolean isLoggedOut() {
        return loggedOut;
    }
}