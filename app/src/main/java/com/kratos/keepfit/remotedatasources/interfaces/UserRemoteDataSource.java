package com.kratos.keepfit.remotedatasources.interfaces;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.User;
import com.kratos.keepfit.entities.UserRole;

/** User remote data source interface. */
public interface UserRemoteDataSource {

    /** Returns user role response after successful login. */
    Result<UserRole> getUserRole();

    /** Returns user response after successful login. */
    Result<User> login(String email, String password);

    /** Returns true after generating email code successfully. */
    boolean generateEmailCOde(String email, EmailCodeType emailCodeType);

    /** Returns true after successful user registration. */
    boolean register(String email, String password, String confirmPassword,
                     String emailCode, String firstName);

    /** Returns true after successful password reset. */
    boolean resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode);

    /** Returns true after successful password change. */
    boolean changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword);

}
