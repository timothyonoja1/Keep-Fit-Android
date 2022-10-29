package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("Email")
    private final String email;

    @SerializedName("Password")
    private final String password;

    @SerializedName("ConfirmPassword")
    private final String confirmPassword;

    @SerializedName("FirstName")
    private final String firstName;

    @SerializedName("EmailCode")
    private final String emailCode;

    public RegisterRequest(String email, String password,
                           String confirmPassword, String firstName, String emailCode) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
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

    public String getFirstName() {
        return firstName;
    }

    public String getEmailCode() {
        return emailCode;
    }
}