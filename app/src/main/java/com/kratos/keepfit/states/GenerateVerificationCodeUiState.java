package com.kratos.keepfit.states;

public class GenerateVerificationCodeUiState extends AuthenticationUiState{

    /** Constructs a new instance. */
    public GenerateVerificationCodeUiState(AuthenticationUiStatus authenticationUiStatus, String errorMessage) {
        super(authenticationUiStatus, errorMessage);
    }

}
