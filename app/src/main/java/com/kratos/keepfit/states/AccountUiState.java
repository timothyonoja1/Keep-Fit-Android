package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import java.util.List;

public class AccountUiState {

    private final boolean fetchingAccountUiState;
    private final UserProfile userProfile;
    private final UserProfileDetail userProfileDetail;
    private final List<Speciality> specialities;
    private final List<Gallery> galleries;
    private final List<Schedule> schedules;

    public AccountUiState(boolean fetchingAccountUiState, UserProfile userProfile,
                          UserProfileDetail userProfileDetail, List<Speciality> specialities,
                          List<Gallery> galleries, List<Schedule> schedules) {
        this.fetchingAccountUiState = fetchingAccountUiState;
        this.userProfile = userProfile;
        this.userProfileDetail = userProfileDetail;
        this.specialities = specialities;
        this.galleries = galleries;
        this.schedules = schedules;
    }

    public boolean isFetchingAccountUiState() {
        return fetchingAccountUiState;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public UserProfileDetail getUserProfileDetail() {
        return userProfileDetail;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
