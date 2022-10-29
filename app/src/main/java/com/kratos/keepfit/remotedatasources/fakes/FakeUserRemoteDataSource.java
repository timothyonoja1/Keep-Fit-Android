package com.kratos.keepfit.remotedatasources.fakes;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/** Fake user remote data source implementation. Used for unit testing only. */
public class FakeUserRemoteDataSource implements UserRemoteDataSource {

    private final List<UserProfile> userProfiles;
    private final List<UserProfileDetail> userProfileDetails;
    private String mockPassword = "123456";

    /** Constructs a new instance. */
    @Inject
    public FakeUserRemoteDataSource() {
        userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(1, "example@gmail.com",
                "Daniel", "", new Date(), UserRole.Basic));
        userProfileDetails = new ArrayList<>();
        userProfileDetails.add(new UserProfileDetail(
                1, 25, Gender.Male, 280, 80, null,
                "Ondo City", "https://www.facebook.com/dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 0, false, 0, 1,
                1, 1, 1, 1, 1));
    }

    @Override
    public Result<UserProfile> login(String email, String password) {
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email) && mockPassword.equals(password)){
                return new Result.Success<>(userProfiles.get(0));
            }
        }
        return new Result.Error<>(new Exception());
    }

    @Override
    public Result<UserProfileDetail> getUserProfileDetail(int userProfileID) {
        return new Result.Success<>(userProfileDetails.get(0));
    }

    @Override
    public Result<UserProfileDetail> postUserProfileDetail(UserProfileDetail userProfileDetail) {
        userProfileDetails.clear();
        userProfileDetails.add(userProfileDetail);
        return new Result.Success<>(userProfileDetail);
    }

    @Override
    public Result<UserProfileDetail> editUserProfileDetail(UserProfileDetail userProfileDetail) {
        this.userProfileDetails.clear();
        this.userProfileDetails.add(userProfileDetail);
        return new Result.Success<>(userProfileDetail);
    }

    @Override
    public boolean generateEmailCode(String email, EmailCodeType emailCodeType) {
        return true;
    }

    @Override
    public boolean verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType) {
        return true;
    }

    @Override
    public boolean register(String email, String password, String confirmPassword, String emailCode, String firstName) {
        userProfiles.clear();
        mockPassword = password;
        userProfiles.add(new UserProfile(1, email, firstName, "", new Date(), UserRole.Basic));
        return true;
    }

    @Override
    public boolean resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode) {
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email)){
                mockPassword = newPassword;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        for (UserProfile userProfile : userProfiles){
            if (userProfile.getEmail().equals(email) && mockPassword.equals(currentPassword)){
                mockPassword = newPassword;
                return true;
            }
        }
        return false;
    }
}
