package com.kratos.keepfit.states;

/** Different authentication ui status*/
public enum AuthenticationUiStatus {

    /** Indicates that the app is currently doing nothing */
    Idle,

    /** Indicates that the app is currently generating email code. */
    GeneratingCode,

    /** Indicates that email code was successfully generated.  */
    CodeGeneratedSuccessfully,

    /** Indicates that the app is currently verifying email code. */
    VerifyingCode,

    /** Indicates successful email code verification. */
    CodeVerificationSuccessful,

    /** Indicates that the app is currently logging in a user. */
    LoggingIn,

    /** Indicates successful login. */
    LoginSuccessful,

    /** Indicates that the app is currently registering a user. */
    Registering,

    /** Indicates successful user registration. */
    RegistrationSuccessful,

    /** Indicates that the app is currently resetting a password. */
    ResettingPassword,

    /** Indicates successful password reset. */
    ResetPasswordSuccessful,

    /** Indicates that the app is currently changing a password. */
    ChangingPassword,

    /** Indicates successful password change. */
    ChangePasswordSuccessful,

    /** Indicates invalid input. */
    InvalidInput,

    /** Indicates failure */
    Failure
}

