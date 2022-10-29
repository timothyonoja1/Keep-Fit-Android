package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;
import com.kratos.keepfit.entities.EmailCodeType;

public class VerfiyEmailCodeRequest extends EmailCodeRequest {

    @SerializedName("EmailCode")
    private final String emailCode;

    public VerfiyEmailCodeRequest(String email, EmailCodeType emailCodeType, String emailCode) {
        super(email, emailCodeType);
        this.emailCode = emailCode;
    }

    public String getEmailCode() {
        return emailCode;
    }
}