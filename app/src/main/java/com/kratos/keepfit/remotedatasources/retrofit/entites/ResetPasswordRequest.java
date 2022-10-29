package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;

public class ResetPasswordRequest {

    @SerializedName("Email")
    private final String email;

    @SerializedName("Password")
    private final String password;

    @SerializedName("ConfirmPassword")
    private final String confirmPassword;

    @SerializedName("EmailCode")
    private final String emailCode;

    public ResetPasswordRequest(String email, String password,
                                String confirmPassword, String emailCode) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.emailCode = emailCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmailCode() {
        return emailCode;
    }
}
