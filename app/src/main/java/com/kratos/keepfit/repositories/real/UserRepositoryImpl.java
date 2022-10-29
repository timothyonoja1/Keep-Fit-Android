package com.kratos.keepfit.repositories.real;

import android.os.Handler;
import com.kratos.keepfit.core.Result;
import com.kratos.keepfit.core.ResultCallback;
import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.entities.EmailCodeType;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.remotedatasources.interfaces.UserRemoteDataSource;
import com.kratos.keepfit.repositories.interfaces.AgeRangeRepository;
import com.kratos.keepfit.repositories.interfaces.HeightRangeRepository;
import com.kratos.keepfit.repositories.interfaces.SkillLevelRepository;
import com.kratos.keepfit.repositories.interfaces.UserAllergyRepository;
import com.kratos.keepfit.repositories.interfaces.UserFitnessGoalRepository;
import com.kratos.keepfit.repositories.interfaces.UserRepository;
import com.kratos.keepfit.repositories.interfaces.WeeklyTrainingDurationRepository;
import com.kratos.keepfit.repositories.interfaces.WeightRangeRepository;

import java.util.concurrent.Executor;
import javax.inject.Inject;

/** UserRepository Implementation class. */
public class UserRepositoryImpl implements UserRepository {

    private final UserRemoteDataSource userRemoteDataSource;
    private final UserDataStore userDataStore;
    private final AgeRangeRepository ageRangeRepository;
    private final HeightRangeRepository heightRangeRepository;
    private final WeightRangeRepository weightRangeRepository;
    private final SkillLevelRepository skillLevelRepository;
    private final WeeklyTrainingDurationRepository weeklyTrainingDurationRepository;
    private final UserAllergyRepository userAllergyRepository;
    private final UserFitnessGoalRepository userFitnessGoalRepository;
    private final Executor executor;
    private final Handler resultHandler;

    /** Constructs a new instance. */
    @Inject
    public UserRepositoryImpl(
            UserRemoteDataSource userRemoteDataSource, UserDataStore userDataStore,
            AgeRangeRepository ageRangeRepository, HeightRangeRepository heightRangeRepository,
            WeightRangeRepository weightRangeRepository, SkillLevelRepository skillLevelRepository,
            WeeklyTrainingDurationRepository weeklyTrainingDurationRepository,
            UserAllergyRepository userAllergyRepository,
            UserFitnessGoalRepository userFitnessGoalRepository,
            Executor executor, Handler resultHandler) {
        this.userRemoteDataSource = userRemoteDataSource;
        this.userDataStore = userDataStore;
        this.ageRangeRepository = ageRangeRepository;
        this.heightRangeRepository = heightRangeRepository;
        this.weightRangeRepository = weightRangeRepository;
        this.skillLevelRepository = skillLevelRepository;
        this.weeklyTrainingDurationRepository = weeklyTrainingDurationRepository;
        this.userAllergyRepository = userAllergyRepository;
        this.userFitnessGoalRepository = userFitnessGoalRepository;
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
        Result<UserProfile> loginResult = userRemoteDataSource.login(email, password);
        if (loginResult instanceof Result.Error){
            return false;
        }
        UserProfile userProfile = ((Result.Success<UserProfile>) loginResult).data;
        boolean result1 = userDataStore.saveUserProfile(userProfile);

        Result<UserProfileDetail> userProfileDetailResult
                = userRemoteDataSource.getUserProfileDetail(userProfile.getUserProfileID());
        if (userProfileDetailResult instanceof Result.Error){
            return false;
        }

        boolean result2 = true;
        UserProfileDetail userProfileDetail = ((Result.Success<UserProfileDetail>) userProfileDetailResult).data;
        if (userProfileDetail == null) {
            result2 = postUserProfileDetailSync(new UserProfileDetail(
                    0, ageRangeRepository.getAgeSelectedByUser(), Gender.UnSpecified,
                    heightRangeRepository.getHeightSelectedByUser(), weightRangeRepository.getWeightSelectedByUser(),
                    "", "", "", "https://www.facebook.com/dp_image.jpg",
                    0, false, 0, userProfile.getUserProfileID(),
                    ageRangeRepository.getAgeRangeIDSelectedByUser(), heightRangeRepository.getHeightRangeIDSelectedBUser(),
                    weightRangeRepository.getWeightRangeIDSelectedBUser(), skillLevelRepository.getSkillLevelIDSelectedByUser(),
                    weeklyTrainingDurationRepository.getSavedWeeklyTrainingDurationIDOfLoggedInUser()
            ));
        }

        return result1 && result2;
    }

