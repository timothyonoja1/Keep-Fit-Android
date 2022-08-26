package com.kratos.keepfit.utilities.interfaces;

/** Validation utility interface. */
public interface ValidationUtility {

    /** Checks whether the email is valid. */
    boolean isNotValidEmail(String email);

    /** Checks whether the password is valid. */
    boolean isNotValidPassword(String password);

    /** Checks whether the email code is valid. */
    boolean isNotValidEmailCode(String emailCode);

}