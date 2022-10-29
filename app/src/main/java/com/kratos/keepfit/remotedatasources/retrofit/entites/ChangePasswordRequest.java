package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest {

    @SerializedName("OldPassword")
    private final String oldPassword;

    @SerializedName("NewPassword")
    private final String newPassword;

    @SerializedName("ConfirmNewPassword")
    private final String confirmNewPassword;

    public ChangePasswordRequest(String oldPassword, String newPassword, String confirmNewPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
}