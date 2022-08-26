package com.kratos.keepfit.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.kratos.keepfit.states.AuthenticationUiState;
import com.kratos.keepfit.states.EmailVerificationCodeUiState;
import com.kratos.keepfit.states.GenerateVerificationCodeUiState;

/** State holder interface for the authentication UI screens. */
public interface AuthenticationViewModel {

    /** Returns LoginUiState. */
    MutableLiveData<AuthenticationUiState> getLoginUiState();

    /** Returns VerificationUiState. */
    MutableLiveData<GenerateVerificationCodeUiState> getGenerateVerificationCodeUiState();

    /** Returns GenerateUiState. */
    MutableLiveData<AuthenticationUiState> getRegistrationUiState();

    /** Returns EmailVerificationCodeUiState. */
    MutableLiveData<AuthenticationUiState> getEmailVerificationCodeUiState();

    /** Returns ResetPasswordUiState. */
    MutableLiveData<AuthenticationUiState> getResetPasswordUiState();

    /** Returns ChangePasswordUiState. */
    MutableLiveData<AuthenticationUiState> getChangePasswordUiState();

    /** Attempts to login user. */
    void login(String email, String password);

    void generateVerificationCode(String email, String password, String confirmPassword, String firstName);

    /** Attempts to register user. */
    void register(String emailCode);

    /** Attempts to verify email code. */
    void verifyEmailCode(String emailCode);

    /** Attempts to reset password. */
    void resetPassword(String newPassword, String confirmNewPassword);

    /** Attempts to change password */
    void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword);

}
