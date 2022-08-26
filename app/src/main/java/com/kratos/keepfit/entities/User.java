package com.kratos.keepfit.entities;

import java.util.Date;

/** User entity class. */
public class User {

    private final String email;
    private final String loginToken;
    private final Date loginTokenExpiryDate;
    private final UserRole userRole;

    public User(String email, String loginToken, Date loginTokenExpiryDate, UserRole userRole) {
        this.email = email;
        this.loginToken = loginToken;
        this.loginTokenExpiryDate = loginTokenExpiryDate;
        this.userRole = userRole;
    }

    /** Returns user email. */
    public String getEmail() {
        return email;
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