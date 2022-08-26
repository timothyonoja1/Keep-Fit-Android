package com.kratos.keepfit.states;

public class EmailVerificationCodeUiState extends AuthenticationUiState{


    /** Constructs a new instance. */
    public EmailVerificationCodeUiState(AuthenticationUiStatus authenticationUiStatus, String errorMessage) {
        super(authenticationUiStatus, errorMessage);
    }

}
