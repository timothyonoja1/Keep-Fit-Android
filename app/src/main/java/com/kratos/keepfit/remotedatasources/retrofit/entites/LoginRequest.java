package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("grant_type")
    private final String grantType = "password";

    @SerializedName("username")
    private final String userName;

    @SerializedName("password")
    private final String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}