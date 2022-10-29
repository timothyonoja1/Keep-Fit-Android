package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;

/** User remote data source interface. */
public interface UserRemoteDataSource {

    /** Returns user response after successful login. */
    Result<UserProfile> login(String email, String password);

    /** Returns user response after successful login. */
    Result<UserProfileDetail> getUserProfileDetail(int userProfileID);

    Result<UserProfileDetail> postUserProfileDetail(UserProfileDetail userProfileDetail);

    Result<UserProfileDetail> editUserProfileDetail(UserProfileDetail userProfileDetail);

    /** Returns true after generating email code successfully. */
    boolean generateEmailCode(String email, EmailCodeType emailCodeType);

    /** Returns true after verifying email code successfully. */
    boolean verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType);

    /** Returns true after successful user registration. */
    boolean register(String email, String password, String confirmPassword,
                     String emailCode, String firstName);

    /** Returns true after successful password reset. */
    boolean resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode);

    /** Returns true after successful password change. */
    boolean changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword);

}
