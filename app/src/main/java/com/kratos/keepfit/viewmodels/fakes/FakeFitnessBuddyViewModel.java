package com.kratos.keepfit.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kratos.keepfit.entities.Gallery;
import com.kratos.keepfit.entities.Gender;
import com.kratos.keepfit.entities.Schedule;
import com.kratos.keepfit.entities.Speciality;
import com.kratos.keepfit.entities.UnrelatedFitnessBuddy;
import com.kratos.keepfit.entities.UserProfile;
import com.kratos.keepfit.entities.UserProfileDetail;
import com.kratos.keepfit.entities.UserRole;
import com.kratos.keepfit.states.FitnessBuddyAccountUiState;
import com.kratos.keepfit.states.FitnessBuddyUiState;
import com.kratos.keepfit.viewmodels.interfaces.FitnessBuddyViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FakeFitnessBuddyViewModel extends ViewModel implements FitnessBuddyViewModel {

    private final List<UnrelatedFitnessBuddy> unrelatedFitnessBuddyList = new ArrayList<>();
    private final List<UnrelatedFitnessBuddy> pendingAcceptanceFitnessBuddyList = new ArrayList<>();
    private final MutableLiveData<FitnessBuddyUiState> fitnessBuddyUiState = new MutableLiveData<>();
    private int selectedFitnessBuddyID;
    private int userProfileIDofSelectedFitnessBuddy;

    @Inject
    public FakeFitnessBuddyViewModel() {
        unrelatedFitnessBuddyList.addAll(getFakeUnrelatedFitnessBuddies());
    }

    @Override
    public MutableLiveData<FitnessBuddyUiState> getFitnessBuddyUiState() {
        refresh();
        return fitnessBuddyUiState;
    }

    @Override
    public MutableLiveData<FitnessBuddyAccountUiState> getFitnessBuddyAccountUiState() {
        MutableLiveData<FitnessBuddyAccountUiState> fitnessBuddyAccountUiState = new MutableLiveData<>();
        fitnessBuddyAccountUiState.setValue(new FitnessBuddyAccountUiState(
                false, getMockUserProfile(userProfileIDofSelectedFitnessBuddy),
                getMockUserProfileDetail(userProfileIDofSelectedFitnessBuddy),
                getMockSpecialities(), getMockGalleries(), getMockSchedules(), new ArrayList<>()
        ));
        return fitnessBuddyAccountUiState;
    }

    @Override
    public void addFitnessBuddy(int fitnessBuddyID) {
        for (UnrelatedFitnessBuddy unrelatedFitnessBuddy : unrelatedFitnessBuddyList) {
            if (unrelatedFitnessBuddy.getFitnessBuddyID() == fitnessBuddyID) {
                unrelatedFitnessBuddyList.remove(unrelatedFitnessBuddy);
                pendingAcceptanceFitnessBuddyList.add(unrelatedFitnessBuddy);
                refresh();
                return;
            }
        }
    }

    private void refresh() {
        fitnessBuddyUiState.setValue(new FitnessBuddyUiState(
                false, unrelatedFitnessBuddyList, pendingAcceptanceFitnessBuddyList
        ));
    }

    @Override
    public void setSelectedFitnessBuddy(int fitnessBuddyID, int userProfileIDofSelectedFitnessBuddy) {
        this.selectedFitnessBuddyID = fitnessBuddyID;
        this.userProfileIDofSelectedFitnessBuddy = userProfileIDofSelectedFitnessBuddy;
    }

    private List<UnrelatedFitnessBuddy> getFakeUnrelatedFitnessBuddies(){

        List<UnrelatedFitnessBuddy> unrelatedFitnessBuddyList = new ArrayList<>();

        unrelatedFitnessBuddyList.add(new UnrelatedFitnessBuddy(
                1, 11, "Tania Hardy", "", "",
                "0.31 mi away. Fitness", "@drawable/tania_dp"));

        unrelatedFitnessBuddyList.add(new UnrelatedFitnessBuddy(
                1, 12, "Leon Small", "", "",
                "1.23 mi away. Aerobic", "@drawable/leon_small_dp"));

        unrelatedFitnessBuddyList.add(new UnrelatedFitnessBuddy(
                1, 13, "Ade Ola", "", "",
                "0.48 mi away. Boxing", "@drawable/adeola_dp"));

        unrelatedFitnessBuddyList.add(new UnrelatedFitnessBuddy(
                1, 14, "Tim Spent", "", "",
                "1.47 mi away. Body Building", "@drawable/tim_spent_dp"));

        return unrelatedFitnessBuddyList;
    }

    private UserProfile getMockUserProfile(int userProfileID) {
        List<UserProfile> userProfiles = getMockUserProfiles();
        for (UserProfile userProfile : userProfiles) {
            if (userProfile.getUserProfileID() == userProfileID) {
                return userProfile;
            }
        }
        return null;
    }

    private List<UserProfile> getMockUserProfiles() {
        List<UserProfile> userProfiles = new ArrayList<>();
        userProfiles.add(new UserProfile(11, "tania@gmail.com", "Tania Hardy",
                "", new Date(), UserRole.Basic));
        userProfiles.add(new UserProfile(12, "leon@gmail.com", "Leon Small",
                "", new Date(), UserRole.Basic));
        userProfiles.add(new UserProfile(13, "ade@gmail.com", "Ade Ola",
                "", new Date(), UserRole.Basic));
        userProfiles.add(new UserProfile(14, "tim@gmail.com", "Tim Spent",
                "", new Date(), UserRole.Basic));
        return userProfiles;
    }

    private UserProfileDetail getMockUserProfileDetail(int userProfileIDofSelectedFitnessBuddy) {
        List<UserProfileDetail> userProfileDetails = getMockUserProfileDetails();
        for (UserProfileDetail userProfileDetail : userProfileDetails) {
            if (userProfileDetail.getUserProfileID() == userProfileIDofSelectedFitnessBuddy){
                return userProfileDetail;
            }
        }
        return null;
    }

    private List<UserProfileDetail> getMockUserProfileDetails() {
        List<UserProfileDetail> userProfileDetails = new ArrayList<>();
        userProfileDetails.add(new UserProfileDetail(
                11, 25, Gender.Male, 280, 80,
                "Hey! My name is Tania and it is my ultimate goal to" +
                        "keep fit and hone my training into a lifestyle. I" +
                        "specialise in Strength and Conditioning training ", "Ondo City",
                "dp_image.jpg", "https://www.facebook.com/dp_image.jpg",
                7, true, 92, 11, 1,
                1, 1, 1, 1
        ));
        userProfileDetails.add(new UserProfileDetail(
                12, 25, Gender.Male, 280, 80,
                "Hey! My name is Leon and it is my ultimate goal to" +
                        "keep fit and hone my training into a lifestyle. I" +
                        "specialise in Strength and Conditioning training ", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 7, true,
                36, 12, 1,
                1, 1, 1,
                1
        ));
        userProfileDetails.add(new UserProfileDetail(
                13, 25, Gender.Male, 280, 80,
                "Hey! My name is Ade and it is my ultimate goal to" +
                        "keep fit and hone my training into a lifestyle. I" +
                        "specialise in Strength and Conditioning training ", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 7, true,
                54, 13, 1,
                1, 1, 1,
                1
        ));
        userProfileDetails.add(new UserProfileDetail(
                14, 25, Gender.Male, 280, 80,
                "Hey! My name is Tim and it is my ultimate goal to" +
                        "keep fit and hone my training into a lifestyle. I" +
                        "specialise in Strength and Conditioning training ", "Ondo City", "dp_image.jpg",
                "https://www.facebook.com/dp_image.jpg", 7, true,
                26, 14, 1,
                1, 1, 1,
                1
        ));
        return userProfileDetails;
    }

    private List<Speciality> getMockSpecialities() {
        List<Speciality> specialities = new ArrayList<>();

        specialities.add(new Speciality(1, "Lose weight and get toned", 1));
        specialities.add(new Speciality(2, "Gain flexibility", 1));
        specialities.add(new Speciality(3, "Build muscle and boost stamina", 1));
        specialities.add(new Speciality(4, "Athletic event or competition", 1));
        specialities.add(new Speciality(5, "Other injuries or medical conditions", 1));

        return specialities;
    }

    private List<Gallery> getMockGalleries() {
        List<Gallery> galleries = new ArrayList<>();

        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "", 1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));
        galleries.add(new Gallery(1, "https://facebook.com/image.jpg", "",  1));

        return galleries;
    }

    private List<Schedule> getMockSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, "07:30 AM", "Available"));
        schedules.add(new Schedule(2, "08:00 AM", "Available"));
        schedules.add(new Schedule(3, "08:00 AM", "Booked"));
        schedules.add(new Schedule(4, "08:30 AM", "Booked"));

        return schedules;
    }
}