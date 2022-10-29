package com.kratos.keepfit.repositories.fakes;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake User repository implementation class. Used for unit testing only. */
public class FakeUserRepository implements UserRepository {

    private final List<UserProfile> userProfiles;
    private final List<UserProfileDetail> userProfileDetails;
    private final String mockPassword = "123456";

    /** Constructs a new instance. */
    @Inject
    public FakeUserRepository() {
        userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(
                1, "example@gmail.com", "Daniel", "", new Date(), UserRole.Basic));
        userProfileDetails = new ArrayList<>();
        userProfileDetails.add(new UserProfileDetail(
                1, 25, Gender.Male, 280, 80, null,
                "Ondo City", "dp_image.jpg", "https://www.facebook.com/dp_image.jpg", 0, false,
                0, 1, 1, 1, 1, 1,
                1));
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
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email) && mockPassword.equals(password)){
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
        userProfiles.add(new UserProfile(1, email, firstName, "", new Date(), UserRole.Basic));
        return true;
    }

    @Override
    public void resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode, ResultCallback<Boolean> callback) {
        callback.onComplete(resetPasswordSync(email, newPassword, confirmNewPassword, emailCode));
    }

    @Override
    public boolean resetPasswordSync(String email, String newPassword, String confirmNewPassword, String emailCode) {
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email)){
                userProfiles.remove(userProfile);
                userProfiles.add(new UserProfile(1, email, "Daniel", "", new Date(), UserRole.Basic));
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
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email) && mockPassword.equals(currentPassword)){
                userProfiles.remove(userProfile);
                userProfiles.add(new UserProfile(1, email, "Daniel", "", new Date(), UserRole.Basic));
                return true;
            }
        }
        return false;
    }

    @Override
    public void getLoggedInUserProfile(ResultCallback<UserProfile> callback) {
        callback.onComplete(getLoggedInUserProfileSync());
    }

    @Override
    public UserProfile getLoggedInUserProfileSync() {
        return userProfiles.get(0);
    }

    @Override
    public void getLoggedInUserProfileDetail(ResultCallback<UserProfileDetail> callback) {
        callback.onComplete(getLoggedInUserProfileDetailSync());
    }

    @Override
    public UserProfileDetail getLoggedInUserProfileDetailSync() {
        return userProfileDetails.get(0);
    }

    @Override
    public boolean editUserProfileDetailSync(UserProfileDetail userProfileDetail) {
        userProfileDetails.clear();
        userProfileDetails.add(userProfileDetail);
        return true;
    }

    @Override
    public void logOut(ResultCallback<Boolean> callback) {
        callback.onComplete(logOutSync());
    }

    @Override
    public boolean logOutSync() {
        userProfiles.clear();
        return true;
    }
}