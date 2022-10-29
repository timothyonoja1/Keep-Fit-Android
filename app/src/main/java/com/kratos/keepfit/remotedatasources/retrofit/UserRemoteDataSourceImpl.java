package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import com.kratos.keepfit.remotedatasources.retrofit.entites.ChangePasswordRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.EmailCodeRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.LoginRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.LoginResponse;
import com.kratos.keepfit.remotedatasources.retrofit.entites.RegisterRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.ResetPasswordRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.UserProfileResponse;
import com.kratos.keepfit.remotedatasources.retrofit.entites.VerfiyEmailCodeRequest;
import java.util.Date;
import javax.inject.Inject;
import retrofit2.Call;

public class UserRemoteDataSourceImpl implements UserRemoteDataSource {

    private final AuthenticationService authenticationService;

    @Inject
    public UserRemoteDataSourceImpl(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Result<UserProfile> login(String email, String password) {
        Call<LoginResponse> loginApiCall = authenticationService.login(
                new LoginRequest(email, password));
        LoginResponse loginResponse;
        try {
            loginResponse = loginApiCall.execute().body();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Result.Error<>(new Exception());
        }

        Call<UserProfileResponse> userProfileCall = authenticationService.getUserProfile(email);
        UserProfileResponse userProfileResponse;
        try {
            userProfileResponse = userProfileCall.execute().body();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Result.Error<>(new Exception());
        }
        if (loginResponse == null || userProfileResponse == null) {
            return new Result.Error<>(new Exception());
        }

        return new Result.Success<>(new UserProfile(
                userProfileResponse.getUserProfileID(), userProfileResponse.getEmail(),
                userProfileResponse.getFirstName(), loginResponse.getAccessToken(),
                new Date(), userProfileResponse.getUserRole()));
    }

    @Override
    public Result<UserProfileDetail> getUserProfileDetail(int userProfileID) {
        Call<UserProfileDetail> userProfileDetailCall
                = authenticationService.getUserProfileDetail(userProfileID);
        try {
            UserProfileDetail userProfileDetail = userProfileDetailCall.execute().body();
            return new Result.Success<>(userProfileDetail);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Result.Error<>(new Exception());
        }
    }

    @Override
    public Result<UserProfileDetail> postUserProfileDetail(UserProfileDetail userProfileDetail) {
        Call<UserProfileDetail> userProfileDetailCall
                = authenticationService.postUserProfileDetail(userProfileDetail);
        try {
            UserProfileDetail result = userProfileDetailCall.execute().body();
            return new Result.Success<>(result);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Result.Error<>(new Exception());
        }
    }

    @Override
    public Result<UserProfileDetail> editUserProfileDetail(UserProfileDetail userProfileDetail) {
        Call<UserProfileDetail> userProfileDetailCall
                = authenticationService.putUserProfileDetail(userProfileDetail.getUserProfileID(), userProfileDetail);
        try {
            UserProfileDetail result = userProfileDetailCall.execute().body();
            return new Result.Success<>(result);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new Result.Error<>(new Exception());
        }
    }

    @Override
    public boolean generateEmailCode(String email, EmailCodeType emailCodeType) {
        Call<Boolean> apiCall = authenticationService.generateEmailCode(
                new EmailCodeRequest(email, emailCodeType));
        return executeBooleanRequest(apiCall);
    }

    @Override
    public boolean verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType) {
        Call<Boolean> apiCall = authenticationService.verifyEmailCode(
                new VerfiyEmailCodeRequest(email, emailCodeType, emailCode));
        return executeBooleanRequest(apiCall);
    }

    @Override
    public boolean register(String email, String password, String confirmPassword,
                            String emailCode, String firstName) {
        Call<Boolean> apiCall = authenticationService.register(
                new RegisterRequest(email, password, confirmPassword, firstName, emailCode));
        return executeBooleanRequest(apiCall);
    }

    @Override
    public boolean resetPassword(String email, String newPassword, String confirmNewPassword,
                                 String emailCode) {
        Call<Boolean> apiCall = authenticationService.resetPassword(
                new ResetPasswordRequest(email, newPassword, confirmNewPassword, emailCode));
        return executeBooleanRequest(apiCall);
    }

    @Override
    public boolean changePassword(String email, String currentPassword, String newPassword,
                                  String confirmNewPassword) {
        Call<Boolean> apiCall = authenticationService.changePassword(
                new ChangePasswordRequest(currentPassword, newPassword, confirmNewPassword));
        return executeBooleanRequest(apiCall);
    }

    private boolean executeBooleanRequest(Call<Boolean> apiCall) {
        try {
            Boolean result = apiCall.execute().body();
            if (result == null) {
                return false;
            }
            return result;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
