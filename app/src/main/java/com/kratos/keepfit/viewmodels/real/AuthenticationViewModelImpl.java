package com.kratos.keepfit.viewmodels.real;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.states.AuthenticationUiState;
import com.kratos.keepfit.states.AuthenticationUiStatus;
import com.kratos.keepfit.states.GenerateVerificationCodeUiState;
import com.kratos.keepfit.utilities.interfaces.ValidationUtility;
import com.kratos.keepfit.viewmodels.interfaces.AuthenticationViewModel;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** AuthenticationViewModel implementation class. */
@HiltViewModel
public class AuthenticationViewModelImpl extends ViewModel implements AuthenticationViewModel {

    private final UserRepository userRepository;
    private final ValidationUtility validationUtility;
    private final MutableLiveData<AuthenticationUiState> loginUiState;
    private final MutableLiveData<GenerateVerificationCodeUiState> generateVerificationCodeUiState;
    private final MutableLiveData<AuthenticationUiState> emailVerificationCodeUiState;
    private final MutableLiveData<AuthenticationUiState> registrationUiState;
    private final MutableLiveData<AuthenticationUiState> resetPasswordUiState;
    private final MutableLiveData<AuthenticationUiState> changePasswordUiState;
    private String userEmail;
    private String password;
    private String confirmPassword;
    private String emailCode;
    private String firstName;

