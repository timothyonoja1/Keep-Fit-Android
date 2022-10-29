package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake user data store implementation. Used for unit testing only. */
public class FakeUserDataStore implements UserDataStore {

    private final List<UserProfile> userProfiles;
    private final List<UserProfileDetail> userProfileDetails;

    /** Constructs a new instance. */
    @Inject
    public FakeUserDataStore() {
        userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(
                1, "example@gmail.com", "Daniel", "", new Date(), UserRole.Basic));
        userProfileDetails = new ArrayList<>();
        userProfileDetails.add(new UserProfileDetail(
                1, 25, Gender.Male, 280, 80, null,
                "Ondo City", "https://www.facebook.com/dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 0, false, 0, 1,
                1, 1, 1, 1, 1));
    }

    @Override
    public boolean hasActiveLoginToken() {
        return false;
    }

    @Override
    public boolean saveUserProfile(UserProfile userProfile) {
        userProfiles.clear();
        return userProfiles.add(userProfile);
    }

    @Override
    public UserProfile getLoggedInUserProfile() {
        return userProfiles.get(0);
    }

    @Override
    public boolean deleteLoggedInUser() {
        userProfiles.clear();
        return true;
    }

    @Override
    public boolean saveUserProfileDetail(UserProfileDetail userProfileDetail) {
        userProfileDetails.clear();
        return userProfileDetails.add(userProfileDetail);
    }

    @Override
    public boolean editUserProfileDetail(UserProfileDetail userProfileDetail) {
        userProfileDetails.clear();
        userProfileDetails.add(userProfileDetail);
        return true;
    }

    @Override
    public UserProfileDetail getLoggedInUserProfileDetail() {
        return userProfileDetails.get(0);
    }

    @Override
    public boolean deleteLoggedInUserProfileDetail() {
        userProfileDetails.clear();
        return true;
    }
}