package com.kratos.keepfit.repositories.real;

import android.os.Handler;

import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.User;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.UserRepository;

import java.util.concurrent.Executor;

import javax.inject.Inject;

/** UserRepository Implementation class. */
public class UserRepositoryImpl implements UserRepository {

    private final UserRemoteDataSource userRemoteDataSource;
    private final UserDataStore userDataStore;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public UserRepositoryImpl(UserRemoteDataSource userRemoteDataSource,
                              UserDataStore userDataStore, Executor executor,
                              Handler resultHandler) {
        this.userRemoteDataSource = userRemoteDataSource;
        this.userDataStore = userDataStore;
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    @Override
    public void hasActiveLoginToken(ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = hasActiveLoginTokenSync();
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean hasActiveLoginTokenSync() {
        return userDataStore.hasActiveLoginToken();
    }

    @Override
    public void login(String email, String password, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = loginSync(email, password);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean loginSync(String email, String password) {
        Result<User> loginResult = userRemoteDataSource.login(email, password);
        if (loginResult instanceof Result.Error){
            return false;
        }
        User user = ((Result.Success<User>) loginResult).data;
        Result<UserRole> userRoleResult = userRemoteDataSource.getUserRole();
        if (userRoleResult instanceof Result.Error){
            return false;
        }
        UserRole userRole = ((Result.Success<UserRole>) userRoleResult).data;
        userDataStore.saveUser(new User(email, user.getLoginToken(),
                user.getLoginTokenExpiryDate(), userRole));
        return true;
    }

    @Override
    public void generateEmailCode(String email, EmailCodeType emailCodeType, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = generateEmailCodeSync(email, emailCodeType);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean generateEmailCodeSync(String email, EmailCodeType emailCodeType) {
        return userRemoteDataSource.generateEmailCOde(email, emailCodeType);
    }

    @Override
    public void verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType, ResultCallback<Boolean> callback) {

    }

    @Override
    public boolean verifyEmailCodeSync(String email, String emailCode, EmailCodeType emailCodeType) {
        return false;
    }

    @Override
    public void register(String email, String password, String confirmPassword, String emailCode, String firstName, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = registerSync(email, password, confirmPassword, emailCode, firstName);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean registerSync(String email, String password, String confirmPassword, String emailCode, String firstName) {
        return userRemoteDataSource.register(email, password, confirmPassword, emailCode, firstName);
    }

    @Override
    public void resetPassword(String email, String newPassword, String confirmNewPassword, String emailCode, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = resetPasswordSync(email, newPassword, confirmNewPassword, emailCode);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean resetPasswordSync(String email, String newPassword, String confirmNewPassword, String emailCode) {
        return userRemoteDataSource.resetPassword(email, newPassword, confirmNewPassword, emailCode);
    }

    @Override
    public void changePassword(String email, String currentPassword, String newPassword, String confirmNewPassword, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = changePasswordSync(email, currentPassword, newPassword, confirmNewPassword);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean changePasswordSync(String email, String currentPassword, String newPassword, String confirmNewPassword) {
        return userRemoteDataSource.changePassword(email, currentPassword, newPassword, confirmNewPassword);
    }

    @Override
    public void getLoggedInUser(ResultCallback<User> callback) {
        executor.execute(() -> {
            User result = getLoggedInUserSync();
            resultHandler.post(() -> callback.onComplete(result)); // Posts result to main thread
        });
    }

    @Override
    public User getLoggedInUserSync() {
        return userDataStore.getLoggedInUser();
    }

    @Override
    public void logOut(ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = logOutSync();
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean logOutSync() {
        return userDataStore.deleteLoggedInUser();
    }

    private void postBooleanResultToMainThread(final boolean result,
                                               final ResultCallback<Boolean> callback){
        resultHandler.post(() -> callback.onComplete(result));
    }
}