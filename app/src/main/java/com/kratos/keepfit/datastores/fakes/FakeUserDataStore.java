package com.kratos.keepfit.datastores.fakes;

import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.User;
import com.kratos.keepfit.entities.UserRole;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake user data store implementation. Used for unit testing only. */
public class FakeUserDataStore implements UserDataStore {

    private final List<User> users;

    /** Constructs a new instance. */
    @Inject
    public FakeUserDataStore() {
        users = new ArrayList<>();
        users.add(new User("example@gmail.com", "", new Date(), UserRole.Basic));
    }

    @Override
    public boolean hasActiveLoginToken() {
        return false;
    }

    @Override
    public boolean saveUser(User user) {
        users.clear();
        return users.add(user);
    }

    @Override
    public User getLoggedInUser() {
        return users.get(0);
    }

    @Override
    public boolean deleteLoggedInUser() {
        users.clear();
        return true;
    }
}