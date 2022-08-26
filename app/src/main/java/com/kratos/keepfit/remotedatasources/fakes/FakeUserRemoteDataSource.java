package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.User;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake user remote data source implementation. Used for unit testing only. */
public class FakeUserRemoteDataSource implements UserRemoteDataSource {

    private final List<User> users;
    private final String mockPassword = "123456";

    /** Constructs a new instance. */
    @Inject
    public FakeUserRemoteDataSource() {
        users = new ArrayList<>();
        users.add(new User("example@gmail.com", "", new Date(), UserRole.Basic));
    }


    @Override
    public Result<UserRole> getUserRole() {
        return new Result.Success<>(UserRole.Basic);
    }

    @Override
    public Result<User> login(String email, String password) {
        for (User user : users){
            if (user.getEmail().equals(email) && mockPassword.equals(password)){
                User mockUser = new User(email,"18aeLk2828", new Date(), UserRole.Basic);
                return new Result.Success<>(mockUser);
            }
        }
        return new Result.Error<>(new Exception());
    }

    @Override
    public boolean generateEmailCOde(String email, EmailCodeType emailCodeType) {
        return true;
    }

    @Override
    public boolean register(String email, String password, String confirmPassword, String emailCode, String firstName) {
        users.add(new User(email, "", new Date(), UserRole.Basic));
        return true;
    }

    @Override
    public boolean resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode) {
        for (User user : users){
            if (user.getEmail().equals(email)){
                users.remove(user);
                users.add(new User(email, "", new Date(), UserRole.Basic));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        for (User user : users){
            if (user.getEmail().equals(email) && mockPassword.equals(currentPassword)){
                users.remove(user);
                users.add(new User(email, "", new Date(), UserRole.Basic));
                return true;
            }
        }
        return false;
    }
}
