package com.kratos.keepfit.remotedatasources.retrofit;

import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.remotedatasources.retrofit.entites.ChangePasswordRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.EmailCodeRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.LoginRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.LoginResponse;
import com.kratos.keepfit.remotedatasources.retrofit.entites.RegisterRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.ResetPasswordRequest;
import com.kratos.keepfit.remotedatasources.retrofit.entites.UserProfileResponse;
import com.kratos.keepfit.remotedatasources.retrofit.entites.VerfiyEmailCodeRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AuthenticationService {

    @POST("/Token")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("api/UserProfileDetails/{id}")
    Call<UserProfileResponse> getUserProfile(@Path("id") String email);

    @GET("api/UserProfileDetails/{id}")
    Call<UserProfileDetail> getUserProfileDetail(@Path("id") int userProfileID);

    @POST("api/UserProfileDetails")
    Call<UserProfileDetail> postUserProfileDetail(@Body UserProfileDetail userProfileDetail);

    @PUT("api/UserProfileDetails/{id}")
    Call<UserProfileDetail> putUserProfileDetail(
            @Path("id") int userProfileID, @Body UserProfileDetail userProfileDetail);

    @POST("api/EmailCodes")
    Call<Boolean> generateEmailCode(@Body EmailCodeRequest emailCodeRequest);

    @POST("api/EmailCodes")
    Call<Boolean>  verifyEmailCode(@Body VerfiyEmailCodeRequest verfiyEmailCodeRequest);

    @POST("api/Account/Register")
    Call<Boolean> register(@Body RegisterRequest registerRequest);

    @POST("api/Account/ResetPassword")
    Call<Boolean> resetPassword(@Body ResetPasswordRequest resetPasswordRequest);

    @POST("api/Account/changePassword")
    Call<Boolean> changePassword(@Body ChangePasswordRequest changePasswordRequest);

}