    /** Constructs a new instance. */
    @Inject
    public AuthenticationViewModelImpl(UserRepository userRepository, ValidationUtility validationUtility) {
        this.userRepository = userRepository;
        this.validationUtility = validationUtility;
        loginUiState = new MutableLiveData<>();
        generateVerificationCodeUiState = new MutableLiveData<>();
        emailVerificationCodeUiState = new MutableLiveData<>();
        registrationUiState = new MutableLiveData<>();
        resetPasswordUiState = new MutableLiveData<>();
        changePasswordUiState = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getLoginUiState() {
        reset(loginUiState);
        return loginUiState;
    }

    @Override
    public MutableLiveData<GenerateVerificationCodeUiState> getGenerateVerificationCodeUiState() {
        resetGenerateVerificationCodeUiState(generateVerificationCodeUiState);
        return generateVerificationCodeUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getRegistrationUiState() {
        reset(registrationUiState);
        return registrationUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getEmailVerificationCodeUiState() {
        reset(emailVerificationCodeUiState);
        return emailVerificationCodeUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getResetPasswordUiState() {
        reset(resetPasswordUiState);
        return resetPasswordUiState;
    }

    @Override
    public MutableLiveData<AuthenticationUiState> getChangePasswordUiState() {
        reset(changePasswordUiState);
        return changePasswordUiState;
    }

    @Override
    public void login(String userEmail, String password) {
        loginAuthentication(loginUiState, userEmail, password);
    }

    @Override
    public void generateVerificationCode(String email, String password, String confirmPassword, String firstName) {
        generateVerificationCodeUiState.setValue(new GenerateVerificationCodeUiState(
                AuthenticationUiStatus.GeneratingCode, ""));

        userEmail = email;
        if (validationUtility.isNotValidEmail(email)){
            String errorMessage = "Enter valid inputs";
            generateVerificationCodeUiState.setValue(new GenerateVerificationCodeUiState(
                    AuthenticationUiStatus.InvalidInput, errorMessage));
            return;
        }
        this.userEmail = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        userRepository.generateEmailCode(email, EmailCodeType.Registration, result -> {
            if (result){
                generateVerificationCodeUiState.setValue(new GenerateVerificationCodeUiState(
                        AuthenticationUiStatus.CodeGeneratedSuccessfully, ""));
            }
            else {
                String errorMessage = "Unable to generate OTP code";
                generateVerificationCodeUiState.setValue(new GenerateVerificationCodeUiState(
                        AuthenticationUiStatus.CodeGeneratedSuccessfully, errorMessage));
            }
        });
    }

    @Override
    public void register(String emailCode) {
        resetGenerateVerificationCodeUiState(generateVerificationCodeUiState);
        indicateProcessing(registrationUiState, AuthenticationUiStatus.Registering);
        if (validationUtility.isNotValidEmailCode(emailCode)) {
            String errorMessage = "Enter valid code";
            indicateInvalidInput(registrationUiState, errorMessage);
            return;
        }
        userRepository.register(userEmail, password, confirmPassword, emailCode, firstName, result -> {
            if (result){
                indicateSuccess(registrationUiState, AuthenticationUiStatus.RegistrationSuccessful);
                loginAuthentication(registrationUiState, userEmail, password);
            }
            else {
                String errorMessage = "Unable to register. Ensure that your details are correct";
                indicateFailure(registrationUiState, errorMessage);
            }
        });
    }

    @Override
    public void verifyEmailCode(String emailCode) {
        resetGenerateVerificationCodeUiState(generateVerificationCodeUiState);
        indicateProcessing(emailVerificationCodeUiState, AuthenticationUiStatus.VerifyingCode);
        if (validationUtility.isNotValidEmailCode(emailCode)) {
            String errorMessage = "Enter valid email code";
            indicateInvalidInput(emailVerificationCodeUiState, errorMessage);
            return;
        }
        this.emailCode = emailCode;
        userRepository.verifyEmailCode(userEmail, emailCode, EmailCodeType.ForgotPassword, result -> {
            if (result) {
                indicateSuccess(emailVerificationCodeUiState, AuthenticationUiStatus.CodeVerificationSuccessful);
            }
            else {
                String errorMessage = "Verification failed. Ensure that your details are correct";
                indicateFailure(emailVerificationCodeUiState, errorMessage);
            }
        });
    }

    @Override
    public void resetPassword(String newPassword, String confirmNewPassword) {
        resetGenerateVerificationCodeUiState(generateVerificationCodeUiState);
        indicateProcessing(resetPasswordUiState, AuthenticationUiStatus.ResettingPassword);
        if (!newPassword.equals(confirmNewPassword) || validationUtility.isNotValidPassword(newPassword)) {
            String errorMessage = "Enter passwords that match";
            indicateInvalidInput(resetPasswordUiState, errorMessage);
            return;
        }
        userRepository.resetPassword(userEmail, newPassword, confirmNewPassword, emailCode, result -> {
            if (result) {
                indicateSuccess(resetPasswordUiState, AuthenticationUiStatus.ResetPasswordSuccessful);
                loginAuthentication(resetPasswordUiState, userEmail, newPassword);
            }
            else {
                String errorMessage = "Unable to reset password. Ensure that your details are correct";
                indicateFailure(resetPasswordUiState, errorMessage);
            }
        });
    }

    @Override
    public void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        reset(loginUiState);
        indicateProcessing(changePasswordUiState, AuthenticationUiStatus.ChangingPassword);
        if (!newPassword.equals(confirmNewPassword) || validationUtility.isNotValidPassword(newPassword)
                || validationUtility.isNotValidPassword(currentPassword) || validationUtility.isNotValidEmail(email)){
            String errorMessage = "Enter valid inputs and passwords that match";
            indicateInvalidInput(changePasswordUiState, errorMessage);
            return;
        }
        userRepository.changePassword(userEmail, currentPassword, newPassword, confirmNewPassword, result -> {
            if (result){
                indicateSuccess(changePasswordUiState, AuthenticationUiStatus.ChangePasswordSuccessful);
                loginAuthentication(changePasswordUiState, email, newPassword);
            }
            else {
                String errorMessage = "Unable to change password. Ensure that your details are correct";
                indicateFailure(resetPasswordUiState, errorMessage);
            }
        });
    }

    private void loginAuthentication(MutableLiveData<AuthenticationUiState> authenticationUiState,
                                     String email, String password){
        indicateProcessing(authenticationUiState, AuthenticationUiStatus.LoggingIn);
        if (validationUtility.isNotValidEmail(email) || validationUtility.isNotValidPassword(password)){
            String errorMessage = "Enter valid email and password";
            indicateInvalidInput(authenticationUiState, errorMessage);
            return;
        }
        userRepository.login(email, password, result -> {
            if (result){
                indicateSuccess(authenticationUiState, AuthenticationUiStatus.LoginSuccessful);
            }
            else {
                String errorMessage = "Unable to login. Ensure that your details are correct";
                indicateFailure(authenticationUiState, errorMessage);
            }
        });
    }

    private void indicateProcessing(MutableLiveData<AuthenticationUiState> authenticationUiState,
                                    AuthenticationUiStatus authenticationUiStatus){
        indicate(authenticationUiState, "", authenticationUiStatus);
    }

    private void indicateSuccess(MutableLiveData<AuthenticationUiState> authenticationUiState,
                                 AuthenticationUiStatus authenticationUiStatus){
        indicate(authenticationUiState, "", authenticationUiStatus);
    }

    private void indicateInvalidInput(MutableLiveData<AuthenticationUiState> authenticationUiState,
                                      String errorMessage){
        indicate(authenticationUiState, errorMessage, AuthenticationUiStatus.InvalidInput);
    }

    private void indicateFailure(MutableLiveData<AuthenticationUiState> authenticationUiState,
                                 String errorMessage){
        indicate(authenticationUiState, errorMessage, AuthenticationUiStatus.Failure);
    }

    private void reset(MutableLiveData<AuthenticationUiState> authenticationUiState){
        indicate(authenticationUiState, "", AuthenticationUiStatus.Idle);
    }

    private void resetGenerateVerificationCodeUiState(MutableLiveData<GenerateVerificationCodeUiState> generateVerificationCodeUiState){
        generateVerificationCodeUiState.setValue(
                new GenerateVerificationCodeUiState(AuthenticationUiStatus.Idle, ""));
    }

    private void indicate(MutableLiveData<AuthenticationUiState> authenticationUiState,
                          String errorMessage, AuthenticationUiStatus authenticationUiStatus){
        authenticationUiState.setValue(
                new AuthenticationUiState(authenticationUiStatus, errorMessage));
    }
}