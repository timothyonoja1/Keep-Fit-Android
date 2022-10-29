package com.kratos.keepfit.datastores.real;

import android.content.Context;
import android.content.SharedPreferences;

import com.kratos.keepfit.datastores.interfaces.AgeRangeDataStore;
import com.kratos.keepfit.datastores.interfaces.HeightRangeDataStore;
import com.kratos.keepfit.datastores.interfaces.SkillLevelDataStore;
import com.kratos.keepfit.datastores.interfaces.UserDataStore;
import com.kratos.keepfit.datastores.interfaces.WeeklyTrainingDurationDataStore;
import com.kratos.keepfit.datastores.interfaces.WeightRangeDataStore;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import java.util.Date;
import java.util.Objects;
import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class UserDataStoreImpl implements UserDataStore {

    private final Context context;
    private final AgeRangeDataStore ageRangeDataStore;
    private final HeightRangeDataStore heightRangeDataStore;
    private final SkillLevelDataStore skillLevelDataStore;
    private final WeeklyTrainingDurationDataStore weeklyTrainingDurationDataStore;
    private final WeightRangeDataStore weightRangeDataStore;

    @Inject
    public UserDataStoreImpl(
            @ApplicationContext Context context,
            AgeRangeDataStore ageRangeDataStore,
            HeightRangeDataStore heightRangeDataStore,
            SkillLevelDataStore skillLevelDataStore,
            WeeklyTrainingDurationDataStore weeklyTrainingDurationDataStore,
            WeightRangeDataStore weightRangeDataStore){
        this.context = context;
        this.ageRangeDataStore = ageRangeDataStore;
        this.heightRangeDataStore = heightRangeDataStore;
        this.skillLevelDataStore = skillLevelDataStore;
        this.weeklyTrainingDurationDataStore = weeklyTrainingDurationDataStore;
        this.weightRangeDataStore = weightRangeDataStore;
    }

    @Override
    public boolean hasActiveLoginToken() {
        Date todaysDate = new Date();
        Date loginExpiryDate = getLoggedInUserProfile().getLoginTokenExpiryDate();
        // return loginExpiryDate.before(todaysDate);
        return false;
    }

    @Override
    public boolean saveUserProfile(UserProfile userProfile) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("userProfileID", userProfile.getUserProfileID());
        editor.putString("email", userProfile.getEmail());
        editor.putString("firstName", userProfile.getFirstname());
        editor.putString("loginToken", userProfile.getLoginToken());
        editor.putString("loginExpiryDate", userProfile.getLoginTokenExpiryDate().toString());
        editor.putString("userRole", userProfile.getUserRole().toString());

        editor.apply();
        return true;
    }

    @Override
    public UserProfile getLoggedInUserProfile() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        int userProfileID = sharedPref.getInt("userProfileID", 0);
        String email = sharedPref.getString("email", "");
        String firstName = sharedPref.getString("firstName", "");
        String loginToken = sharedPref.getString("loginToken", "");
        String loginExpiryDateString = sharedPref.getString("loginExpiryDate", "");
        Date loginExpiryDate = new Date(loginExpiryDateString);
        String userRoleString = sharedPref.getString("userRole", "");
        UserRole userRole;

        if (Objects.equals(userRoleString, "Admin")) {
            userRole = UserRole.Admin;
        }
        else {
            userRole = UserRole.Basic;
        }

        return new UserProfile(userProfileID, email, firstName, loginToken, loginExpiryDate, userRole);
    }

    @Override
    public boolean deleteLoggedInUser() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("userProfileID", 0);
        editor.putString("email", "");
        editor.putString("firstName", "");
        editor.putString("loginToken", "");
        editor.putString("loginExpiryDate", "");
        editor.putString("userRole", "");

        editor.apply();

        deleteLoggedInUserProfileDetail();
        ageRangeDataStore.deleteAgeRangeSelectedByUser();
        ageRangeDataStore.deleteAgeSelectedByUser();
        heightRangeDataStore.deleteHeightRangeSelectedByUser();
        heightRangeDataStore.deleteHeightSelectedByUser();
        skillLevelDataStore.deleteSkillLevelSelectedByUser();
        weightRangeDataStore.deleteWeightRangeSelectedByUser();
        weightRangeDataStore.deleteWeightSelectedByUser();

        return true;
    }

    @Override
    public boolean saveUserProfileDetail(UserProfileDetail userProfileDetail) {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("userProfileDetailID", userProfileDetail.getUserProfileDetailID());
        editor.putInt("age", userProfileDetail.getAge());
        if (userProfileDetail.getGender() == null) {
            editor.putString("gender",  "UnSpecified");
        }
        else {
            editor.putString("gender",  userProfileDetail.getGender().toString());
        }

        editor.putInt("heightInCM", userProfileDetail.getHeightInCM());
        editor.putInt("weightInKg", userProfileDetail.getWeightInKg());
        editor.putString("description", userProfileDetail.getDescription());
        editor.putString("location", userProfileDetail.getLocation());
        editor.putString("imageUri", userProfileDetail.getImageUri());
        editor.putString("backgroundUrl", userProfileDetail.getBackgroundUri());
        editor.putInt("yearsOfFitnessJourney", userProfileDetail.getYearsOfFitnessJourney());
        editor.putString("available", userProfileDetail.isAvailable()? "true" : "false");
        editor.putInt("numberOfSessions", userProfileDetail.getNumberOfSessions());
        editor.putInt("userProfileID", userProfileDetail.getUserProfileID());
        editor.putInt("ageRangeID", userProfileDetail.getAgeRangeID());
        editor.putInt("heightRangeID", userProfileDetail.getHeightRangeID());
        editor.putInt("weightRangeID", userProfileDetail.getWeightRangeID());
        editor.putInt("skillLevelID", userProfileDetail.getSkillLevelID());
        editor.putInt("weeklyTrainingDurationID", userProfileDetail.getWeeklyTrainingDurationID());

        editor.apply();
        return true;
    }

    @Override
    public boolean editUserProfileDetail(UserProfileDetail userProfileDetail) {
        saveUserProfileDetail(userProfileDetail);
        return true;
    }

    @Override
    public UserProfileDetail getLoggedInUserProfileDetail() {
        SharedPreferences sharedPref = context.getSharedPreferences(
                "KEEP_FIT", Context.MODE_PRIVATE);

        int userProfileDetailID = sharedPref.getInt("userProfileDetailID", 0);
        int age = sharedPref.getInt("age", 0);

        String genderString = sharedPref.getString("gender", "Unspecified");
        Gender gender;
        if (Objects.equals(genderString, "Male")){
            gender = Gender.Male;
        }
        else if (Objects.equals(genderString, "Female")) {
            gender = Gender.Female;
        }
        else {
            gender = Gender.UnSpecified;
        }

        int heightInCM = sharedPref.getInt("heightInCM", 0);
        int weightInKg = sharedPref.getInt("weightInKg", 0);
        String description = sharedPref.getString("description", "");
        String location = sharedPref.getString("location", "");
        String imageUri = sharedPref.getString("imageUri", "");
        String backgroundUrl = sharedPref.getString("backgroundUrl", "");

        int yearsOfFitnessJourney = sharedPref.getInt("yearsOfFitnessJourney", 0);
        String availableString = sharedPref.getString("available", "false");
        boolean available = Objects.equals(availableString, "true");

        int numberOfSessions = sharedPref.getInt("numberOfSessions", 0);
        int userProfileID = sharedPref.getInt("userProfileID", 0);
        int ageRangeID = sharedPref.getInt("ageRangeID", 0);
        int heightRangeID = sharedPref.getInt("heightRangeID", 0);
        int weightRangeID = sharedPref.getInt("weightRangeID", 0);
        int skillLevelID = sharedPref.getInt("skillLevelID", 0);
        int weeklyTrainingDurationID = sharedPref.getInt("weeklyTrainingDurationID", 0);

        return new UserProfileDetail(userProfileDetailID, age, gender, heightInCM, weightInKg, description,
                location, imageUri, backgroundUrl, yearsOfFitnessJourney, available, numberOfSessions,
                userProfileID, ageRangeID, heightRangeID, weightRangeID, skillLevelID, weeklyTrainingDurationID);
    }

    @Override
    public boolean deleteLoggedInUserProfileDetail() {
        saveUserProfileDetail(new UserProfileDetail(0, 0, null, 0, 0,
                "", "", "", "", 0, false,
                0, 0, 0, 0, 0, 0,
                0));
        return true;
    }
}
