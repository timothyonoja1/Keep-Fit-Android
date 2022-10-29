package com.kratos.keepfit.repositories.interfaces;

import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;

/** User repository interface. */
public interface UserRepository {

    /** Returns true to the callback if there's active login token.
     *  This should be called on the main thread.
     *  For other threads, call hasActiveLoginTokenSync() instead. */
    void hasActiveLoginToken(ResultCallback<Boolean> callback);

    /** Checks whether there is active login token. */
    boolean hasActiveLoginTokenSync();


    /** Returns true to the callback if login is successful.
     *  This should be called on the main thread.
     *  For other threads, call loginSync() instead. */
    void login(String email, String password, ResultCallback<Boolean> callback);

    /** Returns true if login is successful. */
    boolean loginSync(String email, String password);

    /** Returns true to the callback if otp is generated successfully.
     *  This should be called on the main thread.
     *  For other threads, call generateOtpSync() instead. */
    void generateEmailCode(String email, EmailCodeType emailCodeType, ResultCallback<Boolean> callback);

    /** Returns true if otp is generated successfully. */
    boolean generateEmailCodeSync(String email, EmailCodeType emailCodeType);

    /** Returns true to the callback if code is verified successfully.
     *  This should be called on the main thread.
     *  For other threads, call generateOtpSync() instead. */
    void verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType, ResultCallback<Boolean> callback);

    /** Returns true if code is verified successfully. */
    boolean verifyEmailCodeSync(String email, String emailCode, EmailCodeType emailCodeType);

    /** Returns true to the callback if user registration is successful.
     *  This should be called on the main thread.
     *  For other threads, call registerSync() instead. */
    void register(String email, String password, String confirmPassword, String emailCode, String firstName,
                  ResultCallback<Boolean> callback);

    /** Returns true if user registration is successful. */
    boolean registerSync(String email, String password, String confirmPassword, String emailCode, String firstName);

    /** Returns true to the callback if password reset is successful.
     *  This should be called on the main thread.
     *  For other threads, call resetPasswordSync() instead. */
    void resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode,
                       ResultCallback<Boolean> callback);

    /** Returns true if password reset is successful. */
    boolean resetPasswordSync(String email, String newPassword, String confirmNewPassword, String emailCode);

    /** Returns true to the callback if password change is successful.
     *  This should be called on the main thread.
     *  For other threads, call changePasswordSync() instead. */
    void changePassword(String email, String currentPassword, String newPassword,
                        String confirmNewPassword, ResultCallback<Boolean> callback);

    /** Returns true if password change is successful. */
    boolean changePasswordSync(String email, String currentPassword,
                               String newPassword, String confirmNewPassword);

    /** Returns logged in user profile to the callback if password change is successful.
     *  This should be called on the main thread.
     *  For other threads, call getLoggedInUserProfileSync() instead. */
    void getLoggedInUserProfile(ResultCallback<UserProfile> callback);

    /** Returns logged in user profile. */
    UserProfile getLoggedInUserProfileSync();

    /** Returns logged in user profile detail to the callback if password change is successful.
     *  This should be called on the main thread.
     *  For other threads, call getLoggedInUserSync() instead. */
    void getLoggedInUserProfileDetail(ResultCallback<UserProfileDetail> callback);

    /** Returns logged in user profile detail. */
    UserProfileDetail getLoggedInUserProfileDetailSync();

    boolean editUserProfileDetailSync(UserProfileDetail userProfileDetail);

    /** Returns true to the callback after logging out successfully.
     *  This should be called on the main thread.
     *  For other threads, call changePasswordSync() instead. */
    void logOut(ResultCallback<Boolean> callback);

    /** Returns true after logging out successfully. */
    boolean logOutSync();

}

