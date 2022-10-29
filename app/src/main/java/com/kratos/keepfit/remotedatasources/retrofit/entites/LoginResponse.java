package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("access_token")
    private final String accessToken;

    @SerializedName("userName")
    private final String userName;

    @SerializedName(".expires")
    private final String expiryDate;

    public LoginResponse(String accessToken, String userName, String expiryDate) {
        this.accessToken = accessToken;
        this.userName = userName;
        this.expiryDate = expiryDate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}