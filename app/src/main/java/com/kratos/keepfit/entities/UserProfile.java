package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

/** User entity class. */
@Entity
public class UserProfile {

    private final int userProfileID;
    private final String email;
    private final String firstname;
    private final String loginToken;
    private final Date loginTokenExpiryDate;
    private final UserRole userRole;

    public UserProfile(int userProfileID, String email,
                       String firstname, String loginToken,
                       Date loginTokenExpiryDate, UserRole userRole) {
        this.userProfileID = userProfileID;
        this.email = email;
        this.firstname = firstname;
        this.loginToken = loginToken;
        this.loginTokenExpiryDate = loginTokenExpiryDate;
        this.userRole = userRole;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    /** Returns user email. */
    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    /** Returns loginToken. */
    public String getLoginToken() {
        return loginToken;
    }

    /** Returns loginTokenExpiryDate. */
    public Date getLoginTokenExpiryDate() {
        return loginTokenExpiryDate;
    }

    /** Returns user's role. */
    public UserRole getUserRole() {
        return userRole;
    }

}