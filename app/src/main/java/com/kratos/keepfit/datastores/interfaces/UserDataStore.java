package com.kratos.keepfit.datastores.interfaces;

import com.kratos.keepfit.entities.User;

/** Data Store interface for users. */
public interface UserDataStore {

    /** Checks whether there's active login token. */
    boolean hasActiveLoginToken();

    /** Returns true after saving user successfully.
     * If a user already exists in the datastore, it replaces it. */
    boolean saveUser(User user);

    /** Returns loggedIn user. */
    User getLoggedInUser();

    /** Returns true after deleting logged in user successfully. */
    boolean deleteLoggedInUser();

}