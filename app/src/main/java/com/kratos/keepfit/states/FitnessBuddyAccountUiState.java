package com.kratos.keepfit.states;

import com.kratos.keepfit.entities.Comment;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import java.util.List;

public class FitnessBuddyAccountUiState extends AccountUiState{

    private final List<Comment> comments;

    public FitnessBuddyAccountUiState(
            boolean fetchingAccountUiState, UserProfile userProfile,
            UserProfileDetail userProfileDetail, List<Speciality> specialities,
            List<Gallery> galleries, List<Schedule> schedules, List<Comment> comments) {
        super(fetchingAccountUiState, userProfile, userProfileDetail, specialities, galleries, schedules);
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}