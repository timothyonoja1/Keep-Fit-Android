package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kratos.keepfit.states.AuthenticationUiState;
import com.kratos.keepfit.states.AuthenticationUiStatus;
import com.kratos.keepfit.states.ChangePasswordUiState;
import com.kratos.keepfit.states.EmailVerificationCodeUiState;
import com.kratos.keepfit.states.GenerateVerificationCodeUiState;
import com.kratos.keepfit.states.LoginUiState;
import com.kratos.keepfit.states.RegistrationUiState;
import com.kratos.keepfit.states.ResetPasswordUiState;
import com.kratos.keepfit.viewmodels.interfaces.AuthenticationViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake AuthenticationViewModel implementation class. */
@HiltViewModel
public class FakeAuthenticationViewModel extends ViewModel implements AuthenticationViewModel {

    private final MutableLiveData<AuthenticationUiState> loginUiState = new MutableLiveData<>();
    private final MutableLiveData<GenerateVerificationCodeUiState> generateVerificationCodeUiState = new MutableLiveData<>();
    private final MutableLiveData<AuthenticationUiState> registrationUiState = new MutableLiveData<>();
    private final MutableLiveData<AuthenticationUiState> emailVerificationCodeUiState = new MutableLiveData();
    private final MutableLiveData<AuthenticationUiState> resetPasswordUiState = new MutableLiveData<>();
    private final MutableLiveData<AuthenticationUiState> changePasswordUiState = new MutableLiveData<>();

    /** Constructs a new instance. */
    @Inject
    public FakeAuthenticationViewModel() {

    }

    @Override
    public MutableLiveData<AuthenticationUiState> getLoginUiState() {
        loginUiState.setValue(new LoginUiState(AuthenticationUiStatus.Idle, ""));
        return loginUiState;
    }

    @Override
    public MutableLiveData<GenerateVerificationCodeUiState> getGenerateVerificationCodeUiState() {
        generateVerificationCodeUiState.setValue(
                new GenerateVerificationCodeUiState(AuthenticationUiStatus.Idle, "")
        );
        return generateVerificationCodeUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getRegistrationUiState() {
        registrationUiState.setValue(new RegistrationUiState(AuthenticationUiStatus.Idle, ""));
        return registrationUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getEmailVerificationCodeUiState() {
        emailVerificationCodeUiState.setValue(new AuthenticationUiState(AuthenticationUiStatus.Idle, ""));
        return emailVerificationCodeUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getResetPasswordUiState() {
        resetPasswordUiState.setValue(new ResetPasswordUiState(AuthenticationUiStatus.Idle, ""));
        return resetPasswordUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getChangePasswordUiState() {
        changePasswordUiState.setValue(new ChangePasswordUiState(AuthenticationUiStatus.Idle, ""));
        return changePasswordUiState;
    }

    @Override
    public void login(String email, String password) {
        //Assumes successful login
        loginUiState.setValue(new LoginUiState(AuthenticationUiStatus.LoginSuccessful, ""));
    }

    @Override
    public void generateVerificationCode(String email, String password, String confirmPassword, String firstName) {
        //Assumes successful otp generation
        generateVerificationCodeUiState.setValue(
                new GenerateVerificationCodeUiState(AuthenticationUiStatus.CodeGeneratedSuccessfully, ""));
    }

    @Override
    public void register(String emailCode) {
        //Assumes successful user registration
        registrationUiState.setValue(
                new RegistrationUiState(AuthenticationUiStatus.LoginSuccessful, "")
        );
    }

    @Override
    public void verifyEmailCode(String emailCode) {
        emailVerificationCodeUiState.setValue(
                new EmailVerificationCodeUiState(AuthenticationUiStatus.CodeVerificationSuccessful, "")
        );
    }

    @Override
    public void resetPassword(String newPassword, String confirmNewPassword) {
        //Assumes successful password reset
        resetPasswordUiState.setValue(
                new ResetPasswordUiState(AuthenticationUiStatus.LoginSuccessful, "")
        );
    }

    @Override
    public void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        //Assumes successful password change
        changePasswordUiState.setValue(
                new ChangePasswordUiState(AuthenticationUiStatus.ChangePasswordSuccessful, "")
        );
    }
}