    private boolean postUserProfileDetailSync(UserProfileDetail userProfileDetail) {
        Result<UserProfileDetail> remoteResult
                = userRemoteDataSource.postUserProfileDetail(userProfileDetail);
        if (remoteResult instanceof Result.Error) {
            return false;
        }
        UserProfileDetail userProfileDetailResult = ((Result.Success<UserProfileDetail>) remoteResult).data;
        if (userProfileDetailResult == null) {
            return false;
        }

        return userDataStore.saveUserProfileDetail(userProfileDetail);
    }

    @Override
    public void generateEmailCode(String email, EmailCodeType emailCodeType,
                                  ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = generateEmailCodeSync(email, emailCodeType);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean generateEmailCodeSync(String email, EmailCodeType emailCodeType) {
        return userRemoteDataSource.generateEmailCode(email, emailCodeType);
    }

    @Override
    public void verifyEmailCode(String email, String emailCode, EmailCodeType emailCodeType,
                                ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = verifyEmailCodeSync(email, emailCode, emailCodeType);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean verifyEmailCodeSync(String email, String emailCode, EmailCodeType emailCodeType) {
        return userRemoteDataSource.verifyEmailCode(email, emailCode, emailCodeType);
    }

    @Override
    public void register(String email, String password, String confirmPassword, String emailCode,
                         String firstName, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = registerSync(email, password, confirmPassword, emailCode, firstName);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean registerSync(String email, String password, String confirmPassword,
                                String emailCode, String firstName) {
        return userRemoteDataSource.register(email, password, confirmPassword, emailCode, firstName);
    }

    @Override
    public void resetPassword(String email, String newPassword, String confirmNewPassword,
                              String emailCode, ResultCallback<Boolean> callback) {
        executor.execute(() -> {
            boolean result = resetPasswordSync(email, newPassword, confirmNewPassword, emailCode);
            postBooleanResultToMainThread(result, callback);
        });
    }

    @Override
    public boolean resetPasswordSync(String email, String newPassword,
                                     String confirmNewPassword, String emailCode) {
        return userRemoteDataSource.resetPassword(email, newPassword, confirmNewPassword, emailCode);
    }

    @Override
    public void changePassword(String email, String currentPassword, String newPassword,
                               String confirmNewPassword, ResultCallback<Boolean> callback) {
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
    public void getLoggedInUserProfile(ResultCallback<UserProfile> callback) {
        executor.execute(() -> {
            UserProfile result = getLoggedInUserProfileSync();
            resultHandler.post(() -> callback.onComplete(result)); // Posts result to main thread
        });
    }

    @Override
    public UserProfile getLoggedInUserProfileSync() {
        return userDataStore.getLoggedInUserProfile();
    }

    @Override
    public void getLoggedInUserProfileDetail(ResultCallback<UserProfileDetail> callback) {
        executor.execute(() -> {
            UserProfileDetail result = getLoggedInUserProfileDetailSync();
            resultHandler.post(() -> callback.onComplete(result)); // Posts result to main thread
        });
    }

    @Override
    public UserProfileDetail getLoggedInUserProfileDetailSync() {
        return userDataStore.getLoggedInUserProfileDetail();
    }

    @Override
    public boolean editUserProfileDetailSync(UserProfileDetail userProfileDetail) {
        Result<UserProfileDetail> remoteResult
                = userRemoteDataSource.editUserProfileDetail(userProfileDetail);
        if (remoteResult instanceof Result.Error) {
            return false;
        }
        UserProfileDetail userProfileDetailResult = ((Result.Success<UserProfileDetail>) remoteResult).data;
        if (userProfileDetailResult == null) {
            return false;
        }

        return userDataStore.editUserProfileDetail(userProfileDetail);
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