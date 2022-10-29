package com.kratos.keepfit.entities;

import androidx.room.Entity;
import java.util.Date;

@Entity
public class UserProfileDetail {

    private final int userProfileDetailID;
    private final int age;
    private final Gender gender;
    private final int heightInCM;
    private final int weightInKg;
    private final String description;
    private final String location;
    private final String imageUri;
    private final String backgroundUri;
    private final int yearsOfFitnessJourney;
    private final boolean available;
    private final int numberOfSessions;
    private final int userProfileID;
    private final int ageRangeID;
    private final int heightRangeID;
    private final int weightRangeID;
    private final int skillLevelID;
    private final int weeklyTrainingDurationID;
    private Date dateSavedToLocalDatabase;

    public UserProfileDetail(int userProfileDetailID, int age, Gender gender,
                             int heightInCM, int weightInKg, String description,
                             String location, String imageUri, String backgroundUrl, int yearsOfFitnessJourney, boolean available, int numberOfSessions, int userProfileID, int ageRangeID,
                             int heightRangeID, int weightRangeID, int skillLevelID,
                             int weeklyTrainingDurationID) {
        this.userProfileDetailID = userProfileDetailID;
        this.age = age;
        this.gender = gender;
        this.heightInCM = heightInCM;
        this.weightInKg = weightInKg;
        this.description = description;
        this.location = location;
        this.imageUri = imageUri;
        this.backgroundUri = backgroundUrl;
        this.yearsOfFitnessJourney = yearsOfFitnessJourney;
        this.available = available;
        this.numberOfSessions = numberOfSessions;
        this.userProfileID = userProfileID;
        this.ageRangeID = ageRangeID;
        this.heightRangeID = heightRangeID;
        this.weightRangeID = weightRangeID;
        this.skillLevelID = skillLevelID;
        this.weeklyTrainingDurationID = weeklyTrainingDurationID;
    }

    public int getUserProfileDetailID() {
        return userProfileDetailID;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getBackgroundUri() {
        return backgroundUri;
    }

    public int getYearsOfFitnessJourney() {
        return yearsOfFitnessJourney;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public int getUserProfileID() {
        return userProfileID;
    }

    public int getAgeRangeID() {
        return ageRangeID;
    }

    public int getHeightRangeID() {
        return heightRangeID;
    }

    public int getWeightRangeID() {
        return weightRangeID;
    }

    public int getSkillLevelID() {
        return skillLevelID;
    }

    public int getWeeklyTrainingDurationID() {
        return weeklyTrainingDurationID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
