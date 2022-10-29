package com.kratos.keepfit.datastores.interfaces;

import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;

/** Data Store interface for users. */
public interface UserDataStore {

    /** Checks whether there's active login token. */
    boolean hasActiveLoginToken();

    /** Returns true after saving user successfully.
     * If a user profile already exists in the datastore, it replaces it. */
    boolean saveUserProfile(UserProfile userProfile);

    /** Returns loggedIn user profile. */
    UserProfile getLoggedInUserProfile();

    /** Returns true after deleting logged in user profile successfully. */
    boolean deleteLoggedInUser();

    /** Returns true after saving user profile detail successfully.
     * If a user profile detail already exists in the datastore, it replaces it. */
    boolean saveUserProfileDetail(UserProfileDetail userProfileDetail);

    boolean editUserProfileDetail(UserProfileDetail userProfileDetail);

    /** Returns loggedIn user profile detail. */
    UserProfileDetail getLoggedInUserProfileDetail();

    /** Returns true after deleting logged in user profile detail successfully. */
    boolean deleteLoggedInUserProfileDetail();

}
