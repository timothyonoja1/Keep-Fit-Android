package com.kratos.keepfit.remotedatasources.retrofit.entites;

import com.google.gson.annotations.SerializedName;
import com.kratos.keepfit.entities.UserRole;

public class UserProfileResponse {

    @SerializedName("UserProfileID")
    private final int userProfileID;

    @SerializedName("Email")
    private final String email;

    @SerializedName("FirstName")
    private final String firstName;

    @SerializedName("UserRole")
    private final UserRole userRole;

    public UserProfileResponse(int userProfileID, String email,
                               String firstName, UserRole userRole) {
        this.userProfileID = userProfileID;
        this.email = email;
        this.firstName = firstName;
        this.userRole = userRole;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}