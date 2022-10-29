package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;
import com.kratos.keepfit.entities.EmailCodeType;

public class EmailCodeRequest {

    @SerializedName("Email")
    private final String email;

    @SerializedName("EmailCodeType")
    private final EmailCodeType emailCodeType;

    public EmailCodeRequest(String email, EmailCodeType emailCodeType) {
        this.email = email;
        this.emailCodeType = emailCodeType;
    }

    public String getEmail() {
        return email;
    }

    public EmailCodeType getEmailCodeType() {
        return emailCodeType;
    }
}