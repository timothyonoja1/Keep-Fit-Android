package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.User;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake User repository implementation class. Used for unit testing only. */
public class FakeUserRepository implements UserRepository {

    private final List<User> users;
    private final String mockPassword = "123456";

    /** Constructs a new instance. */
    @Inject
    public FakeUserRepository() {
        users = new ArrayList<>();
        users.add(new User("example@gmail.com", "", new Date(), UserRole.Basic));
    }

    @Override
    public void hasActiveLoginToken(ResultCallback<Boolean> callback) {
        callback.onComplete(hasActiveLoginTokenSync());
    }

    @Override
    public boolean hasActiveLoginTokenSync() {
        return false;
    }

    @Override
    public void login(String email, String password, ResultCallback<Boolean> callback) {
        callback.onComplete(loginSync(email, password));
    }

    @Override
    public boolean loginSync(String email, String password) {
        for (User user : users){
            if (user.getEmail().equals(email) && mockPassword.equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void generateEmailCode(String email, EmailCodeType emailCodeType, ResultCallback<Boolean> callback) {
        callback.onComplete(generateEmailCodeSync(email, emailCodeType));
    }

    @Override
    public boolean generateEmailCodeSync(String email, EmailCodeType emailCodeType) {
        return true;
    }

    @Override
    public void verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType, ResultCallback<Boolean> callback) {
        callback.onComplete(verifyEmailCodeSync(email, emailCode, emailCodeType));
    }

    @Override
    public boolean verifyEmailCodeSync(String email, String emailCode, EmailCodeType emailCodeType) {
        return true;
    }

    @Override
    public void register(String email, String password, String confirmPassword, String emailCode,
             String firstName, ResultCallback<Boolean> callback) {
        callback.onComplete(registerSync(email, password, confirmPassword, emailCode, firstName));
    }

    @Override
    public boolean registerSync(String email, String password, String confirmPassword, String emailCode, String firstName) {
        users.add(new User(email, "", new Date(), UserRole.Basic));
        return true;
    }

    @Override
    public void resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode, ResultCallback<Boolean> callback) {
        callback.onComplete(resetPasswordSync(email, newPassword, confirmNewPassword, emailCode));
    }

    @Override
    public boolean resetPasswordSync(String email, String newPassword, String confirmNewPassword, String emailCode) {
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
    public void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword, ResultCallback<Boolean> callback) {
        callback.onComplete(changePasswordSync(email, currentPassword, newPassword, confirmNewPassword));
    }

    @Override
    public boolean changePasswordSync(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        for (User user : users){
            if (user.getEmail().equals(email) && mockPassword.equals(currentPassword)){
                users.remove(user);
                users.add(new User(email, "", new Date(), UserRole.Basic));
                return true;
            }
        }
        return false;
    }

    @Override
    public void getLoggedInUser(ResultCallback<User> callback) {
        callback.onComplete(getLoggedInUserSync());
    }

    @Override
    public User getLoggedInUserSync() {
        return users.get(0);
    }

    @Override
    public void logOut(ResultCallback<Boolean> callback) {
        callback.onComplete(logOutSync());
    }

    @Override
    public boolean logOutSync() {
        users.clear();
        return true;
    }
}